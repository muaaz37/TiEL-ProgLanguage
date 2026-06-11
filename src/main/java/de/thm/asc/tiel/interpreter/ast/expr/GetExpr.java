package de.thm.asc.tiel.interpreter.ast.expr;

public final class GetExpr extends Expr {
    public final Expr object;
    public final String name;

    public GetExpr(Expr object, String name) {
        this.object = object;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof GetExpr o)) return false;

        return object.equals(o.object) && name.equals(o.name);
    }
}
