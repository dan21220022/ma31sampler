import java.util.HashMap;

public class LoaderManager {

    private static HashMap<String, Loader> loadersMap;

    LoaderManager()
    {

    }

    public Loader getLoader(String LoaderType) {
        return loadersMap.get(LoaderType);
    }

}
