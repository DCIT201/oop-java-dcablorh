
package Truck;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import vehicle.Vehicle;

public class Truck extends Vehicle implements Serializable {
    private static final long serialVersionUID = 1940794028905840130L;
    private int seatingCapacity;

    public Truck(String make, int model, int topSpeed, String registrationNumber, double dailyHireRate, int seatingCapacity) {
        super(make, model, topSpeed, registrationNumber, dailyHireRate);
        this.seatingCapacity = seatingCapacity;
    }

    public ArrayList<String> validateTruck(String make, String model, String topSpeed, String registrationNumber, String dailyHireRate, String seatingCapacity) {
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
            File file = new File("./src/resources/TruckObjects.dat");
            if (file.exists()) {
                for(Truck Truck : this.getObjects("./src/resources/TruckObjects.dat")) {
                    if (registrationNumber.contentEquals(Truck.getRegistrationNumber())) {
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

        if (seatingCapacity.isEmpty()) {
            errors.add("Seating Capacity cannot be Empty!");
        } else if (Integer.parseInt(seatingCapacity) < 0) {
            errors.add("Seating Capacity cannot be Negative!");
        }

        return errors.size() == 0 ? errors : errors;
    }

    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }
}
