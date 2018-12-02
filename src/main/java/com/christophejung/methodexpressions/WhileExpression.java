package com.christophejung.methodexpressions;

import com.christophejung.statements.Statement;

import java.util.List;

public class WhileExpression implements MethodExpression
{
    private Statement condition;
    private List<MethodExpression> expressions;

    public WhileExpression(Statement condition, List<MethodExpression> expressions)
    {
        this.condition = condition;
        this.expressions = expressions;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("while(");
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
