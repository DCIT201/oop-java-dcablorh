package dashboard;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Truck.Truck;

class DashboardController$3 implements ListSelectionListener {
    DashboardController$3(DashboardController var1, StaffDashboardView var2) {
        this.this$0 = var1;
        this.val$staffView = var2;
    }

    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && this.val$staffView.list3.getSelectedIndex() > 0 && !((String)this.val$staffView.list3.getSelectedValue()).contentEquals("No Truck Added!")) {
            Truck Truck = (Truck)this.this$0.Truckes.get(this.val$staffView.list3.getSelectedIndex() - 1);
            this.val$staffView.jLblSeatingCapacity.setVisible(true);
            this.val$staffView.jLblSeatingCapacityValue.setVisible(true);
            this.val$staffView.jLblMakeValue.setText(Truck.getMake());
            this.val$staffView.jLblModelValue.setText(String.valueOf(Truck.getModel()));
            this.val$staffView.jLblTopSpeedValue.setText(String.valueOf(Truck.getTopSpeed()));
            this.val$staffView.jLblRegistrationNumberValue.setText(Truck.getRegistrationNumber());
            this.val$staffView.jLblDailyHireRateValue.setText(String.valueOf(Truck.getDailyHireRate()));
            this.val$staffView.jLblSeatingCapacityValue.setText(String.valueOf(Truck.getSeatingCapacity()));
            this.val$staffView.jLblNumberOfDoorsValue.setVisible(false);
            this.val$staffView.jLblNumberOfDoors.setVisible(false);
            this.val$staffView.jLblLoadCapacity.setVisible(false);
            this.val$staffView.jLblLoadCapacityValue.setVisible(false);
            this.val$staffView.jLblFuelTypeValue.setVisible(false);
            this.val$staffView.jLblFuelType.setVisible(false);
        }

    }
}
