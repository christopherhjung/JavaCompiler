package com.christophejung.container;

import com.christophejung.utils.HierarchicalWriter;

import java.util.List;

public class ProgramFile extends Program
{
    private String name;
    private List<Import> imports;
    private List<ClassContainer> classes;

    public ProgramFile(String name, List<Import> imports, List<ClassContainer> classes)
    {
        this.name = name;
        this.imports = imports;
        this.classes = classes;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(name);
        writer.println();
        writer.println(imports);
        writer.println();
        writer.println(classes);
    }
}
