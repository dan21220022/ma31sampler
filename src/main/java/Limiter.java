import java.util.ArrayList;

public abstract class Limiter {
    protected int limit = 0;

    public abstract ArrayList<ArrayList<DataContainer>> getLimitedList(ArrayList<DataContainer> container);

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
