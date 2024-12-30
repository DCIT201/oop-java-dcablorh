package dashboard;

import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StaffDashboardView {
    JButton jBtnAddVehicle;
    JButton jBtnRegisterCustomer;
    JButton jBtnRemoveVehicle;
    JButton jBtnRegisterStaff;
    JButton jBtnAddCar;
    JButton jBtnAddTruck;
    JButton jBtnAddLorry;
    JButton jBtnDisplayAllCustomer;
    JButton jBtnDisplayHireRequest;
    JButton jBtnHireOut;
    JButton jBtnReturnVehicle;
    JButton jBtnHiredVehicle;
    JButton jBtnLogout;
    JButton jBtnDisplayVehicles;
    JPanel panel;
    JPanel displayVehicleData;
    JPanel displayCustomerData;
    JPanel displayHireRequestPanel;
    JFrame frame;
    JList<String> list1;
    JList<String> list2;
    JList<String> list3;
    JList<String> list4;
    JList<String> list5;
    JList<String> list6;
    JList<String> list7;
    JList<String> list10;
    JPanel carPanel;
    JScrollPane carScrollPane;
    JScrollPane lorryScrollPane;
    JScrollPane TruckScrollPane;
    JScrollPane customerScrollPane;
    JScrollPane carRequestPane;
    JScrollPane TruckRequestPane;
    JScrollPane lorryRequestPane;
    JScrollPane displayHiredVehiclePane;
    JLabel jLblMakeValue;
    JLabel jLblMake;
    JLabel jLblModel;
    JLabel jLblModelValue;
    JLabel jLblTopSpeed;
    JLabel jLblTopSpeedValue;
    JLabel jLblRegistrationNumber;
    JLabel jLblRegistrationNumberValue;
    JLabel jLblDailyHireRate;
    JLabel jLblDailyHireRateValue;
    JLabel jLblFuelType;
    JLabel jLblFuelTypeValue;
    JLabel jLblNumberOfDoors;
    JLabel jLblNumberOfDoorsValue;
    JLabel jLblLoadCapacity;
    JLabel jLblLoadCapacityValue;
    JLabel jLblSeatingCapacity;
    JLabel jLblSeatingCapacityValue;
    JLabel jLblCarTitle;
    JLabel jLblLorryTitle;
    JLabel jLblTruckTitle;
    JLabel jLblIdentificationNumber;
    JLabel jLblIdentificationNumberValue;
    JLabel jLblCorporationName;
    JLabel jLblCorporationNameValue;
    JLabel jLblAddress;
    JLabel jLblAddressValue;
    JLabel jLblPhoneNumber;
    JLabel jLblPhoneNumberValue;
    JLabel jLblEmail;
    JLabel jLblEmailValue;
    JLabel jLblVehicleDetails;
    JLabel jLblCustomerListTitle;
    JLabel jLblCustomerDetailsTitle;
    JLabel jLblUsername;
    JLabel jLblUsernameValue;

    public StaffDashboardView() {
    }

    public void GUI(JFrame frame) {
        this.frame = frame;
        this.panel = new JPanel();
        this.panel.setLayout((LayoutManager)null);
        this.jLblCarTitle = new JLabel("CARS");
        this.jLblLorryTitle = new JLabel("LORRY");
        this.jLblTruckTitle = new JLabel("Truck");
        this.jBtnRegisterCustomer = new JButton("Register a new Customer");
        this.jBtnRegisterStaff = new JButton("Register a new Staff");
        this.jBtnAddVehicle = new JButton("Add new Vehicle");
        this.jBtnRemoveVehicle = new JButton("Remove Vehicle");
        this.jBtnAddCar = new JButton("Add Car");
        this.jBtnAddTruck = new JButton("Add Mini Bus");
        this.jBtnAddLorry = new JButton("Add Lorry");
        this.jBtnDisplayAllCustomer = new JButton("Display all customers");
        this.jBtnDisplayHireRequest = new JButton("Hire Request");
        this.jBtnHireOut = new JButton("Hire Out");
        this.jBtnReturnVehicle = new JButton("Return Vehicle");
        this.jBtnHiredVehicle = new JButton("View all Hired Vehicles");
        this.jBtnLogout = new JButton("Log Out");
        this.jBtnDisplayVehicles = new JButton("Display all Vehicles");
        this.jBtnAddVehicle.setBounds(10, 90, 200, 30);
        this.jBtnRemoveVehicle.setBounds(10, 130, 200, 30);
        this.jBtnRegisterCustomer.setBounds(10, 170, 200, 30);
        this.jBtnRegisterStaff.setBounds(10, 210, 200, 30);
        this.jBtnDisplayVehicles.setBounds(10, 10, 200, 30);
        this.jBtnHireOut.setBounds(260, 10, 170, 30);
        this.jBtnReturnVehicle.setBounds(230, 10, 200, 30);
        this.jBtnDisplayHireRequest.setBounds(440, 10, 170, 30);
        this.jBtnDisplayAllCustomer.setBounds(620, 10, 170, 30);
        this.jBtnHiredVehicle.setBounds(800, 10, 170, 30);
        this.jBtnLogout.setBounds(10, 620, 200, 30);
        this.jBtnAddCar.setBounds(10, 290, 200, 30);
        this.jBtnAddTruck.setBounds(10, 330, 200, 30);
        this.jBtnAddLorry.setBounds(10, 370, 200, 30);
        this.jLblCarTitle.setBounds(450, 80, 200, 30);
        this.jLblCarTitle.setFont(new Font("Serif", 1, 20));
        this.jLblLorryTitle.setBounds(450, 240, 200, 30);
        this.jLblLorryTitle.setFont(new Font("Serif", 1, 20));
        this.jLblTruckTitle.setBounds(450, 400, 200, 30);
        this.jLblTruckTitle.setFont(new Font("Serif", 1, 20));
        this.displayVehicleData = new JPanel();
        this.jLblMake = new JLabel("Make: ");
        this.jLblMakeValue = new JLabel("--");
        this.jLblModel = new JLabel("Model: ");
        this.jLblModelValue = new JLabel("--");
        this.jLblTopSpeed = new JLabel("Top Speed: ");
        this.jLblTopSpeedValue = new JLabel("--");
        this.jLblRegistrationNumber = new JLabel("Registration Number: ");
        this.jLblRegistrationNumberValue = new JLabel("--");
        this.jLblDailyHireRate = new JLabel("Daily Hire Rate: ");
        this.jLblDailyHireRateValue = new JLabel("--");
        this.jLblFuelType = new JLabel("Fuel Type: ");
        this.jLblFuelTypeValue = new JLabel("--");
        this.jLblNumberOfDoors = new JLabel("Number of Doors: ");
        this.jLblNumberOfDoorsValue = new JLabel("--");
        this.jLblLoadCapacity = new JLabel("Load Capacity: ");
        this.jLblLoadCapacityValue = new JLabel("--");
        this.jLblSeatingCapacity = new JLabel("Seating Capacity: ");
        this.jLblSeatingCapacityValue = new JLabel("--");
        this.jLblVehicleDetails = new JLabel("DETAILS");
        this.displayVehicleData.setLayout(new BoxLayout(this.displayVehicleData, 1));
        this.displayVehicleData.add(this.jLblMake);
        this.displayVehicleData.add(this.jLblMakeValue);
        this.displayVehicleData.add(this.jLblModel);
        this.displayVehicleData.add(this.jLblModelValue);
        this.displayVehicleData.add(this.jLblTopSpeed);
        this.displayVehicleData.add(this.jLblTopSpeedValue);
        this.displayVehicleData.add(this.jLblRegistrationNumber);
        this.displayVehicleData.add(this.jLblRegistrationNumberValue);
        this.displayVehicleData.add(this.jLblDailyHireRate);
        this.displayVehicleData.add(this.jLblDailyHireRateValue);
        this.displayVehicleData.add(this.jLblFuelType);
        this.displayVehicleData.add(this.jLblFuelTypeValue);
        this.displayVehicleData.add(this.jLblNumberOfDoors);
        this.displayVehicleData.add(this.jLblNumberOfDoorsValue);
        this.displayVehicleData.add(this.jLblLoadCapacity);
        this.displayVehicleData.add(this.jLblLoadCapacityValue);
        this.displayVehicleData.add(this.jLblSeatingCapacity);
        this.displayVehicleData.add(this.jLblSeatingCapacityValue);
        this.displayVehicleData.setBounds(770, 150, 200, 600);
        this.jLblVehicleDetails.setBounds(770, 100, 200, 30);
        this.jLblVehicleDetails.setFont(new Font("Serif", 1, 20));
        this.panel.add(this.displayVehicleData);
        this.panel.add(this.jLblVehicleDetails);
        this.panel.add(this.jLblCarTitle);
        this.panel.add(this.jLblLorryTitle);
        this.panel.add(this.jLblTruckTitle);
        this.panel.add(this.jBtnAddVehicle);
        this.panel.add(this.jBtnRemoveVehicle);
        this.panel.add(this.jBtnRegisterCustomer);
        this.panel.add(this.jBtnRegisterStaff);
        this.panel.add(this.jBtnDisplayAllCustomer);
        this.panel.add(this.jBtnDisplayHireRequest);
        this.panel.add(this.jBtnHireOut).setVisible(false);
        this.panel.add(this.jBtnReturnVehicle).setVisible(false);
        this.panel.add(this.jBtnHiredVehicle);
        this.panel.add(this.jBtnLogout);
        this.panel.add(this.jBtnDisplayVehicles).setVisible(false);
        this.panel.add(this.jBtnAddCar).setVisible(false);
        this.panel.add(this.jBtnAddTruck).setVisible(false);
        this.panel.add(this.jBtnAddLorry).setVisible(false);
        this.panel.setSize(1000, 700);
        frame.add(this.panel);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void displayVehicles(DefaultListModel<String> l1, DefaultListModel<String> l2, DefaultListModel<String> l3) {
        this.carScrollPane = new JScrollPane();
        this.lorryScrollPane = new JScrollPane();
        this.TruckScrollPane = new JScrollPane();
        this.list1 = new JList(l1);
        this.carScrollPane.setViewportView(this.list1);
        this.carScrollPane.setBounds(240, 120, 500, 100);
        this.panel.add(this.carScrollPane);
        this.list2 = new JList(l2);
        this.lorryScrollPane.setViewportView(this.list2);
        this.lorryScrollPane.setBounds(240, 280, 500, 100);
        this.panel.add(this.lorryScrollPane);
        this.list3 = new JList(l3);
        this.TruckScrollPane.setViewportView(this.list3);
        this.TruckScrollPane.setBounds(240, 440, 500, 100);
        this.panel.add(this.TruckScrollPane);
    }

    public void displayError(String error) {
        JOptionPane.showMessageDialog(this.frame, error, "Error", 2);
    }

    public JPanel getVehicleDataDisplayPanel() {
        return this.displayVehicleData;
    }

    public void displayCustomerList(DefaultListModel<String> l4) {
        this.jLblCustomerListTitle = new JLabel("Customers");
        this.customerScrollPane = new JScrollPane();
        this.list4 = new JList(l4);
        this.jLblCustomerListTitle.setFont(new Font("Serif", 1, 20));
        this.customerScrollPane.setViewportView(this.list4);
        this.customerScrollPane.setBounds(240, 130, 500, 400);
        this.jLblCustomerListTitle.setBounds(440, 80, 200, 30);
        this.panel.add(this.customerScrollPane);
        this.panel.add(this.jLblCustomerListTitle);
    }

    public void displayCustomerDetail() {
        this.displayCustomerData = new JPanel();
        this.jLblCustomerDetailsTitle = new JLabel("Customer's Detail");
        this.jLblIdentificationNumber = new JLabel("Identification Number: ");
        this.jLblIdentificationNumberValue = new JLabel("--");
        this.jLblCorporationName = new JLabel("Corporation Name: ");
        this.jLblCorporationNameValue = new JLabel("--");
        this.jLblUsername = new JLabel("Username: ");
        this.jLblUsernameValue = new JLabel("--");
        this.jLblAddress = new JLabel("Address : ");
        this.jLblAddressValue = new JLabel("--");
        this.jLblPhoneNumber = new JLabel("Phone Number: ");
        this.jLblPhoneNumberValue = new JLabel("--");
        this.jLblEmail = new JLabel("Email: ");
        this.jLblEmailValue = new JLabel("--");
        this.displayCustomerData.setLayout(new BoxLayout(this.displayCustomerData, 1));
        this.displayCustomerData.add(this.jLblIdentificationNumber);
        this.displayCustomerData.add(this.jLblIdentificationNumberValue);
        this.displayCustomerData.add(this.jLblCorporationName);
        this.displayCustomerData.add(this.jLblCorporationNameValue);
        this.displayCustomerData.add(this.jLblUsername);
        this.displayCustomerData.add(this.jLblUsernameValue);
        this.displayCustomerData.add(this.jLblAddress);
        this.displayCustomerData.add(this.jLblAddressValue);
        this.displayCustomerData.add(this.jLblPhoneNumber);
        this.displayCustomerData.add(this.jLblPhoneNumberValue);
        this.displayCustomerData.add(this.jLblEmail);
        this.displayCustomerData.add(this.jLblEmailValue);
        this.displayCustomerData.setBounds(770, 130, 200, 600);
        this.jLblCustomerDetailsTitle.setFont(new Font("Serif", 1, 20));
        this.jLblCustomerDetailsTitle.setBounds(770, 80, 200, 30);
        this.panel.add(this.displayCustomerData);
        this.panel.add(this.jLblCustomerDetailsTitle);
    }

    public void displayHireRequests(DefaultListModel<String> l5, DefaultListModel<String> l6, DefaultListModel<String> l7) {
        this.displayHireRequestPanel = new JPanel();
        this.displayHireRequestPanel.setLayout((LayoutManager)null);
        this.carRequestPane = new JScrollPane();
        this.lorryRequestPane = new JScrollPane();
        this.TruckRequestPane = new JScrollPane();
        this.list5 = new JList(l5);
        this.carRequestPane.setViewportView(this.list5);
        this.carRequestPane.setBounds(0, 120, 600, 100);
        JLabel jLblCarRequestTitle = new JLabel("Car Request");
        jLblCarRequestTitle.setBounds(220, 80, 200, 30);
        jLblCarRequestTitle.setFont(new Font("Serif", 1, 20));
        this.displayHireRequestPanel.add(this.carRequestPane);
        this.displayHireRequestPanel.add(jLblCarRequestTitle);
        this.list6 = new JList(l6);
        this.lorryRequestPane.setViewportView(this.list6);
        this.lorryRequestPane.setBounds(0, 280, 600, 100);
        this.displayHireRequestPanel.add(this.lorryRequestPane);
        JLabel jLblLorryRequestTitle = new JLabel("Lorry Request");
        jLblLorryRequestTitle.setBounds(220, 240, 200, 30);
        jLblLorryRequestTitle.setFont(new Font("Serif", 1, 20));
        this.displayHireRequestPanel.add(jLblLorryRequestTitle);
        this.list7 = new JList(l7);
        this.TruckRequestPane.setViewportView(this.list7);
        this.TruckRequestPane.setBounds(0, 440, 600, 100);
        this.displayHireRequestPanel.add(this.TruckRequestPane);
        JLabel jLblTruckRequestTitle = new JLabel("Truck Request");
        jLblTruckRequestTitle.setBounds(220, 400, 200, 30);
        jLblTruckRequestTitle.setFont(new Font("Serif", 1, 20));
        this.displayHireRequestPanel.add(jLblTruckRequestTitle);
        this.displayHireRequestPanel.setBounds(250, 0, 600, 600);
        this.panel.add(this.displayHireRequestPanel);
    }

    public void displayHiredVehicles(String[] hiredVehicles) {
        this.jBtnReturnVehicle.setVisible(true);
        this.displayHiredVehiclePane = new JScrollPane();
        int i = 1;
        DefaultListModel<String> l10 = new DefaultListModel();
        l10.addElement("S.N                              Registration Number                              Hired By                                   Vehicle Type");
        if (hiredVehicles == null) {
            l10.addElement("No Vehicle has been Hired!");
        } else {
            for(String data : hiredVehicles) {
                String[] splittedData = data.split("\\s+");
                String vehicleType;
                if (splittedData[0].contentEquals("car")) {
                    vehicleType = "Car";
                } else if (splittedData[0].contentEquals("lorry")) {
                    vehicleType = "Lorry";
                } else {
                    vehicleType = "Truck";
                }

                l10.addElement(i + "                                  " + splittedData[1] + "                                                  " + splittedData[2] + "                                " + vehicleType);
                ++i;
            }
        }

        this.list10 = new JList(l10);
        this.displayHiredVehiclePane.setViewportView(this.list10);
        this.displayHiredVehiclePane.setBounds(250, 100, 600, 500);
        this.panel.add(this.displayHiredVehiclePane);
    }
}
