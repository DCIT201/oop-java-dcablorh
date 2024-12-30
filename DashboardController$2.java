package dashboard;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lorry.Lorry;

class DashboardController$2 implements ListSelectionListener {
    DashboardController$2(DashboardController var1, StaffDashboardView var2) {
        this.this$0 = var1;
        this.val$staffView = var2;
    }

    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && this.val$staffView.list2.getSelectedIndex() > 0 && !((String)this.val$staffView.list2.getSelectedValue()).contentEquals("No Lorry Added!")) {
            Lorry lorryObj = (Lorry)this.this$0.lorries.get(this.val$staffView.list2.getSelectedIndex() - 1);
            this.val$staffView.jLblLoadCapacity.setVisible(true);
            this.val$staffView.jLblLoadCapacityValue.setVisible(true);
            this.val$staffView.jLblMakeValue.setText(lorryObj.getMake());
            this.val$staffView.jLblModelValue.setText(String.valueOf(lorryObj.getModel()));
            this.val$staffView.jLblTopSpeedValue.setText(String.valueOf(lorryObj.getTopSpeed()));
            this.val$staffView.jLblRegistrationNumberValue.setText(lorryObj.getRegistrationNumber());
            this.val$staffView.jLblDailyHireRateValue.setText(String.valueOf(lorryObj.getDailyHireRate()));
            this.val$staffView.jLblLoadCapacityValue.setText(String.valueOf(lorryObj.getLoadCapacity()));
            this.val$staffView.jLblNumberOfDoorsValue.setVisible(false);
            this.val$staffView.jLblNumberOfDoors.setVisible(false);
            this.val$staffView.jLblSeatingCapacity.setVisible(false);
            this.val$staffView.jLblSeatingCapacityValue.setVisible(false);
            this.val$staffView.jLblFuelTypeValue.setVisible(false);
            this.val$staffView.jLblFuelType.setVisible(false);
        }

    }
}
