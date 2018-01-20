package ru.edisoft;

import java.util.*;

public class ElementsRemover {

    public static <V> List<V> removeRepeatedInARowSequence(List<V> list, int seqSize) {
        check(list, seqSize);
        int repeatedIndex = -1;
        V previousElement = null;
        V currentElement;
        int count = 0;
        for (int index = 0; index < list.size(); index++) {
            currentElement = list.get(index);
            if (repeatedIndex == -1) {
                repeatedIndex = index;
                previousElement = currentElement;
                count = 1;
            } else if (isEquals(currentElement, previousElement)) {
                count++;
                if (count >= seqSize) {
                    for (int j = repeatedIndex; j <= index; j++) {
                        list.remove(repeatedIndex);
                    }
                    index = repeatedIndex - 1;
                }
            } else {
                repeatedIndex = index;
                previousElement = currentElement;
                count = 1;
            }
        }
        return list;
    }

    public static <V> List<V> removeRepeatedRandomSequence(List<V> list, int seqSize) {
        check(list, seqSize);
        list.removeAll(findRepeated(list, seqSize));
        return list;
    }

    private static <V> Set<V> findRepeated(List<V> list, int seqSize) {
        Map<V, Integer> countsMap = new HashMap<V, Integer>();
        for (V element : list) {
            if (countsMap.containsKey(element)) {
                countsMap.put(element, countsMap.get(element) + 1);
            } else {
                countsMap.put(element, 1);
            }
        }
        for (Iterator<Map.Entry<V, Integer>> it = countsMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<V, Integer> entry = it.next();
            if (entry.getValue() < seqSize) {
                it.remove();
            }
        }
        return countsMap.keySet();
    }

    private static <V> void check(List<V> list, int seqSize) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Incorrect list");
        }
        if (seqSize < 2) {
            throw new IllegalArgumentException("Incorrect size of sequence");
        }
    }

    private static <V> boolean isEquals(V first, V second) {
        return (nonNull(first) && first.equals(second))
                || (isNull(first) && isNull(second));
    }

    private static <V> boolean nonNull(V value) {
        return !isNull(value);
    }

    private static <V> boolean isNull(V value) {
        return value == null;
    }

}