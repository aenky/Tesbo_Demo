package runner;

import Execution.Tesbo;

import java.nio.file.Paths;

public class Runner {
    public static void main(String[] args) {

        Tesbo tests = new Tesbo();
        tests.run(args);
    }
}

