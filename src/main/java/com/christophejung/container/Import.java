package com.christophejung.container;

import com.christophejung.utils.HierarchicalWriter;

import java.util.List;

public class Import extends Program
{
    private String path;

    public Import(String path)
    {
        this.path = path;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("import ");
        writer.print(path);
    }
}
