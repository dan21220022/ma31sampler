import java.util.HashMap;

public class TransformerManager {
    private static HashMap<String, Transformer> transformersMap;

    TransformerManager()
    {
        transformersMap = new HashMap<>();
        transformersMap.put("Default", new DefaultTransformer());
    }

    public Transformer getTransformer(String transformerType) {
        return transformersMap.get(transformerType);
    }
}
