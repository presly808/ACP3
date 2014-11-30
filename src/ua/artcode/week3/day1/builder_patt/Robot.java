package ua.artcode.week3.day1.builder_patt;

import java.util.Date;

public class Robot {

    private final int energy;
    private final String model;
    private final double price;
    private final boolean repaired;
    private final String color;
    private final String material;
    private final Date creation;

    public Robot(int energy, String model, double price,
                 boolean repaired, String color,
                 String material, Date creation) {
        this.energy = energy;
        this.model = model;
        this.price = price;
        this.repaired = repaired;
        this.color = color;
        this.material = material;
        this.creation = creation;
    }

    public int getEnergy() {
        return energy;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public Date getCreation() {
        return creation;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "energy=" + energy +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", repaired=" + repaired +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", creation=" + creation +
                '}';
    }

    public static class RobotBuilder {
        private int energy;
        private String model;
        private double price;
        private boolean repaired;
        private String color;
        private String material;
        private Date creation;

        public RobotBuilder() {
        }

        public RobotBuilder addEnergy(int energy){
            this.energy = energy;
            return this;
        }

        public RobotBuilder addModel(String model){
            this.model = model;
            return this;
        }

        public RobotBuilder addPrice(double price){
            this.price = price;
            return this;
        }

        public Robot build(){
            return new Robot(energy,model,price,repaired,color,material,creation);
        }
    }
}
