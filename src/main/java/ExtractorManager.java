import java.util.HashMap;

public class ExtractorManager {
    private static HashMap<String, Extractor> extractorsMap;

    ExtractorManager()
    {
        extractorsMap = new HashMap<>();
        extractorsMap.put("Csv", new CsvExtractor());
    }

    public Extractor getExtractor(String extractorType) {
        return extractorsMap.get(extractorType);
    }
}
