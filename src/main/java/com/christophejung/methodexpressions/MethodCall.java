package com.christophejung.methodexpressions;

import com.christophejung.statements.Statement;

import java.util.List;

public class MethodCall implements MethodExpression, Statement
{
    private Statement target;
    private List<Statement> statements;

    public MethodCall(Statement target, List<Statement> statements)
    {
        this.target = target;
        this.statements = statements;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(target);
        sb.append("(");

        boolean first = false;
        for (Statement statement : statements)
        {
            if (first)
            {
                sb.append(", ");
            }
            sb.append(statement);
            first = true;
        }

        sb.append(')');

        return sb.toString();
    }
}
