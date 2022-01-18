import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;

import java.util.ArrayList;

public class LabTestsTransformer implements Transformer{
    @Override
    public ArrayList<DataContainer> transform(Object dataForTransform) {
        ArrayList<DataContainer> dataForTransformCasted = (ArrayList<DataContainer>) dataForTransform;
        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();
        for(int i = 0; i < dataForTransformCasted.size(); i++)
        {
            int currentPatientId = Integer.parseInt((String) dataForTransformCasted.get(i).getData().get("IDNum"));
            int currentPatientIdType = Integer.parseInt((String) dataForTransformCasted.get(i).getData().get("IDType"));
            if(String.valueOf(currentPatientId).length() == 9) {
                try {
                    PersonInsured personInsured = healthCareInfoProvider.fetchInfo(currentPatientId, currentPatientIdType);

                    dataForTransformCasted.get(i).addData("JOIN_DATE", personInsured.getJoinDate().toString());
                    dataForTransformCasted.get(i).addData("HEALTH_CARE_ID", personInsured.getHealthCareId());
                    dataForTransformCasted.get(i).addData("HEALTH_CARE_NAME", personInsured.getHealthCareId());
                } catch (InvalidIdException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataForTransformCasted;
    }
}
