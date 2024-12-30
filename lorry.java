package lorry;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import vehicle.Vehicle;

public class Lorry extends Vehicle implements Serializable {
    private static final long serialVersionUID = -4182575229350792686L;
    private int loadCapacity;

    public Lorry(String make, int model, int topSpeed, String registrationNumber, double dailyHireRate, int loadCapacity) {
        super(make, model, topSpeed, registrationNumber, dailyHireRate);
        this.loadCapacity = loadCapacity;
    }

    public ArrayList<String> validateLorry(String make, String model, String topSpeed, String registrationNumber, String dailyHireRate, String loadCapacity) {
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
            } catch (NumberFormatException var12) {
                errors.add("Top Speed must be an integer!");
            }
        }

        if (registrationNumber.isEmpty()) {
            errors.add("Registration Number cannot be Empty!");
        } else {
            File file = new File("./src/resources/lorryObjects.dat");
            if (file.exists()) {
                for(Lorry lorry : this.getObjects("./src/resources/lorryObjects.dat")) {
                    if (registrationNumber.contentEquals(lorry.getRegistrationNumber())) {
                        errors.add("Registration Number Already Exists!");
                    }
                }
            }
        }

        if (dailyHireRate.isEmpty()) {
            errors.add("Daily Hire Rate cannot be Empty!");
        } else if (Integer.parseInt(dailyHireRate) < 0) {
            errors.add("Daily Hire Rate cannot be Negative!");
        }

        if (loadCapacity.isEmpty()) {
            errors.add("Load Capacity cannot be Empty!");
        } else if (Integer.parseInt(loadCapacity) < 0) {
            errors.add("Load Capacity cannot be Negative!");
        }

        return errors.size() == 0 ? errors : errors;
    }

    public int getLoadCapacity() {
        return this.loadCapacity;
    }
}
