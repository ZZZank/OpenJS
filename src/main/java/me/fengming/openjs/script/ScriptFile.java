package me.fengming.openjs.script;

import me.fengming.openjs.OpenJS;
import org.mozilla.javascript.Script;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScriptFile {
    private final Path path;
    private Script compiledScript;

    public ScriptFile(Path path) {
        this.path = path;
    }

    public void load(OpenJSContext context) {
        try {
            String lines = Files.readString(path, StandardCharsets.UTF_8);
            compiledScript = context.compileString(lines, path.getFileName().toString(), 1, null);
        } catch (IOException e) {
            OpenJS.LOGGER.error(e.getMessage());
        }
        run(context);
    }

    public void run(OpenJSContext context) {
        compiledScript.exec(context, context.topScope);
    }
}
