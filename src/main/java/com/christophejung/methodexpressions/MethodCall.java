package com.christophejung.methodexpressions;

import com.christophejung.statements.Expression;

import java.util.List;

public class MethodCall implements Statement, Expression
{
    private Expression target;
    private List<Expression> expressions;

    public MethodCall(Expression target, List<Expression> expressions)
    {
        this.target = target;
        this.expressions = expressions;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(target);
        sb.append("(");

        boolean first = false;
        for (Expression expression : expressions)
        {
            if (first)
            {
                sb.append(", ");
            }
            sb.append(expression);
            first = true;
        }

        sb.append(')');

        return sb.toString();
    }
}
