package com.christophejung.methodexpressions;

import com.christophejung.HierarchicalWriter;
import com.christophejung.Program;

public class TryCatchStatement extends Program implements Statement
{
    private Statement tryBranch;
    private Statement catchBranch;

    public TryCatchStatement(Statement tryBranch, Statement catchBranch)
    {
        this.tryBranch = tryBranch;
        this.catchBranch = catchBranch;
    }

    @Override
    public void write(HierarchicalWriter writer)
    {
        writer.print("try");
        writer.print(tryBranch);
        writer.print("catch");
        writer.print(catchBranch);
    }
}
