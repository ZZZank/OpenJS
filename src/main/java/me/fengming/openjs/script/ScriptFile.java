package me.fengming.openjs.script;

import com.google.common.base.Charsets;
import me.fengming.openjs.OpenJS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EvaluatorScriptFile implements IScriptFile {
    private final Path path;

    public EvaluatorScriptFile(Path path) {
        this.path = path;
    }

    @Override
    public void load(OpenJSContext context) {
        try {
            String lines = Files.readString(path, Charsets.UTF_8);
            context.evaluateString(context.topScope, lines, path.getFileName().toString(), 1, null);
        } catch (IOException e) {
            OpenJS.LOGGER.error(e.getMessage());
        }
    }
}
