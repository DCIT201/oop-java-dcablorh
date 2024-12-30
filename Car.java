package car;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import vehicle.Vehicle;

public class Car extends Vehicle implements Serializable {
    private static final long serialVersionUID = -4306439855426601691L;
    private String fuelType;
    private int numberOfDoors;

    public Car(String make, int model, int topSpeed, String registrationNumber, double dailyHireRate, String fuelType, int numberOfDoors) {
        super(make, model, topSpeed, registrationNumber, dailyHireRate);
        this.fuelType = fuelType;
        this.numberOfDoors = numberOfDoors;
    }

    public ArrayList<String> validateCar(String make, String model, String topSpeed, String registrationNumber, String dailyHireRate, String fuelType, String numberOfDoors) {
        ArrayList<String> errors = new ArrayList();
        if (make.isEmpty()) {
            errors.add("Make cannot be Empty!");
        }

        if (model.isEmpty()) {
            errors.add("Model cannot be Empty!");
        }

        if (topSpeed.isEmpty()) {
            errors.add("Top Speed cannot be Empty!");
        } else {
            try {
                if (Integer.parseInt(topSpeed) < 0) {
                    errors.add("Top Speed cannot be Negative!");
                }
            } catch (NumberFormatException var15) {
                errors.add("Top Speed must be an integer!");
            }
        }

        if (registrationNumber.isEmpty()) {
            errors.add("Registration Number cannot be Empty!");
        } else {
            File file = new File("./src/resources/carObjects.dat");
            if (file.exists()) {
                for(Car car : this.getObjects("./src/resources/carObjects.dat")) {
                    if (registrationNumber.contentEquals(car.getRegistrationNumber())) {
                        errors.add("Registration Number Already Exists!");
                    }
                }
            }
        }

        if (dailyHireRate.isEmpty()) {
            errors.add("Daily Hire Rate cannot be Empty!");
        } else {
            try {
                if (Integer.parseInt(dailyHireRate) < 0) {
                    errors.add("Daily Hire Rate cannot be Negative!");
                }
            } catch (NumberFormatException var14) {
                errors.add("Daily Hire Rate must be integer!");
            }
        }

        if (fuelType.isEmpty()) {
            errors.add("Full Type cannot be Empty!");
        }

        if (numberOfDoors.isEmpty()) {
            errors.add("Number of Doors cannot be Empty!");
        } else {
            try {
                if (Integer.parseInt(numberOfDoors) <= 0) {
                    errors.add("Number of Doors cannot be Negative or Zero!");
                }
            } catch (NumberFormatException var13) {
                errors.add("Number of Doors must be an integer!");
            }
        }

        return errors;
    }

    public String getFuelType() {
        return this.fuelType;
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }
}
