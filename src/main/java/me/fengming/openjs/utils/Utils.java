package me.fengming.openjs.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {
    public static void checkPath(Path path) throws IOException {
        if (Files.exists(path)) {
            return;
        }

        if (path.getFileName().toString().lastIndexOf('.') == -1) {
            Files.createDirectories(path);
        } else {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
        }
    }
}
