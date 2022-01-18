import java.util.HashMap;

public class LoaderManager {

    private static HashMap<String, Loader> loadersMap;

    LoaderManager()
    {
        loadersMap = new HashMap<>();
        loadersMap.put("Json", new JsonLoader());
        loadersMap.put("Xml", new XmlLoader());
    }

    public Loader getLoader(String LoaderType) {
        return loadersMap.get(LoaderType);
    }

}
