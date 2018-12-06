package com.christophejung;

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
        Scanner scanner = ReflectScannerGenerator.generate(JavaParser.class);

        Object o = "No Data";
        long count = 0;
        long sum = 0;
        long meausurements = 100;
        try
        {
            ScanJob scanJob = new ScanJob(scanner, StreamUtils.getFileStream("test.java"));

            long start = System.currentTimeMillis();
            o = parser.parse(scanJob);
            long end = System.currentTimeMillis();
            sum += end - start;
            count++;
            System.out.println(sum / count);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if (o instanceof Program)
        {
            Program program = (Program) o;

            HierarchicalWriter writer = new HierarchicalWriter();

            program.write(writer);

            System.out.println(writer.toString());

        }
        else
        {
            System.out.println(o);
        }


    }
}
