package org.dozsapeter.genesys;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileResolver {

    private FileResolver() {}

    public static String getFileAsStringFromResources(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get("src", "test", "resources", "files", fileName)));
    }
}
