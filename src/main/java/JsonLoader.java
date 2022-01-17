import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonLoader implements Loader{

    @Override
    public void load(ArrayList<DataContainer> dataContainer, String destPath) {
        ObjectMapper objectMapper = new ObjectMapper();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(destPath, true);
            for(DataContainer container : dataContainer)
            {
                objectMapper.writeValue(fileWriter , container.getData());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
