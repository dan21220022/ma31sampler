import java.util.HashMap;

public class TransformerManager {
    private HashMap<String, Extractor> transformersMap;

    TransformerManager()
    {

    }

    public Extractor getTransformer(String transformerType) {
        return transformersMap.get(transformerType);
    }
}
