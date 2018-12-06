package com.christophejung;

import com.christopherjung.grammar.Grammar;
import com.christopherjung.grammar.ModifierSource;
import com.christopherjung.reflectparser.ReflectScannerGenerator;
import com.christopherjung.reflectparser.ReflectTLDGenerator;
import com.christopherjung.scanner.ScanJob;
import com.christopherjung.scanner.Scanner;
import com.christopherjung.translator.ParserTable;
import com.christopherjung.translator.ParserTableGenerator;
import com.christopherjung.translator.TDLParser;
import com.christopherjung.translator.TDLUtils;


public class MainLookahead
{
    public static void main(String[] args)
    {
        Scanner.Builder builder = new Scanner.Builder();
        builder.addAll(StreamUtils.getFileStream("nullable.scanner"));
        Scanner scanner = builder.build();

        Grammar.Builder grammarBuilder = new Grammar.Builder();
        grammarBuilder.addRules(StreamUtils.getFileStream("nullable.tdl"));
        Grammar grammar = grammarBuilder.build();

        ParserTable table = new ParserTableGenerator().generate(grammar);

        System.out.println(TDLUtils.toString(table));
    }
}
