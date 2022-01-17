import java.util.ArrayList;

public class DefaultTransformer implements Transformer{
    @Override
    public ArrayList<DataContainer> transform(ArrayList<DataContainer> dataForTransform) {
        return dataForTransform;
    }
}
