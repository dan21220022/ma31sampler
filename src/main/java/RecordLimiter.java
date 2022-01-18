import java.util.ArrayList;

public class RecordLimiter extends Limiter{

    RecordLimiter(int limit)
    {
        super(limit);
    }

    public ArrayList<ArrayList<DataContainer>> getLimitedList(ArrayList<DataContainer> container)
    {
        ArrayList<ArrayList<DataContainer>> dataContainers = new ArrayList<>();
        int currentContainersListIndex = 0;
        dataContainers.add(new ArrayList<DataContainer>());

        for(int i = 0; i < container.size(); i++)
        {
            if( i != 0 && i % limit == 0)
            {
                currentContainersListIndex++;
                dataContainers.add(new ArrayList<DataContainer>());
            }
            dataContainers.get(currentContainersListIndex).add(container.get(i));
        }
        return dataContainers;
    }
}
