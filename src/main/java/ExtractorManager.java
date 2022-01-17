import java.util.HashMap;

public class ExtractorManager {
    private static HashMap<String, Extractor> extractorsMap;

    ExtractorManager()
    {

    }

    public Extractor getExtractor(String extractorType) {
        return extractorsMap.get(extractorType);
    }
}
