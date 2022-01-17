import java.util.HashMap;

public class TransformerManager {
    private static HashMap<String, Transformer> transformersMap;

    TransformerManager()
    {

    }

    public Transformer getTransformer(String transformerType) {
        return transformersMap.get(transformerType);
    }
}
