package com.christophejung.methodexpressions;

import com.christophejung.statements.Statement;

import java.util.List;

public class ForExpression implements MethodExpression
{
    private Statement condition;
    private List<MethodExpression> expressions;
    private MethodExpression init;
    private Statement increment;

    public ForExpression(MethodExpression init, Statement condition, Statement increment, List<MethodExpression> expressions)
    {
        this.init = init;
        this.condition = condition;
        this.increment = increment;
        this.expressions = expressions;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("for(");
        sb.append(init);
        sb.append(" ; ");
        sb.append(condition);
        sb.append(" ; ");
        sb.append(increment);
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
