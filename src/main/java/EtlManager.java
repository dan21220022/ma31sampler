public class EtlManager {
    private static final ExtractorManager extractorManager = new ExtractorManager();
    private static final TransformerManager transformerManager = new TransformerManager();
    private static final LoaderManager loaderManager = new LoaderManager();
    private static final LimiterManager limiterManager = new LimiterManager();

    public Etl createEtl(String src, String srcType, String dest, String destType, String transformerType, String limiterType, int limitPerFile)
    {
        Extractor e = null;
        Transformer t = null;
        Loader loader = null;
        Limiter limiter = null;

        try {
            e = extractorManager.getExtractor(srcType);
            t = transformerManager.getTransformer(transformerType);
            loader = loaderManager.getLoader(destType);
            limiter = limiterManager.getLimiter(limiterType, limitPerFile);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }


        return new Etl(e, t, loader, src, dest, limiter);
    }
}
