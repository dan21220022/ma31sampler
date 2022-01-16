import java.util.HashMap;

public class LoaderManager {

    private HashMap<String, Loader> loadersMap;

    LoaderManager()
    {

    }

    public Loader getLoader(String LoaderType) {
        return loadersMap.get(LoaderType);
    }

}
