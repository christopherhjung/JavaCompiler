package com.christophejung.utils;

import java.util.Collection;
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

    public void println(Collection<?> objs)
    {
        if (objs == null)
        {
            return;
        }

        for (Object obj : objs)
        {
            println(obj);
        }
    }

    public void printSeparated(Collection<?> objs, String separator)
    {
        boolean first = false;
        for (Object obj : objs)
        {
            if (first)
            {
                println(separator);
            }
            print(obj);
            first = true;
        }
    }

    public void println(Collection<?> objs, String separator)
    {
        if(objs == null){
            return;
        }

        for (Object obj : objs)
        {
            print(obj);
            println(separator);
        }
    }

    public void println(Object obj)
    {
        print(obj);
        println();
    }

    public void println(CharSequence str)
    {
        print(str);
        println();
    }

    public void println()
    {
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
