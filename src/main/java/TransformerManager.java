import java.util.HashMap;

public class TransformerManager {
    private static HashMap<String, Transformer> transformersMap;

    TransformerManager()
    {
        transformersMap = new HashMap<>();
        transformersMap.put("Default", new DefaultTransformer());
        transformersMap.put("LabTests", new LabTestsTransformer());
        transformersMap.put("CombineCsv", new CombineCsvTransformer());
    }

    public Transformer getTransformer(String transformerType) {
        return transformersMap.get(transformerType);
    }
}
