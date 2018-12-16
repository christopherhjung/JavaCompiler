package com.christophejung.symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassLookupTable
{
    private List<Symbol> variables = new ArrayList<>();
    private List<Symbol> functions = new ArrayList<>();
    private HashMap<Symbol,List<Symbol>> functionVariables = new HashMap<>();
}
