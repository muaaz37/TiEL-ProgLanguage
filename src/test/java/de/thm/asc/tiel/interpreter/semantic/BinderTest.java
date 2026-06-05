package de.thm.asc.tiel.interpreter.semantic;

import de.thm.asc.tiel.interpreter.evaluation.Evaluator;
import de.thm.asc.tiel.interpreter.evaluation.Globals;
import de.thm.asc.tiel.interpreter.error.RuntimeError;
import de.thm.asc.tiel.interpreter.lexical.Scanner;
import de.thm.asc.tiel.interpreter.syntax.Parser;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinderTest {

    @Test
    void rejectsReturnOutsideFunction() {
        var error = assertThrows(RuntimeError.class, () -> bind("""
                return 1;
                """));

        assertEquals("Can't return from top-level code.", error.getMessage());
    }

    @Test
    void rejectsReadingVariableInOwnInitializer() {
        var error = assertThrows(RuntimeError.class, () -> bind("""
                {
                    var value = value;
                }
                """));

        assertEquals("Can't read local variable in its own initializer.", error.getMessage());
    }

    @Test
    void acceptsNestedFunctionsAndShadowing() {
        assertDoesNotThrow(() -> bind("""
                var x = 1;
                fun outer(y) {
                    var x = y;
                    fun inner(z) {
                        return x + z;
                    }
                    return inner(2);
                }
                outer(3);
                """));
    }

    @Test
    void acceptsArrayIndexAssignment() {
        assertDoesNotThrow(() -> bind("""
                var x = 1;
                var a= [10,20];
                a[x]= a[0];
        """));
    }

    @Test
    void  rejectsReadingVariableInOwnArrayInitializer() {
        var error = assertThrows(RuntimeError.class, () -> bind("""
            {
                var a = [a];
            }
            """));
        assertEquals("Can't read local variable in its own initializer.", error.getMessage());
    }


        private static void bind(String source) {
        var ast = new Parser(new Scanner(source).scan()).parse();
        var evaluator = new Evaluator(Globals.initEnv(new java.io.PrintStream(new ByteArrayOutputStream())));

        new Binder(evaluator).resolve(ast);
    }
}
