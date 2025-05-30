package lab10.dataprocessing;

import lab10.dataprocessing.StepCountStrategy;
import lab10.storage.SensorData;
import lab10.storage.DataRepository;

public class BasicStepCountStrategy implements StepCountStrategy {
    private DataRepository dataRepository;

    public BasicStepCountStrategy(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void consumeMessage(SensorData sample) {
        // Adaugă datele în repository
        if (sample != null && dataRepository != null) {
            dataRepository.addData(sample);
        }
    }

    @Override
    public int getTotalSteps() {
        // Calculează suma tuturor valorilor stepsCount din DataRepository
        if (dataRepository == null) {
            return 0;
        }

        int totalSteps = 0;
        for (SensorData data : dataRepository.getAllData()) {
            totalSteps += data.getStepsCount();
        }
        return totalSteps;
    }

    @Override
    public String getStrategyDescription() {
        return "BasicStepCountStrategy - sums all step counts from sensor data";
    }
}