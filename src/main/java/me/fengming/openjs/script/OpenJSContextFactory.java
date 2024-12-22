package me.fengming.openjs.script;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;

public class OpenJSContextFactory extends ContextFactory {
    public final ScriptManager manager;

    public OpenJSContextFactory(ScriptManager manager) {
        this.manager = manager;
    }

    @Override
    protected Context makeContext() {
        OpenJSContext context = new OpenJSContext(this);
        context.init();
        return context;
    }
}
