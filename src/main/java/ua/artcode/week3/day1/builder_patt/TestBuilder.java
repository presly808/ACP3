package ua.artcode.week3.day1.builder_patt;

/**
 * Created by admin on 29.11.2014.
 */
public class TestBuilder {

    public static void main(String[] args) {
        Robot.RobotBuilder builder = new Robot.RobotBuilder();
        builder.addEnergy(80).addModel("EN-34").addPrice(10000);
        Robot built = builder.build();
    }
}
