package de.thm.asc.tiel.interpreter.ast.expr;

// Problem: We have Expr like a[0] oder a[x] or more complex like
/*
matrix[1][0]
foo()[2]
makePair(4, 9)[0]
arr[i + 1]
 */

// What is being accessed? Variable a or some expression
// Which index is used for access? expression which results to index
public final class IndexExpr extends Expr{

    public final Expr target;
    public final Expr index;
    public IndexExpr(Expr target, Expr index) {
        this.index = index;
        this.target = target;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof IndexExpr other)) return false;
        return target.equals(other.target) && index.equals(other.index);
    }

}
