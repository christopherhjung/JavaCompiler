package com.christophejung.container.methodexpressions;

import com.christophejung.utils.HierarchicalWriter;
import com.christophejung.container.Program;
import com.christophejung.container.statements.Expression;

public class ForStatement extends Program implements Statement
{
    private Expression condition;
    private Statement expression;
    private Statement init;
    private Expression increment;

    public ForStatement(Statement init, Expression condition, Expression increment, Statement expression)
    {
        this.init = init;
        this.condition = condition;
        this.increment = increment;
        this.expression = expression;
    }

    public Statement getExpression()
    {
        return expression;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("for(");
        writer.print(init);
        writer.print(" ; ");
        writer.print(condition);
        writer.print(" ; ");
        writer.print(increment);
        writer.print(")");
        writer.print(expression);
    }
}
