package dashboard;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import user.User;

class DashboardController$4 implements ListSelectionListener {
    DashboardController$4(DashboardController var1, StaffDashboardView var2) {
        this.this$0 = var1;
        this.val$staffView = var2;
    }

    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && this.val$staffView.list4.getSelectedIndex() > 0 && !((String)this.val$staffView.list4.getSelectedValue()).contentEquals("No Customers Added!")) {
            User user = (User)this.this$0.customers.get(this.val$staffView.list4.getSelectedIndex() - 1);
            this.val$staffView.jLblIdentificationNumberValue.setText(user.getIdentificationNumber());
            this.val$staffView.jLblCorporationNameValue.setText(user.getCorporationName());
            this.val$staffView.jLblAddressValue.setText(user.getAddress());
            this.val$staffView.jLblPhoneNumberValue.setText(user.getPhoneNumber());
            this.val$staffView.jLblEmailValue.setText(user.getEmail());
            this.val$staffView.jLblUsernameValue.setText(user.getUsername());
        }

    }
}
