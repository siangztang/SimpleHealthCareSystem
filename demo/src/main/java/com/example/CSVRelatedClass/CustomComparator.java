package com.example.CSVRelatedClass;

import java.util.Comparator;
import java.util.function.Function;

public class CustomComparator {

    public static <T> Comparator<T> createComparator(Function<T, String> idExtractor) {
        return (d1, d2) -> {
            String prefix1 = idExtractor.apply(d1).substring(0, 1);
            String prefix2 = idExtractor.apply(d2).substring(0, 1);
            int id1 = Integer.parseInt(idExtractor.apply(d1).substring(1));
            int id2 = Integer.parseInt(idExtractor.apply(d2).substring(1));

            if (prefix1.compareTo(prefix2) != 0) {
                return prefix1.compareTo(prefix2);
            } else if (id1 != id2) {
                return Integer.compare(id1, id2);
            } else {
                return d1.toString().compareTo(d2.toString());
            }
        };
    }
}
