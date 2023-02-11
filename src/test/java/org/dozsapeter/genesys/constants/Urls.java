package org.dozsapeter.genesys.constants;

import org.apache.hc.core5.net.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.asynchttpclient.uri.Uri.HTTPS;

public class Urls {


    public static String SAUCE_DEMO_INVENTORY_URL;
    public static String ONLINE_HTML_EDITOR_URL;
    public static String GURU_99_DEMO_URL;

    static {
        try {
            String SAUCE_DEMO_HOST = "saucedemo.com";
            String SAUCE_DEMO_PATH = "inventory.html";
            SAUCE_DEMO_INVENTORY_URL =
                    new URIBuilder().setScheme(HTTPS)
                                    .setHost(SAUCE_DEMO_HOST)
                                    .setPath(SAUCE_DEMO_PATH)
                                    .build()
                                    .toURL()
                                    .toString();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            String ONLINE_HTML_EDITOR_HOST = "onlinehtmleditor.dev";
            ONLINE_HTML_EDITOR_URL = new URIBuilder().setScheme(HTTPS)
                                                 .setHost(ONLINE_HTML_EDITOR_HOST)
                                                 .build()
                                                 .toURL()
                                                 .toString();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            String GURU_99_DEMO_HOST = "demo.guru99.com";
            GURU_99_DEMO_URL = new URIBuilder().setScheme(HTTPS)
                    .setHost(GURU_99_DEMO_HOST)
                    .setPath("test").appendPath("guru99home")
                    .build()
                    .toURL()
                    .toString();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}