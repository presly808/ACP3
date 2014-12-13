package ua.artcode.utils;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

/**
 * Created by admin on 13.12.2014.
 */
public class JUnitCoreTest {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SimpleMathTest.class);
        System.out.println(result.wasSuccessful());
        List<Failure> failureList = result.getFailures();

    }
}
