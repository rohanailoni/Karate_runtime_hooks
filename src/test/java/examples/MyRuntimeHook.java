package examples;

import com.intuit.karate.RuntimeHook;
import com.intuit.karate.Suite;
import com.intuit.karate.core.FeatureRuntime;
import com.intuit.karate.core.ScenarioRuntime;
import com.intuit.karate.core.Step;
import com.intuit.karate.core.StepResult;

public class MyRuntimeHook implements RuntimeHook {
    private static final int MAX_RETRIES = 2;
    @Override
    public boolean beforeScenario(ScenarioRuntime sr) {
        int retryCount = 0;

        while (retryCount < MAX_RETRIES) {
            System.out.println("beforeScenario: Attempt " + (retryCount + 1));

           
            boolean scenarioPassed = executeScenario(sr);

            if (scenarioPassed) {
                System.out.println("beforeScenario: Scenario passed on attempt " + (retryCount + 1));
                return true; 
            }

            retryCount++;
        }

        System.out.println("beforeScenario: Maximum retry attempts reached. Scenario failed.");
        return false; 
    }
    private boolean executeScenario(ScenarioRuntime sr) {
        try {
           
            sr.run();
            
            return !sr.isFailed();
        } catch (Exception e) {
          
            System.out.println("Exception during scenario execution: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void afterScenario(ScenarioRuntime sr) {
        System.out.println("afterScenario");
    }

    @Override
    public boolean beforeFeature(FeatureRuntime fr) {
        System.out.println("beforeFeature");
        return true;
    }

    @Override
    public void afterFeature(FeatureRuntime fr) {
        System.out.println("afterFeature");
    }

    @Override
    public void beforeSuite(Suite suite) {

    }

    @Override
    public void afterSuite(Suite suite) {

    }

    @Override
    public boolean beforeStep(Step step, ScenarioRuntime sr) {
        return true;
    }

    @Override
    public void afterStep(StepResult result, ScenarioRuntime sr) {

    }
}
