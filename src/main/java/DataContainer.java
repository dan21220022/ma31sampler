import java.util.HashMap;

public abstract class DataContainer {
    //propertyName, propertyValue
    HashMap<String, Object> data;

    public HashMap<String, Object> getData() {
        return data;
    }
}
