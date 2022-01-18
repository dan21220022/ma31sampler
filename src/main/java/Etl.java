import java.util.ArrayList;

public class Etl {
    private Extractor extractor;
    private Transformer transformer;
    private RecordLimiter recordLimiter;
    private Loader loader;
    private String srcPath;
    private String destPath;

    Etl(Extractor extractor, Transformer transformer, Loader loader, String srcPath, String destPath, int recordsLimitPerFile)
    {
        this.extractor = extractor;
        this.transformer = transformer;
        this.loader = loader;
        this.srcPath = srcPath;
        this.destPath = destPath;
        this.recordLimiter = new RecordLimiter(recordsLimitPerFile);
    }

    public void processData()
    {
        int currentFileIndex = 0;
        ArrayList<DataContainer> dataContainer;
        dataContainer = extractor.extract(srcPath);
        dataContainer = transformer.transform(dataContainer);
        ArrayList<ArrayList<DataContainer>> dataContainers = recordLimiter.getLimitedList(dataContainer);
        for(ArrayList<DataContainer> containersList : dataContainers)
        {
            String nextName = destPath.substring(0, destPath.lastIndexOf('.')) + "" + currentFileIndex + "" + destPath.substring(destPath.lastIndexOf('.'));
            loader.load(containersList, nextName);
            currentFileIndex++;
        }
        System.out.println("Completed!");
    }
}
