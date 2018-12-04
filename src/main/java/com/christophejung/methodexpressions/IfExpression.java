package com.christophejung.methodexpressions;

import com.christophejung.statements.Statement;

public class IfExpression implements MethodExpression
{
    private Statement condition;
    private MethodExpression expression;

    public IfExpression(Statement condition, MethodExpression expression)
    {
        this.condition = condition;
        this.expression = expression;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("if(");
        sb.append(condition);
        sb.append(")");

        sb.append(expression);
        return sb.toString();
    }
}
