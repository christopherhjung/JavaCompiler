package com.christophejung;

public abstract class Program implements HierarchicalWritable
{
    @Override
    public String toString()
    {
        HierarchicalWriter writer = new HierarchicalWriter();
        writer.print(this);
        return writer.toString();
    }
}
