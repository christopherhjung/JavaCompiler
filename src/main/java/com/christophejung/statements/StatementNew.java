package com.christophejung.statements;

import com.christophejung.methodexpressions.MethodCall;
import com.christophejung.methodexpressions.MethodExpression;

public class StatementNew implements Statement, MethodExpression
{
    private MethodCall left;

    public StatementNew(MethodCall left)
    {
        this.left = left;
    }

    @Override
    public String toString()
    {
        return "new " + left;
    }
}
