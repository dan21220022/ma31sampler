import java.util.HashMap;

public class DataContainer {
    //propertyName, propertyValue
    HashMap<String, Object> data = new HashMap<>();

    public void addData(String name, Object value) {
        this.data.put(name, value);
    }

    public HashMap<String, Object> getData() {
        return data;
    }
}
