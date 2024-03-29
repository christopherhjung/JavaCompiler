package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.statements.Expression;

import java.util.List;

public class MethodCall extends Program implements Statement, Expression
{
    private Expression target;
    private List<Expression> expressions;

    public MethodCall(Expression target, List<Expression> expressions)
    {
        this.target = target;
        this.expressions = expressions;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(target);
        writer.print("(");

        boolean first = false;
        for (Expression expression : expressions)
        {
            if (first)
            {
                writer.print(", ");
            }
            writer.print(expression);
            first = true;
        }

        writer.print(")");
    }
}
