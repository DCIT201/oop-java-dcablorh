public class VehicleHireSystem {
    public VehicleHireSystem() {
    }

    public static void main(String[] args) {
        VehicleHireSystemView view = new VehicleHireSystemView();
        VehicleHireSystemModel model = new VehicleHireSystemModel();
        new VehicleHireSystemController(view, model);
    }
}
