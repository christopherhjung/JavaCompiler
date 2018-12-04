package com.christophejung.methodexpressions;

import com.christophejung.statements.Expression;
import com.christophejung.statements.ExpressionVariable;

public class MemberSelect implements Statement, Expression
{
    private Expression expression;
    private Expression methodCall;

    public MemberSelect(Expression expression, Expression methodCall)
    {
        this.expression = expression;
        this.methodCall = methodCall;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(expression);
        sb.append(".");
        sb.append(methodCall);

        return sb.toString();
    }
}
