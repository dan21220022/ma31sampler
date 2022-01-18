import java.util.HashMap;

public class LimiterManager {
    private static HashMap<String, Limiter> limitersMap;

    LimiterManager()
    {
        limitersMap = new HashMap<>();
        limitersMap.put("Record", new RecordLimiter());
        limitersMap.put("FileSize", new FileSizeLimiter());
    }

    public Limiter getLimiter(String limiterType, int limit)
    {
        Limiter l = limitersMap.get(limiterType);
        l.setLimit(limit);
        return l;
    }
}
