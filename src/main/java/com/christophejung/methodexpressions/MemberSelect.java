package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.statements.Expression;
import com.christophejung.statements.ExpressionVariable;

public class MemberSelect extends Program implements Statement, Expression
{
    private Expression expression;
    private String name;

    public MemberSelect(Expression expression, String name)
    {
        this.expression = expression;
        this.name = name;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(expression);
        writer.print(".");
        writer.print(name);
    }
}
