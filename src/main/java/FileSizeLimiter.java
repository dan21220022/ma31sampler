import java.util.ArrayList;

public class FileSizeLimiter extends Limiter{

    public FileSizeLimiter(int limit) {
        super(limit);
    }

    @Override
    public ArrayList<ArrayList<DataContainer>> getLimitedList(ArrayList<DataContainer> container) {
        int sizeCounter = 0;
        ArrayList<ArrayList<DataContainer>> dataContainers = new ArrayList<>();
        int currentContainersListIndex = 0;
        dataContainers.add(new ArrayList<DataContainer>());

        for(int i = 0; i < container.size(); i++)
        {
            dataContainers.add(new ArrayList<DataContainer>());
            dataContainers.get(currentContainersListIndex).add(container.get(i));
            sizeCounter += container.get(i).getData().toString().length();
            if(sizeCounter >= limit)
            {
                sizeCounter = 0;
                currentContainersListIndex++;
            }
        }
        return dataContainers;
    }
}
