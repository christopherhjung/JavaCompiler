public class Block implements Statement, ClassStatement
{
    private List exp = null;

    void Block(List exp)
    {
        this.exp = exp;
    }

    String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append("}");


        return sb.toString();
    }
}
