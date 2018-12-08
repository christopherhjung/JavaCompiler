package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.statements.Expression;

public class IfElseStatement extends Program implements Statement
{
    private Expression condition;
    private Statement ifBranch;
    private Statement elseBranch;

    public IfElseStatement(Expression condition, Statement ifBranch, Statement elseBranch)
    {
        this.condition = condition;
        this.ifBranch = ifBranch;
        this.elseBranch = elseBranch;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("if(");
        writer.print(condition);
        writer.print(")");
        writer.print(ifBranch);
        writer.print("else ");
        writer.print(elseBranch);
    }
}
