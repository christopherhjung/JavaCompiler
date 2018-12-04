package com.christophejung.methodexpressions;

import com.christophejung.statements.Statement;

public class WhileExpression implements MethodExpression
{
    private Statement condition;
    private MethodExpression expression;

    public WhileExpression(Statement condition, MethodExpression expression)
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
