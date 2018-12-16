package com.christophejung.container;

import com.christophejung.container.classexpressions.ClassStatement;
import com.christophejung.container.methodexpressions.Statement;
import com.christophejung.utils.HierarchicalWriter;

import java.util.Collections;
import java.util.List;

public class Block extends Program implements Statement, ClassStatement
{
    private List<Statement> classExpressions;

    public Block(List<Statement> classExpressions)
    {
        this.classExpressions = classExpressions;
    }

    public List<Statement> getExpressions()
    {
        return Collections.unmodifiableList(classExpressions);
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.println("{");
        writer.enterLevel();

        if (classExpressions != null)
        {
            for (Statement expression : classExpressions)
            {
                writer.print(expression);
                if (!writer.isNewLine()) writer.println(";");
            }
        }else{
            writer.println("null");
        }

        writer.leaveLevel();
        writer.println("}");
    }
}
