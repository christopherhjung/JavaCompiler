package com.christophejung;

import java.util.Objects;

public class HierarchicalWriter
{
    private StringBuilder builder;
    private int level;
    private boolean levelWritten = false;

    public HierarchicalWriter()
    {
        builder = new StringBuilder();
        level = 0;
    }

    public boolean isNewLine()
    {
        return !levelWritten;
    }

    public void enterLevel()
    {
        level++;
    }

    public void leaveLevel()
    {
        if (level == 0)
        {
            throw new RuntimeException("Negative Level not allowed");
        }

        level--;
    }

    public void println(CharSequence str)
    {
        print(str);
        builder.append('\n');
        levelWritten = false;
    }

    public void print(Object obj)
    {
        if (obj instanceof HierarchicalWritable)
        {
            HierarchicalWritable writable = (HierarchicalWritable) obj;

            writable.write(this);
        }
        else
        {
            print(Objects.toString(obj));
        }
    }

    public void print(CharSequence str)
    {
        printLevel();
        builder.append(str);
    }

    public void printLevel()
    {
        if (!levelWritten)
        {
            levelWritten = true;
            for (int i = 0; i < level; i++)
            {
                builder.append("    ");
            }
        }
    }

    @Override
    public String toString()
    {
        return builder.toString();
    }
}
