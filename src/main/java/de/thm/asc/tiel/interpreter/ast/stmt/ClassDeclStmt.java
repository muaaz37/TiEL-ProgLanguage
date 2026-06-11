package de.thm.asc.tiel.interpreter.ast.stmt;
import java.util.List;

public final class ClassDeclStmt extends Stmt {
    public final String name;
    /* Class has more than one method */
    public final List<FunctionDeclStmt> methods;
    public ClassDeclStmt(String name, List<FunctionDeclStmt> methods) {
        this.name = name;
        this.methods = methods;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof ClassDeclStmt o)) return false;

        return name.equals(o.name) && methods.equals(o.methods);
    }

}
