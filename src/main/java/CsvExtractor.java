import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvExtractor implements Extractor{

    @Override
    public ArrayList<DataContainer> extract(String srcPath) {

        ArrayList<CSVRecord> records = getRecords(srcPath);
        ArrayList<String> names = getFieldNames(records.get(0));

        ArrayList<DataContainer> dataContainers = new ArrayList<>();
        for(int i = 1; i < records.size(); i++)
        {
            dataContainers.add(createRecord(names, records.get(i)));
        }
        return dataContainers;
    }

    private ArrayList<CSVRecord> getRecords(String srcPath)
    {
        try {
            ArrayList<CSVRecord> records = (ArrayList<CSVRecord>) new CSVParser(new FileReader(srcPath), CSVFormat.MYSQL).getRecords();
            return records;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<String> getFieldNames(CSVRecord record)
    {
        ArrayList<String> fieldNames = new ArrayList<>();
        for(String name : record)
        {
            fieldNames.add(name);
        }
        return fieldNames;
    }

    private DataContainer createRecord(ArrayList<String> fieldNames, CSVRecord fieldValues)
    {
        DataContainer dataContainer = new DataContainer();
        for(int i = 0; i < fieldValues.size(); i++)
        {
            dataContainer.addData(fieldNames.get(i), fieldValues.get(i));
        }
        return dataContainer;
    }
}
