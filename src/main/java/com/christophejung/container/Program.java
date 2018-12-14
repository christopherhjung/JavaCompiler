package com.christophejung.container;

import com.christophejung.utils.HierarchicalWritable;
import com.christophejung.utils.HierarchicalWriter;

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
