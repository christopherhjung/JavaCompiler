package com.christophejung.methodexpressions;

import com.christophejung.statements.Expression;

public class WhileStatement implements Statement
{
    private Expression condition;
    private Statement expression;

    public WhileStatement(Expression condition, Statement expression)
    {
        this.condition = condition;
        this.expression = expression;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("while(");
        sb.append(condition);
        sb.append(")");

        sb.append(expression);
        return sb.toString();
    }
}
