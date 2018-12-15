package com.christophejung;

import com.christopherjung.reflectparser.RuleParser;


public class MainLookahead
{
    public static void main(String[] args)
    {

        System.out.println(new RuleParser().parse("hallo (est | lol)*").toRegEx());
    }
}
