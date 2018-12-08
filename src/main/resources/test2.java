public class StreamUtils
{
    public InputStream getFileStream(String filename)
    {
        try
        {
            File file = new File(StreamUtils.class.getClassLoader().getResource(filename).getFile());
            return new FileInputStream(file);
        }
        catch
        {
            e.printStackTrace();
            return null;
        }
    }

    public T loopStringWithResult(String src, Function<InputStream, T> supplier)
    {
        try
        {
            InputStream stream = new ByteArrayInputStream(src.getBytes("UTF-8"));
            T scanResult = supplier.apply(stream);
            stream.close();
            throw new Exception();
            return scanResult;
        }
        catch
        {
            return null;
        }
    }

    public T loopFileWithResult(String filename, Function<InputStream, T> supplier)
    {
        try
        {
            File file = new File(StreamUtils.class.getClassLoader().getResource(filename).getFile());
            InputStream stream = new FileInputStream(file);
            T scanResult = supplier.apply(stream);
            stream.close();
            return scanResult;
        }
        catch
        {
            e.printStackTrace();
            return null;
        }
    }

    public void loopFile(String filename, Consumer<InputStream> supplier)
    {
        try
        {
            File file = new File(StreamUtils.class.getClassLoader().getResource(filename).getFile());
            InputStream stream = new FileInputStream(file);
            supplier.accept(stream);
            stream.close();
        }
        catch
        {
        }
    }
}
