package com.christophejung.statements;

import com.christophejung.methodexpressions.Statement;

public class ExpressionNew implements Expression, Statement
{
    private Expression left;

    public ExpressionNew(Expression left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return "new " + left;
    }
}
