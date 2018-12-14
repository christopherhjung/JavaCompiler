package com.christophejung;

import com.christopherjung.regex.ConcatStates;
import com.christopherjung.regex.Pattern;
import com.christopherjung.regex.State;

import java.util.LinkedHashMap;


public class MainLookahead
{
    public static void main(String[] args)
    {
        var stat = Pattern.compile("ab(?=[c])");
        var next = Pattern.compile("[abc]+");

        var map = new LinkedHashMap<String, State<Character>>();

        map.put("if", stat);
        map.put("word", next);

        ConcatStates.create(map);
    }
}
