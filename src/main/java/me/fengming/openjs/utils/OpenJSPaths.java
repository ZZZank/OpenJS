package me.fengming.openjs.utils;

import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.Path;

public class OpenJSPaths {
    public static final Path GAMEDIR = FMLPaths.GAMEDIR.get();
    public static final Path JSPATH = GAMEDIR.resolve("openjs");

    public static final Path CONFIG = JSPATH.resolve("config.json");
    public static final Path STARTUP = JSPATH.resolve("startup");
    public static final Path SERVER = JSPATH.resolve("server");
    public static final Path CLIENT = JSPATH.resolve("client");

    public static void check() {
        try {
            Utils.checkPath(STARTUP);
            Utils.checkPath(SERVER);
            Utils.checkPath(CLIENT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
