package com.christophejung;

import com.christophejung.classexpressions.ClassStatement;
import com.christophejung.methodexpressions.Statement;

import java.util.List;

public class Block extends Program implements Statement, ClassStatement
{
    private List<Statement> classExpressions;

    public Block(List<Statement> classExpressions)
    {
        this.classExpressions = classExpressions;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.println("{");
        writer.enterLevel();

        for (Statement expression : classExpressions)
        {
            writer.print(expression);
            if( !writer.isNewLine() ) writer.println(";");
        }

        writer.leaveLevel();
        writer.println("}");
    }
}
