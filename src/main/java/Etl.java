import java.util.ArrayList;

public class Etl {
    private Extractor extractor;
    private Transformer transformer;
    private Loader loader;
    private String srcPath;
    private String destPath;

    Etl(Extractor extractor, Transformer transformer, Loader loader, String srcPath, String destPath)
    {
        this.extractor = extractor;
        this.transformer = transformer;
        this.loader = loader;
        this.srcPath = srcPath;
        this.destPath = destPath;
    }

    public void processData()
    {
        ArrayList<DataContainer> dataContainer;
        dataContainer = extractor.extract(srcPath);
        dataContainer = transformer.transform(dataContainer);
        loader.load(dataContainer, destPath);
    }
}
