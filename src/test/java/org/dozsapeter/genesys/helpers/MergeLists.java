package org.dozsapeter.genesys.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeLists {

    public static <K, V> Map<K, V> toMap(List<K> keys, List<V> values) {
        Iterator<K> keyIterator = keys.iterator();
        Iterator<V> valueIterator = values.iterator();
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(i -> keyIterator.next(), i -> valueIterator.next()));
    }
}
