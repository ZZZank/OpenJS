package me.fengming.openjs.script.file;

import me.fengming.openjs.OpenJS;
import me.fengming.openjs.binding.PackMode;
import me.fengming.openjs.script.OpenJSContext;
import me.fengming.openjs.script.ScriptProperties;
import me.fengming.openjs.script.ScriptProperty;
import net.minecraftforge.fml.ModList;
import org.mozilla.javascript.Script;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ScriptFile {
    public final Path path;
    private Script compiledScript;
    private final ScriptProperties properties = new ScriptProperties();

    public ScriptFile(Path path) {
        this.path = path;
    }

    public void load(OpenJSContext context) {
        try (var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            compiledScript = context.compileReader(reader, path.getFileName().toString(), 1, null);
        } catch (IOException e) {
            OpenJS.LOGGER.error(e.getMessage());
        }
        run(context);
    }

    public void run(OpenJSContext context) {
        compiledScript.exec(context, context.topScope);
    }

    public ScriptProperties getProperties() {
        return properties;
    }

    public int getPriority() {
        return properties.getOrDefault(ScriptProperty.PRIORITY);
    }

    public boolean shouldEnable() {
        return properties.getOrDefault(ScriptProperty.ENABLE)
            && properties.get(ScriptProperty.PACKMODE).map(PackMode.get()::equals).orElse(true)
            && properties.getOrDefault(ScriptProperty.REQUIRE).stream().allMatch(ScriptFile::modLoaded);
    }

    private static boolean modLoaded(String modid) {
        var modlist = ModList.get();
        return modlist == null || modlist.isLoaded(modid);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ScriptFile file && Objects.equals(path, file.path);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(path);
    }
}
