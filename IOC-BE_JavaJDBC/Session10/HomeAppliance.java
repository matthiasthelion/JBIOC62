//package IOC-BE_JavaJDBC.Session10;

import java.util.Scanner;

public class HomeAppliance {
    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine();
        AirConditioner ac = new AirConditioner();
        wm.input();
        ac.input();
        System.out.println("\n");
        System.out.println("-------------------------------------------");
        wm.display();
        System.out.println("\n");
        System.out.println("-------------------------------------------");
        ac.display();
    }
}

class Machine {
    private String model;
    private String manufacturer;
    private int yearOfManufacture;
    private double power;

    public Machine(){
    }

    public Machine(String model, String manufacturer, int yearOfManufacture, double power) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Standard details:");
        System.out.print("Manufacturer: ");
        this.manufacturer = sc.nextLine();
        System.out.print("Model: ");
        this.model = sc.nextLine();
        System.out.print("Year of Manufacture: ");
        try {
            this.yearOfManufacture = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid year.");
        }
        System.out.print("Power (in watts): ");
        try {
            this.power = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid power value.");
        }
        sc.close();
    }

    public void display() {
        System.out.println(this.manufacturer + " " + this.model);
        System.out.println("Manufactured in " + this.yearOfManufacture);
        System.out.println("Power: " + this.power + " W");
    }
}

class WashingMachine extends Machine {
    private double loadCapacity;
    private Boolean hasDryer;

    public WashingMachine() {
        super();
    }

    public WashingMachine(String model, String manufacturer, int yearOfManufacture, double power, double loadCapacity, boolean hasDryer) {
        super(model, manufacturer, yearOfManufacture, power);
        this.loadCapacity = loadCapacity;
        this.hasDryer = hasDryer;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Boolean getHasDryer() {
        return hasDryer;
    }
    public void setHasDryer(Boolean hasDryer) {
        this.hasDryer = hasDryer;
    }

    @Override
    public void input() {
        System.out.println("Washing Machine Details:");
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Load Capacity (in kilogrammes): ");
        try {
            this.loadCapacity = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid load capacity.");
        }
        System.out.print("Has Dryer (true/false): ");
        try {
            this.hasDryer = Boolean.parseBoolean(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter true or false.");
        }
        sc.close();
    }

    @Override
    public void display() {
        System.out.println("WASHING MACHINE:");
        super.display();
        System.out.println("Load Capacity: " + this.loadCapacity + " kg");
        System.out.println(this.hasDryer? "Has dryer included" : "Has no dryer");
    }
}

class AirConditioner extends Machine {
    private double coolingCapacity;
    private double energyEfficiency;
    private String energyRating;

    public AirConditioner() {
        super();
    }

    public AirConditioner(String model, String manufacturer, int yearOfManufacture, double power, double coolingCapacity, double energyEfficiency) {
        super(model, manufacturer, yearOfManufacture, power);
        this.coolingCapacity = coolingCapacity;
        this.energyEfficiency = energyEfficiency;
        calculateEnergyRating();

    }

    public double getCoolingCapacity() {
        return coolingCapacity;
    }

    public void setCoolingCapacity(double coolingCapacity) {
        this.coolingCapacity = coolingCapacity;
    }

    public double getEnergyEfficiency() {
        return energyEfficiency;
    }

    public void setEnergyEfficiency(double energyEfficiency) {
        this.energyEfficiency = energyEfficiency;
        calculateEnergyRating();
    }

    public String getEnergyRating() {
        return this.energyRating;
    }

    private void calculateEnergyRating() {
        if (this.energyEfficiency < 0 || this.energyEfficiency > 100) {
            this.energyRating = "Invalid energy efficiency value";
        } else if (energyEfficiency == 100) {
            this.energyRating = "A1";
        } else if (energyEfficiency >= 95) {
            this.energyRating = "A2";
        } else if (energyEfficiency >= 90) {
            this.energyRating = "A3";
        } else if (energyEfficiency >= 85) {
            this.energyRating = "B1";
        } else if (energyEfficiency >= 80) {
            this.energyRating = "B2";
        } else if (energyEfficiency >= 75) {
            this.energyRating = "B3";
        } else if (energyEfficiency >= 70) {
            this.energyRating = "C1";
        } else if (energyEfficiency >= 65) {
            this.energyRating = "C2";
        } else if (energyEfficiency >= 60) {
            this.energyRating = "C3";
        } else if (energyEfficiency >= 55) {
            this.energyRating = "D1";
        } else if (energyEfficiency >= 50) {
            this.energyRating = "D2";
        } else if (energyEfficiency >= 45) {
            this.energyRating = "D3";
        } else if (energyEfficiency >= 40) {
            this.energyRating = "D4";
        } else if (energyEfficiency >= 35) {
            this.energyRating = "D5";
        } else {
            this.energyRating = "F";
        }
    }

    @Override
    public void input() {
        System.out.println("Aircon Details:");
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Cooling Capacity (in BTU): ");
        try {
            this.coolingCapacity = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid cooling capacity.");
        }
        System.out.print("Energy Efficiency (out of 100): ");
        try {
            this.energyEfficiency = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid energy efficiency value.");
        }
        sc.close();
        calculateEnergyRating();
    }

    @Override
    public void display() {
        System.out.println("AIR CONDITIONER:");
        super.display();
        System.out.println("Cooling Capacity: " + this.coolingCapacity + " BTU");
        System.out.println("Energy Rating: " + this.energyRating);
    }
}