import java.util.ArrayList;

public abstract class Limiter {
    protected int limit = 0;

    public Limiter(int limit) {
        this.limit = limit;
    }

    public abstract ArrayList<ArrayList<DataContainer>> getLimitedList(ArrayList<DataContainer> container);

}
