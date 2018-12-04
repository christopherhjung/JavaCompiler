package com.christophejung.methodexpressions;

import com.christophejung.statements.Statement;
import com.christophejung.statements.StatementVariable;
import com.christopherjung.regex.State;

import java.util.List;

public class MemberSelect implements MethodExpression, Statement
{
    private Statement statement;
    private StatementVariable methodCall;

    public MemberSelect(Statement statement, StatementVariable methodCall)
    {
        this.statement = statement;
        this.methodCall = methodCall;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(statement);
        sb.append(".");
        sb.append(methodCall);

        return sb.toString();
    }
}
