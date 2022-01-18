import java.util.ArrayList;

public class CombineCsvTransformer implements Transformer{


    @Override
    public ArrayList<DataContainer> transform(Object dataForTransform) {
        ArrayList<ArrayList<DataContainer>> listOfDataContainers = (ArrayList<ArrayList<DataContainer>>) dataForTransform;
        ArrayList<DataContainer> dataContainers = new ArrayList<>();

        for(int i = 1; i < listOfDataContainers.get(0).size(); i++)
        {
            for(int j = 0; j < listOfDataContainers.get(1).size(); j++)
            {
                String firstId = (String) listOfDataContainers.get(0).get(i).getData().get("IDNum");
                String secondId = (String) listOfDataContainers.get(1).get(j).getData().get("IDNum");
                if(firstId.equals(secondId))
                {
                    DataContainer dataContainer = listOfDataContainers.get(0).get(i);
                    listOfDataContainers.get(1).get(j).getData().forEach(dataContainer::addData);
                    dataContainers.add(dataContainer);
                }
            }
        }
        return dataContainers;
    }
}
