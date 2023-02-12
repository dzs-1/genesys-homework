package org.dozsapeter.genesys.helpers;

import java.util.Map;

public class PrintMap {

    private static final String SEPARATOR = "+---------------------------" +
            "+---------------------------+";

    public static void toTerminal(Map<String, String> map) {
        System.out.println(SEPARATOR);
        System.out.printf("| %-25s | %-25s |%n", "NAME", "EMAIL");
        System.out.println(SEPARATOR);
        for (Object key : map.keySet()) {
            System.out.printf("| %-25s | %-25s |%n", key, map.get(key));
        }
        System.out.println(SEPARATOR);
    }
}
