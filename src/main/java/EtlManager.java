public class EtlManager {
    private static final ExtractorManager extractorManager = new ExtractorManager();
    private static final TransformerManager transformerManager = new TransformerManager();
    private static final LoaderManager loaderManager = new LoaderManager();

    public Etl createEtl(String src, String srcType, String dest, String destType, String transformerType, int recordsLimitPerFile)
    {
        Extractor e = null;
        Transformer t = null;
        Loader l = null;

        try {
            e = extractorManager.getExtractor(srcType);
            t = transformerManager.getTransformer(transformerType);
            l = loaderManager.getLoader(destType);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }


        return new Etl(e, t, l, src, dest, recordsLimitPerFile);
    }
}
