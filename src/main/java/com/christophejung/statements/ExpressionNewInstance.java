package com.christophejung.statements;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;
import com.christophejung.methodexpressions.Statement;

import java.util.List;

public class ExpressionNewInstance extends Program implements Expression, Statement
{
    private Expression target;
    private List<Expression> values;

    public ExpressionNewInstance(Expression target, List<Expression> values)
    {
        this.target = target;
        this.values = values;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("new ");
        writer.print(target);
        writer.print("(");

        boolean first = false;
        for (Expression expression : values)
        {
            if (first)
            {
                writer.print(", ");
            }
            writer.print(expression);
            first = true;
        }

        writer.print(')');
    }
}
