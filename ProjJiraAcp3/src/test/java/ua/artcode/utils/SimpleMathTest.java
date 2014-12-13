package ua.artcode.utils;

import org.junit.*;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 *
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SimpleMathTest {



    @Before
    public void init(){

    }

    @Test
    public void testSumZeros(){
        int expected = 0;
        int actual = SimpleMath.sum(0, 0);
        Assert.assertEquals(expected, actual);
    }

    @Ignore
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero(){
        SimpleMath.divide(4, 0);
    }


    @After
    public void destroy(){

    }


}
