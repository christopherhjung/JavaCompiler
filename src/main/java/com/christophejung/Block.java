package com.christophejung;

import com.christophejung.methodexpressions.Statement;

import java.util.List;

public class Block implements Statement
{
    private List<Statement> classExpressions;

    public Block(List<Statement> classExpressions)
    {
        this.classExpressions = classExpressions;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (Statement expression : classExpressions)
        {
            sb.append(expression);
            sb.append(';');
        }

        sb.append("}");


        return sb.toString();
    }
}
