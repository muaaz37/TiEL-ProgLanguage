package de.thm.asc.tiel.interpreter.ast.expr;

import java.util.List;

public final class ArrayLiteralExpr extends Expr {
    // List because every Array element can be an expression itself
    // Example: x+3 in [1, 2, x + 3]
    // or: [ [1, 2], [3, 4] ] contains 2 element arrays
    public final List<Expr> elements;
public ArrayLiteralExpr(List<Expr> elements) {
    this.elements = elements;
}

@Override
    public boolean equals(Object obj) {
    // Both references pointing towards same object
    // In other words: Am I(obj) Myself(this) :)
    if(obj==this) return true;

    // First check the type.
    // When obj is not a ArrayLiteralExpr, it cannot be same.
    if(!(obj instanceof ArrayLiteralExpr other)) return false;
    // Content Comparison:
    // Two ArrayLiteralExpr are same, when their Elements list is same.
    // List.equals(...) compares the Elements of "other" and "elements" in sequence.
    return other.elements.equals(elements);
}

}
