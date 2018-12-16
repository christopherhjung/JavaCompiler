package com.christophejung.container.methodexpressions;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.statements.Expression;

public class MemberSelect extends Program implements Statement, Expression
{
    private Expression expression;
    private String name;

    public MemberSelect(Expression expression, String name)
    {
        this.expression = expression;
        this.name = name;
    }

    public Expression getExpression()
    {
        return expression;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(expression);
        writer.print(".");
        writer.print(name);
    }
}
