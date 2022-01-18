import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonLoader implements Loader{

    @Override
    public void load(ArrayList<DataContainer> dataContainer, String destPath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FileWriter f = new FileWriter(destPath);
            f.write(" ");
            f.flush();
            f.close();
            objectMapper.writeValue(new FileWriter(destPath, true) , dataContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
