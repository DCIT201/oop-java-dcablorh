package dashboard;

import car.Car;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class DashboardController$1 implements ListSelectionListener {
    DashboardController$1(DashboardController var1, StaffDashboardView var2) {
        this.this$0 = var1;
        this.val$staffView = var2;
    }

    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && this.val$staffView.list1.getSelectedIndex() > 0 && !((String)this.val$staffView.list1.getSelectedValue()).contentEquals("No Cars Added!")) {
            Car carObj = (Car)this.this$0.cars.get(this.val$staffView.list1.getSelectedIndex() - 1);
            this.val$staffView.jLblNumberOfDoorsValue.setVisible(true);
            this.val$staffView.jLblNumberOfDoors.setVisible(true);
            this.val$staffView.jLblFuelTypeValue.setVisible(true);
            this.val$staffView.jLblFuelType.setVisible(true);
            this.val$staffView.jLblMakeValue.setText(carObj.getMake());
            this.val$staffView.jLblModelValue.setText(String.valueOf(carObj.getModel()));
            this.val$staffView.jLblTopSpeedValue.setText(String.valueOf(carObj.getTopSpeed()));
            this.val$staffView.jLblRegistrationNumberValue.setText(carObj.getRegistrationNumber());
            this.val$staffView.jLblDailyHireRateValue.setText(String.valueOf(carObj.getDailyHireRate()));
            this.val$staffView.jLblFuelTypeValue.setText(carObj.getFuelType());
            this.val$staffView.jLblNumberOfDoorsValue.setText(String.valueOf(carObj.getNumberOfDoors()));
            this.val$staffView.jLblLoadCapacity.setVisible(false);
            this.val$staffView.jLblLoadCapacityValue.setVisible(false);
            this.val$staffView.jLblSeatingCapacity.setVisible(false);
            this.val$staffView.jLblSeatingCapacityValue.setVisible(false);
        }

    }
}
