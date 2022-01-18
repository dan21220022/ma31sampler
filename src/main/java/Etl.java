import java.util.ArrayList;

public class Etl {
    private Extractor extractor;
    private Transformer transformer;
    private Limiter limiter;
    private Loader loader;
    private String srcPath;
    private String destPath;

    Etl(Extractor extractor, Transformer transformer, Loader loader, String srcPath, String destPath, Limiter limiter)
    {
        this.extractor = extractor;
        this.transformer = transformer;
        this.loader = loader;
        this.srcPath = srcPath;
        this.destPath = destPath;
        this.limiter = limiter;
    }

    public void processData()
    {
        int currentFileIndex = 0;
        ArrayList<DataContainer> dataContainer;
        dataContainer = extractor.extract(srcPath);
        dataContainer = transformer.transform(dataContainer);
        ArrayList<ArrayList<DataContainer>> dataContainers = limiter.getLimitedList(dataContainer);
        for(ArrayList<DataContainer> containersList : dataContainers)
        {
            String nextName = destPath.substring(0, destPath.lastIndexOf('.')) + "" + currentFileIndex + "" + destPath.substring(destPath.lastIndexOf('.'));
            loader.load(containersList, nextName);
            currentFileIndex++;
        }
        System.out.println("Completed!");
    }

    public void combineData(String srcPath2)
    {
        int currentFileIndex = 0;
        ArrayList<ArrayList<DataContainer>> dataContainersList = new ArrayList<>();
        ArrayList<DataContainer> dataContainer;
        dataContainersList.add(extractor.extract(srcPath));
        dataContainersList.add(extractor.extract(srcPath2));
        dataContainer = transformer.transform(dataContainersList);
        ArrayList<ArrayList<DataContainer>> dataContainers = limiter.getLimitedList(dataContainer);
        for(ArrayList<DataContainer> containersList : dataContainers)
        {
            String nextName = destPath.substring(0, destPath.lastIndexOf('.')) + "" + currentFileIndex + "" + destPath.substring(destPath.lastIndexOf('.'));
            loader.load(containersList, nextName);
            currentFileIndex++;
        }
        System.out.println("Completed!");
    }
}
