package com.christophejung;

import com.christophejung.methodexpressions.MethodExpression;

import java.util.List;

public class Block implements MethodExpression
{
    private List<MethodExpression> classExpressions;

    public Block(List<MethodExpression> classExpressions)
    {
        this.classExpressions = classExpressions;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (MethodExpression expression : classExpressions)
        {
            sb.append(expression);
            sb.append(';');
        }

        sb.append("}");


        return sb.toString();
    }
}
