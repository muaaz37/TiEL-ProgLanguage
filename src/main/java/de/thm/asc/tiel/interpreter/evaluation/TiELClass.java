package de.thm.asc.tiel.interpreter.evaluation;

import de.thm.asc.tiel.interpreter.lexical.Token;

import java.util.List;
import java.util.Map;

/**
 * Runtime representation of a TiEL class.
 */
class TiELClass implements TiELCallable {

    private final String name;
    private final Map<String, TiELFunction> methods;

    TiELClass(String name, Map<String, TiELFunction> methods) {
        this.name = name;
        this.methods = methods;
    }

    @Override
    public int arity() {
        var initializer = findMethod(name);
        return initializer == null ? 0 : initializer.arity();
    }

    @Override
    public TiELValue call(Evaluator evaluator, List<TiELValue> arguments, Token.Position errorPosition) {
        var instance = new TiELInstance(this);
        var initializer = findMethod(name);

        if (initializer != null) {
            initializer.bind(instance).call(evaluator, arguments, errorPosition);
        }

        return instance;
    }

    TiELFunction findMethod(String name) {
        return methods.get(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
