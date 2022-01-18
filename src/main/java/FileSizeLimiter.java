import java.util.ArrayList;

public class FileSizeLimiter extends Limiter{

    public FileSizeLimiter(int limit) {
        super(limit);
    }

    @Override
    public ArrayList<ArrayList<DataContainer>> getLimitedList(ArrayList<DataContainer> container) {
        return null;
    }
}
