package ua.artcode.proj_jira.Units;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class simpleMathTest {

    @Test
    public void testSumZeros(){
        int expected = 0;

        int acual = SimpleMath.SimpleMath2(0,0);
        Assert.assertEquals(acual, expected);

    }



}