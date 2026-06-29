package de.thm.asc.tiel.interpreter.evaluation;

import de.thm.asc.tiel.interpreter.error.RuntimeError;
import de.thm.asc.tiel.interpreter.lexical.Token;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime object created from a TiEL class.
 */
final class TiELInstance implements TiELValue {

    private final TiELClass klass;
    private final Map<String, TiELValue> fields = new HashMap<>();

    TiELInstance(TiELClass klass) {
        this.klass = klass;
    }

    TiELValue get(String name, Token.Position errorPosition) {
        if (fields.containsKey(name)) {
            return fields.get(name);
        }

        var method = klass.findMethod(name);
        if (method != null) {
            return method.bind(this);
        }

        throw new RuntimeError("Undefined property '%s'.".formatted(name), errorPosition);
    }

    void set(String name, TiELValue value) {
        fields.put(name, value);
    }

    @Override
    public String toString() {
        return "%s instance".formatted(klass);
    }
}
