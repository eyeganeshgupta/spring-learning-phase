package io.spring.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Runner executed");
        System.out.println("Total arguments passed: " + args.length);
        for(String arg : args) {
            System.out.println(arg);
        }
    }
}
