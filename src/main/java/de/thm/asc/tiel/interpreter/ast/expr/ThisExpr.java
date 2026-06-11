package de.thm.asc.tiel.interpreter.ast.expr;

// Simply the object that GetExpr accesses.
public final class ThisExpr extends Expr {

    public ThisExpr() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ThisExpr;
    }
}