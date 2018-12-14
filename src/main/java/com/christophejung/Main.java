package com.christophejung;

import com.christophejung.container.ClassContainer;
import com.christophejung.container.classexpressions.ClassStatement;
import com.christophejung.container.classexpressions.MethodContainer;
import com.christophejung.symbol.SymbolLookup;
import com.christophejung.utils.StreamUtils;
import com.christopherjung.reflectparser.ReflectScannerGenerator;
import com.christopherjung.reflectparser.ReflectTLDGenerator;
import com.christopherjung.scanner.ScanJob;
import com.christopherjung.scanner.Scanner;
import com.christopherjung.translator.TDLParser;


public class Main
{
    public static void main(String[] args)
    {
        TDLParser parser = new ReflectTLDGenerator().generate(JavaParser.class);
        System.out.println("Generate scanner");
        Scanner scanner = ReflectScannerGenerator.generate(JavaParser.class);

        System.out.println("Finish");

        Object o = "No Data";
        long count = 0;
        long sum = 0;
        long measurements = 1;

        try
        {
            for (int i = 0; i < measurements; i++)
            {
                ScanJob scanJob = new ScanJob(scanner, StreamUtils.getFileStream("test.java"));

                long start = System.currentTimeMillis();
                o = parser.parse(scanJob);
                long end = System.currentTimeMillis();
                sum += end - start;
                count++;
            }
            System.out.println((float) sum / count);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        ClassContainer classContainer = (ClassContainer) o;

        for (ClassStatement statement : classContainer.getClassStatements())
        {

            if (statement instanceof MethodContainer)
            {
                MethodContainer container = (MethodContainer) statement;

                System.out.println(SymbolLookup.lookup(container.getExpression()));
            }
        }

    }
}
