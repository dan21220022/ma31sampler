import java.util.HashMap;

public class ExtractorManager {
    private HashMap<String, Extractor> extractorsMap;

    ExtractorManager()
    {

    }

    public Extractor getExtractor(String extractorType) {
        return extractorsMap.get(extractorType);
    }
}
