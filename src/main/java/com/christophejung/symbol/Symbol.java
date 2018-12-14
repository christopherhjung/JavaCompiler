package com.christophejung.symbol;

import com.christophejung.container.Type;

public class Symbol
{
    private String name;
    private Type type;

    public Symbol(String name, Type type)
    {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString()
    {
        return type + " " + name;
    }
}