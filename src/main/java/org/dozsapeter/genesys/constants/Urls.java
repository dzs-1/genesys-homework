package org.dozsapeter.genesys.constants;

import org.apache.hc.core5.net.URIBuilder;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.asynchttpclient.uri.Uri.HTTPS;

public class Urls {

    public static String SAUCE_DEMO_INVENTORY_URL;
    private static String SAUCE_DEMO_HOST = "saucedemo.com";
    private static final String SAUCE_DEMO_PATH = "inventory.html";

    static {
        try {
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
}