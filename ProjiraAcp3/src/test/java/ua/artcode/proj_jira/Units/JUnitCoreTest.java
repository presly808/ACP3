package ua.artcode.proj_jira.Units;

import com.sun.net.httpserver.Authenticator;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

/**
 * Created by mountin on 13/12/2014.
 */
public class JUnitCoreTest {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SimpleMath.class);
        System.out.println(result.wasSuccessful());
        List<Failure> failureList = result.getFailures();

    }
}
