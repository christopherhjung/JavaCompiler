package com.christophejung.container.methodexpressions;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.statements.Expression;

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

    public Statement getIfBranch()
    {
        return ifBranch;
    }

    public Statement getElseBranch()
    {
        return elseBranch;
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
