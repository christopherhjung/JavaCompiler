package com.christophejung.methodexpressions;

import com.christophejung.statements.Statement;

import java.util.List;

public class IfExpression implements MethodExpression
{
    private Statement condition;
    private List<MethodExpression> expressions;

    public IfExpression(Statement condition, List<MethodExpression> expressions)
    {
        this.condition = condition;
        this.expressions = expressions;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("if(");
        sb.append(condition);
        sb.append("){");

        for (MethodExpression expression : expressions)
        {
            sb.append(expression);
            sb.append(';');
        }

        sb.append("}");

        return sb.toString();
    }
}
