package com.christophejung.methodexpressions;

import com.christophejung.statements.Statement;

public class ForExpression implements MethodExpression
{
    private Statement condition;
    private MethodExpression expression;
    private MethodExpression init;
    private Statement increment;

    public ForExpression(MethodExpression init, Statement condition, Statement increment, MethodExpression expression)
    {
        this.init = init;
        this.condition = condition;
        this.increment = increment;
        this.expression = expression;
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
        sb.append(")");

        sb.append(expression);

        return sb.toString();
    }
}
