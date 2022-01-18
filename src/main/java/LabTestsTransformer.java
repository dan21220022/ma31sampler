import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;

import java.util.ArrayList;

public class LabTestsTransformer implements Transformer{
    @Override
    public ArrayList<DataContainer> transform(ArrayList<DataContainer> dataForTransform) {
        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();
        for(int i = 0; i < dataForTransform.size(); i++)
        {
            int currentPatientId = Integer.parseInt((String) dataForTransform.get(i).getData().get("IDNum"));
            int currentPatientIdType = Integer.parseInt((String) dataForTransform.get(i).getData().get("IDType"));
            if(String.valueOf(currentPatientId).length() == 9) {
                try {
                    PersonInsured personInsured = healthCareInfoProvider.fetchInfo(currentPatientId, currentPatientIdType);

                    dataForTransform.get(i).addData("JOIN_DATE", personInsured.getJoinDate().toString());
                    dataForTransform.get(i).addData("HEALTH_CARE_ID", personInsured.getHealthCareId());
                    dataForTransform.get(i).addData("HEALTH_CARE_NAME", personInsured.getHealthCareId());
                } catch (InvalidIdException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataForTransform;
    }
}
