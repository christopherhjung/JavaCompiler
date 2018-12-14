package com.christophejung.container;

import com.christophejung.utils.HierarchicalWritable;
import com.christophejung.utils.HierarchicalWriter;

import java.util.ArrayList;
import java.util.List;

public class Type extends Program
{
    private String name;
    private List<Type> generics;

    public Type(String name, List<Type> generics)
    {
        this.name = name;
        this.generics = generics == null ? new ArrayList<>() : generics;
    }

    public Type(String name)
    {
        this(name, new ArrayList<>());
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print(name);

        if( generics.size() > 0){

            writer.print("<");

            boolean first = false;
            for (Type generic : generics)
            {
                if (first)
                {
                    writer.print(", ");
                }
                else
                {
                    first = true;
                }

                writer.print(generic);
            }

            writer.print(">");
        }

    }
}
