package io.spring.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Executing Application Runner!");

        Set<String> keys = args.getOptionNames();

        System.out.println("Total key-value pairs passed: " + keys.size());

        for (String key : keys) {
            System.out.println("Key: " + key + " Value: " + args.getOptionValues(key));
        }
    }
}
