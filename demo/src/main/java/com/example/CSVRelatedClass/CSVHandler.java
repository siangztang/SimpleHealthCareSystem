package com.example.CSVRelatedClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.lang.reflect.Field;


public class CSVHandler {
    public <T> ObservableList<T> readCSV(String filePath, Class<T> clazz, Class<?>... parameterTypes) {
        return readCSV(filePath, clazz, null, parameterTypes);
    }

    public <T> ObservableList<T> readCSV(String filePath, Class<T> clazz, Comparator<T> comparator,
            Class<?>... parameterTypes) {
        List<T> objects = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypes);
                int parameterCount = constructor.getParameterCount();

                // Check if the number of parameters matches the CSV data columns
                if (parameterCount == data.length) {
                    Object[] arguments = new Object[parameterCount];
                    for (int i = 0; i < parameterCount; i++) {
                        Class<?> parameterType = constructor.getParameterTypes()[i];
                        arguments[i] = convertToType(data[i], parameterType);
                    }

                    T object = constructor.newInstance(arguments);
                    objects.add(object);
                } else {
                    // Handle the case when the number of parameters does not match
                    throw new IllegalArgumentException("The number of parameters does not match");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (comparator != null) {
            objects.sort(comparator);
        }

        return FXCollections.observableList(objects);
    }

    public <T> ObservableList<T> readCSVSpecific(String filePath, Class<T> clazz, String getColumnName, String getValue, Class<?>... parameterTypes) {
        ObservableList<T> objects = FXCollections.observableArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Constructor<T> constructor = clazz.getDeclaredConstructor(parameterTypes);
                int parameterCount = constructor.getParameterCount();

                // Check if the number of parameters matches the CSV data columns
                if (parameterCount == data.length) {
                    Object[] arguments = new Object[parameterCount];
                    for (int i = 0; i < parameterCount; i++) {
                        Class<?> parameterType = constructor.getParameterTypes()[i];
                        arguments[i] = convertToType(data[i], parameterType);
                    }

                    T object = constructor.newInstance(arguments);

                    // Check if the id matches the specified value
                    String matchValue = getFieldValue(object, getColumnName);
                    if (matchValue != null && matchValue.equals(getValue)) {
                        objects.add(object);
                    }
                } else {
                    // Handle the case when the number of parameters does not match
                    throw new IllegalArgumentException("The number of parameters does not match");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objects;
    }

    private static Object convertToType(String value, Class<?> targetType) {
        if (targetType == String.class) {
            return value;
        } else if (targetType == int.class || targetType == Integer.class) {
            return Integer.parseInt(value);
        } else if (targetType == double.class || targetType == Double.class) {
            return Double.parseDouble(value);
        } else if (targetType == boolean.class || targetType == Boolean.class) {
            return Boolean.parseBoolean(value);
        } else {
            throw new IllegalArgumentException("Unsupported parameter type: " + targetType.getSimpleName());
        }
    }

    private static String getFieldValue(Object object, String fieldName) {
        try {
            return object.getClass().getMethod("get" + capitalize(fieldName)).invoke(object).toString();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public <T> void writeCSV(String filePath, T object) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(getCSVLine(object));
            writer.newLine();
            System.out.println("Data appended to CSV file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCSVLine(Object object) {
        StringBuilder line = new StringBuilder();
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                line.append(value).append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Remove the trailing comma
        if (line.length() > 0) {
            line.setLength(line.length() - 1);
        }

        return line.toString();
    }
}
