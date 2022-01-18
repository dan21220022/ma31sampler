import java.util.ArrayList;

public class FileSizeLimiter extends Limiter{

    @Override
    public ArrayList<ArrayList<DataContainer>> getLimitedList(ArrayList<DataContainer> container) {
        int sizeCounter = 0;
        int numOfFieldsAsSize = container.get(0).getData().size() * 4;

        ArrayList<ArrayList<DataContainer>> dataContainers = new ArrayList<>();
        int currentContainersListIndex = 0;
        dataContainers.add(new ArrayList<DataContainer>());
        for(int i = 0; i < container.size(); i++)
        {
            dataContainers.get(currentContainersListIndex).add(container.get(i));
            sizeCounter += container.get(i).getData().toString().length() + numOfFieldsAsSize;
            if(sizeCounter + container.get(i).getData().toString().length() >= limit)
            {
                dataContainers.add(new ArrayList<>());
                sizeCounter = 0;
                currentContainersListIndex++;
            }
        }
        return dataContainers;
    }
}
