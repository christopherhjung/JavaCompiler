package com.christophejung.container.methodexpressions;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.statements.Expression;

public class WhileStatement extends Program implements Statement
{
    private Expression condition;
    private Statement expression;

    public WhileStatement(Expression condition, Statement expression)
    {
        this.condition = condition;
        this.expression = expression;
    }

    public Expression getCondition()
    {
        return condition;
    }

    public Statement getExpression()
    {
        return expression;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("while(");
        writer.print(condition);
        writer.print(")");

        writer.print(expression);
    }
}
