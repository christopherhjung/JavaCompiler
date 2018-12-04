package com.christophejung.methodexpressions;

import com.christophejung.statements.Expression;

public class IfStatement implements Statement
{
    private Expression condition;
    private Statement expression;

    public IfStatement(Expression condition, Statement expression)
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
