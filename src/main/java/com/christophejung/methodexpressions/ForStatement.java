package com.christophejung.methodexpressions;

import com.christophejung.statements.Expression;

public class ForStatement implements Statement
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
