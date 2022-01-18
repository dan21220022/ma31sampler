import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;

public class XmlLoader implements Loader{

    @Override
    public void load(ArrayList<DataContainer> dataContainer, String destPath) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            clearFile(destPath);
            String xmlConverted = createXmlString(xmlMapper, dataContainer);
            FileWriter fileWriter = new FileWriter(destPath, true);
            fileWriter.write(xmlConverted);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFile(String destPath) throws IOException {
        FileWriter f = new FileWriter(destPath);
        f.write(" ");
        f.flush();
        f.close();
    }

    private String createXmlString(XmlMapper xmlMapper, ArrayList<DataContainer> dataContainer) throws JsonProcessingException {
        String xmlConverted = null;
        xmlConverted = xmlMapper.writeValueAsString(dataContainer);
        xmlConverted = xmlConverted.replaceAll("ArrayList", "labTests");
        xmlConverted = xmlConverted.replaceAll("<item>", "");
        xmlConverted = xmlConverted.replaceAll("</item>", "");
        xmlConverted = xmlConverted.replaceAll("<data>", "<labTest>");
        xmlConverted = xmlConverted.replaceAll("</data>", "</labTest>");
        return xmlConverted;
    }
}
