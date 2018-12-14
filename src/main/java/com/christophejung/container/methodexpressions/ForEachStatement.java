package com.christophejung.container.methodexpressions;

import com.christophejung.container.Program;
import com.christophejung.container.statements.Expression;
import com.christophejung.utils.HierarchicalWriter;

public class ForEachStatement extends Program implements Statement
{
    private Declare target;
    private Expression iterator;
    private Statement expression;

    public ForEachStatement(Declare target, Expression iterator, Statement expression)
    {
        this.target = target;
        this.iterator = iterator;
        this.expression = expression;
    }

    public Statement getExpression()
    {
        return expression;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("for(");
        writer.print(target);
        writer.print(" : ");
        writer.print(iterator);
        writer.print(")");
        writer.print(expression);
    }
}
