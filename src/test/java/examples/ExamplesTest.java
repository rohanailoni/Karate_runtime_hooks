package examples;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExamplesTest {
    
    @Test
    void testAll() {
        Results results = Runner.path("classpath:examples/cats-test.feature")
                // .tags("~@ignore")
                .hook(new MyRuntimeHook())
                .parallel(1);
    }
    
}
