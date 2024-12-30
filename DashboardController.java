package dashboard;

import car.Car;
import car.CarController;
import car.CarView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import login.Login;
import login.LoginController;
import login.LoginView;
import lorry.Lorry;
import lorry.LorryController;
import lorry.LorryView;
import Truck.Truck;
import Truck.TruckController;
import Truck.TruckView;
import user.User;
import user.UserController;
import user.UserView;

public class DashboardController implements ActionListener {
    private StaffDashboardView staffView;
    private CustomerDashboardView customerView;
    private Dashboard model;
    private JFrame frame;
    ArrayList<Car> cars;
    ArrayList<Truck> Truckes;
    ArrayList<Lorry> lorries;
    ArrayList<User> customers;
    Car car;
    Truck Truck;
    Lorry lorry;
    User user;
    String username;

    public DashboardController(final StaffDashboardView staffView, CustomerDashboardView customerView, Dashboard model, JFrame frame, String accountType, String username) {
        this.staffView = staffView;
        this.customerView = customerView;
        this.model = model;
        this.frame = frame;
        this.username = username;
        this.car = new Car("", 0, 0, "", (double)0.0F, "", 0);
        this.Truck = new Truck("", 0, 0, "", (double)0.0F, 0);
        this.lorry = new Lorry("", 0, 0, "", (double)0.0F, 0);
        this.user = new User();
        File file1 = new File("./src/resources/carObjects.dat");
        File file2 = new File("./src/resources/TruckObjects.dat");
        File file3 = new File("./src/resources/lorryObjects.dat");
        File file4 = new File("./src/resources/customerObjects.dat");
        if (file1.exists()) {
            this.cars = this.car.getObjects("./src/resources/carObjects.dat");
        } else {
            this.cars = null;
        }

        if (file2.exists()) {
            this.Truckes = this.Truck.getObjects("./src/resources/TruckObjects.dat");
        } else {
            this.Truckes = null;
        }

        if (file3.exists()) {
            this.lorries = this.lorry.getObjects("./src/resources/lorryObjects.dat");
        } else {
            this.lorries = null;
        }

        if (file4.exists()) {
            this.customers = this.user.getObjects("./src/resources/customerObjects.dat");
        } else {
            this.customers = null;
        }

        if (accountType.contentEquals("customer")) {
            customerView.GUI(frame);
            customerView.displayVehicles(model.getCustomersCarList(this.cars, model.getHiredVehicles("./src/resources/hiredVehicle.txt")), model.getCustomersTruckList(this.Truckes, model.getHiredVehicles("./src/resources/hiredVehicle.txt")), model.getCustomersLorryList(this.lorries, model.getHiredVehicles("./src/resources/hiredVehicle.txt")), model.getHiredVehicles("./src/resources/hiredVehicle.txt"));
            customerView.jBtnRequestVehicle.addActionListener(this);
            customerView.jBtnViewProfile.addActionListener(this);
            customerView.jBtnDisplayHiredVehicles.addActionListener(this);
            customerView.jBtnDisplayVehicles.addActionListener(this);
            customerView.jBtnLogout.addActionListener(this);
        } else {
            staffView.GUI(frame);
            staffView.displayVehicles(model.getStaffVehicleList(this.cars, "No cars addeed!"), model.getStaffVehicleList(this.lorries, "No Lorry addeed!"), model.getStaffVehicleList(this.Truckes, "No Truck addeed!"));
            this.user = new User();
            File file = new File("./src/resources/customerObjects.dat");
            ArrayList<User> users = null;
            if (file.exists()) {
                users = this.user.getObjects("./src/resources/customerObjects.dat");
            }

            staffView.displayCustomerList(model.getCustomersList(users));
            staffView.displayCustomerDetail();
            staffView.displayCustomerData.setVisible(false);
            staffView.customerScrollPane.setVisible(false);
            staffView.jLblCustomerListTitle.setVisible(false);
            staffView.jLblCustomerDetailsTitle.setVisible(false);
            staffView.jBtnRegisterStaff.addActionListener(this);
            staffView.jBtnRegisterCustomer.addActionListener(this);
            staffView.jBtnAddVehicle.addActionListener(this);
            staffView.jBtnRemoveVehicle.addActionListener(this);
            staffView.jBtnDisplayAllCustomer.addActionListener(this);
            staffView.jBtnAddCar.addActionListener(this);
            staffView.jBtnAddTruck.addActionListener(this);
            staffView.jBtnAddLorry.addActionListener(this);
            staffView.jBtnDisplayHireRequest.addActionListener(this);
            staffView.jBtnHireOut.addActionListener(this);
            staffView.jBtnHiredVehicle.addActionListener(this);
            staffView.jBtnReturnVehicle.addActionListener(this);
            staffView.jBtnLogout.addActionListener(this);
            staffView.jBtnDisplayVehicles.addActionListener(this);
            staffView.list1.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting() && staffView.list1.getSelectedIndex() > 0 && !((String)staffView.list1.getSelectedValue()).contentEquals("No Cars Added!")) {
                        Car carObj = (Car)DashboardController.this.cars.get(staffView.list1.getSelectedIndex() - 1);
                        staffView.jLblNumberOfDoorsValue.setVisible(true);
                        staffView.jLblNumberOfDoors.setVisible(true);
                        staffView.jLblFuelTypeValue.setVisible(true);
                        staffView.jLblFuelType.setVisible(true);
                        staffView.jLblMakeValue.setText(carObj.getMake());
                        staffView.jLblModelValue.setText(String.valueOf(carObj.getModel()));
                        staffView.jLblTopSpeedValue.setText(String.valueOf(carObj.getTopSpeed()));
                        staffView.jLblRegistrationNumberValue.setText(carObj.getRegistrationNumber());
                        staffView.jLblDailyHireRateValue.setText(String.valueOf(carObj.getDailyHireRate()));
                        staffView.jLblFuelTypeValue.setText(carObj.getFuelType());
                        staffView.jLblNumberOfDoorsValue.setText(String.valueOf(carObj.getNumberOfDoors()));
                        staffView.jLblLoadCapacity.setVisible(false);
                        staffView.jLblLoadCapacityValue.setVisible(false);
                        staffView.jLblSeatingCapacity.setVisible(false);
                        staffView.jLblSeatingCapacityValue.setVisible(false);
                    }

                }
            });
            staffView.list2.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting() && staffView.list2.getSelectedIndex() > 0 && !((String)staffView.list2.getSelectedValue()).contentEquals("No Lorry Added!")) {
                        Lorry lorryObj = (Lorry)DashboardController.this.lorries.get(staffView.list2.getSelectedIndex() - 1);
                        staffView.jLblLoadCapacity.setVisible(true);
                        staffView.jLblLoadCapacityValue.setVisible(true);
                        staffView.jLblMakeValue.setText(lorryObj.getMake());
                        staffView.jLblModelValue.setText(String.valueOf(lorryObj.getModel()));
                        staffView.jLblTopSpeedValue.setText(String.valueOf(lorryObj.getTopSpeed()));
                        staffView.jLblRegistrationNumberValue.setText(lorryObj.getRegistrationNumber());
                        staffView.jLblDailyHireRateValue.setText(String.valueOf(lorryObj.getDailyHireRate()));
                        staffView.jLblLoadCapacityValue.setText(String.valueOf(lorryObj.getLoadCapacity()));
                        staffView.jLblNumberOfDoorsValue.setVisible(false);
                        staffView.jLblNumberOfDoors.setVisible(false);
                        staffView.jLblSeatingCapacity.setVisible(false);
                        staffView.jLblSeatingCapacityValue.setVisible(false);
                        staffView.jLblFuelTypeValue.setVisible(false);
                        staffView.jLblFuelType.setVisible(false);
                    }

                }
            });
            staffView.list3.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting() && staffView.list3.getSelectedIndex() > 0 && !((String)staffView.list3.getSelectedValue()).contentEquals("No Truck Added!")) {
                        Truck Truck = (Truck)DashboardController.this.Truckes.get(staffView.list3.getSelectedIndex() - 1);
                        staffView.jLblSeatingCapacity.setVisible(true);
                        staffView.jLblSeatingCapacityValue.setVisible(true);
                        staffView.jLblMakeValue.setText(Truck.getMake());
                        staffView.jLblModelValue.setText(String.valueOf(Truck.getModel()));
                        staffView.jLblTopSpeedValue.setText(String.valueOf(Truck.getTopSpeed()));
                        staffView.jLblRegistrationNumberValue.setText(Truck.getRegistrationNumber());
                        staffView.jLblDailyHireRateValue.setText(String.valueOf(Truck.getDailyHireRate()));
                        staffView.jLblSeatingCapacityValue.setText(String.valueOf(Truck.getSeatingCapacity()));
                        staffView.jLblNumberOfDoorsValue.setVisible(false);
                        staffView.jLblNumberOfDoors.setVisible(false);
                        staffView.jLblLoadCapacity.setVisible(false);
                        staffView.jLblLoadCapacityValue.setVisible(false);
                        staffView.jLblFuelTypeValue.setVisible(false);
                        staffView.jLblFuelType.setVisible(false);
                    }

                }
            });
            staffView.list4.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting() && staffView.list4.getSelectedIndex() > 0 && !((String)staffView.list4.getSelectedValue()).contentEquals("No Customers Added!")) {
                        User user = (User)DashboardController.this.customers.get(staffView.list4.getSelectedIndex() - 1);
                        staffView.jLblIdentificationNumberValue.setText(user.getIdentificationNumber());
                        staffView.jLblCorporationNameValue.setText(user.getCorporationName());
                        staffView.jLblAddressValue.setText(user.getAddress());
                        staffView.jLblPhoneNumberValue.setText(user.getPhoneNumber());
                        staffView.jLblEmailValue.setText(user.getEmail());
                        staffView.jLblUsernameValue.setText(user.getUsername());
                    }

                }
            });
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.staffView.jBtnRegisterCustomer) {
            this.staffView.getPanel().setVisible(false);
            User user = new User();
            UserView userView = new UserView();
            new UserController(userView, user, this.frame, "customer");
        } else if (e.getSource() == this.staffView.jBtnRegisterStaff) {
            this.staffView.getPanel().setVisible(false);
            User user = new User();
            UserView userView = new UserView();
            new UserController(userView, user, this.frame, "staff");
        } else if (e.getSource() == this.staffView.jBtnAddVehicle) {
            this.staffView.jBtnAddCar.setVisible(true);
            this.staffView.jBtnAddTruck.setVisible(true);
            this.staffView.jBtnAddLorry.setVisible(true);
        } else if (e.getSource() == this.staffView.jBtnAddCar) {
            this.staffView.getPanel().setVisible(false);
            CarView carView = new CarView();
            Car carModel = new Car("", 0, 0, "", (double)0.0F, "", 0);
            new CarController(carView, carModel, this.frame, this.username);
        } else if (e.getSource() == this.staffView.jBtnAddTruck) {
            this.staffView.getPanel().setVisible(false);
            Truck Truck = new Truck("", 0, 0, "", (double)0.0F, 0);
            TruckView TruckView = new TruckView();
            new TruckController(TruckView, Truck, this.frame, this.username);
        } else if (e.getSource() == this.staffView.jBtnAddLorry) {
            this.staffView.getPanel().setVisible(false);
            Lorry lorry = new Lorry("", 0, 0, "", (double)0.0F, 0);
            LorryView lorryView = new LorryView();
            new LorryController(lorryView, lorry, this.frame, this.username);
        } else if (e.getSource() == this.staffView.jBtnRemoveVehicle) {
            if (this.staffView.list1.getSelectedIndex() < 1 && this.staffView.list2.getSelectedIndex() < 1 && this.staffView.list3.getSelectedIndex() < 1) {
                this.staffView.displayError("Select One from the list");
            } else {
                if (this.staffView.list1.getSelectedIndex() > 0 && !((String)this.staffView.list1.getSelectedValue()).contentEquals("No Cars Added!")) {
                    this.car.delete(this.cars, (Car)this.cars.get(this.staffView.list1.getSelectedIndex() - 1), "./src/resources/carObjects.dat");
                    this.staffView.getPanel().setVisible(false);
                    new DashboardController(this.staffView, this.customerView, this.model, this.frame, "staff", this.username);
                }

                if (this.staffView.list2.getSelectedIndex() > 0 && !((String)this.staffView.list2.getSelectedValue()).contentEquals("No Lorry Added!")) {
                    this.lorry.delete(this.lorries, (Lorry)this.lorries.get(this.staffView.list2.getSelectedIndex() - 1), "./src/resources/lorryObjects.dat");
                    this.staffView.getPanel().setVisible(false);
                    new DashboardController(this.staffView, this.customerView, this.model, this.frame, "staff", this.username);
                }

                if (this.staffView.list3.getSelectedIndex() > 0 && !((String)this.staffView.list3.getSelectedValue()).contentEquals("No Truck Added!")) {
                    this.Truck.delete(this.Truckes, (Truck)this.Truckes.get(this.staffView.list3.getSelectedIndex() - 1), "./src/resources/TruckObjects.dat");
                    this.staffView.getPanel().setVisible(false);
                    new DashboardController(this.staffView, this.customerView, this.model, this.frame, "staff", this.username);
                }
            }
        } else if (e.getSource() == this.staffView.jBtnDisplayAllCustomer) {
            this.staffView.jBtnDisplayVehicles.setVisible(true);
            this.staffView.displayCustomerData.setVisible(true);
            this.staffView.customerScrollPane.setVisible(true);
            this.staffView.jLblCustomerListTitle.setVisible(true);
            this.staffView.jLblCustomerDetailsTitle.setVisible(true);
            if (this.staffView.displayHireRequestPanel != null) {
                this.staffView.displayHireRequestPanel.setVisible(false);
            }

            if (this.staffView.displayHiredVehiclePane != null) {
                this.staffView.displayHiredVehiclePane.setVisible(false);
            }

            this.hideVehiclesList();
        } else if (e.getSource() == this.customerView.jBtnRequestVehicle) {
            if (this.customerView.list1.getSelectedIndex() < 1 && this.customerView.list2.getSelectedIndex() < 1 && this.customerView.list3.getSelectedIndex() < 1) {
                this.customerView.displayError("Select One from the list");
            } else {
                if (this.customerView.list1.getSelectedIndex() > 0 && !((String)this.customerView.list1.getSelectedValue()).contentEquals("No Cars Added!")) {
                    int dialogButton = 0;
                    int dialogResult = JOptionPane.showConfirmDialog((Component)null, "Would You Like to hire this vehicle?", "Confirm", dialogButton);
                    if (dialogResult == 0) {
                        try {
                            PrintWriter outputFile = new PrintWriter(new FileWriter("./src/resources/vehicleHireRequests.txt", true));
                            outputFile.println("car " + ((Car)this.cars.get(this.customerView.list1.getSelectedIndex() - 1)).getRegistrationNumber() + " " + this.username);
                            outputFile.close();
                            this.customerView.list1.clearSelection();
                            this.customerView.displaySuccessMessage();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }

                if (this.customerView.list2.getSelectedIndex() > 0 && !((String)this.customerView.list2.getSelectedValue()).contentEquals("No Lorry Added!")) {
                    try {
                        int loadWeight = Integer.parseInt(JOptionPane.showInputDialog(this.frame, "Enter Load Weight: ", 1));
                        if (loadWeight > 0) {
                            try {
                                PrintWriter outputFile = new PrintWriter(new FileWriter("./src/resources/vehicleHireRequests.txt", true));
                                outputFile.println("lorry " + ((Lorry)this.lorries.get(this.customerView.list2.getSelectedIndex() - 1)).getRegistrationNumber() + " " + this.username + " " + loadWeight);
                                outputFile.close();
                                this.customerView.list2.clearSelection();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            this.customerView.displayError("Load Weight cannot be negative!");
                        }
                    } catch (NumberFormatException var9) {
                        this.customerView.displayError("Load Weight must be integer!");
                    }
                }

                if (this.customerView.list3.getSelectedIndex() > 0 && !((String)this.customerView.list3.getSelectedValue()).contentEquals("No Truck Added!")) {
                    int seats = Integer.parseInt(JOptionPane.showInputDialog(this.frame, "Enter number of seats required: ", 1));
                    if (seats > 0) {
                        try {
                            PrintWriter outputFile = new PrintWriter(new FileWriter("./src/resources/vehicleHireRequests.txt", true));
                            outputFile.println("Truck " + ((Truck)this.Truckes.get(this.customerView.list3.getSelectedIndex() - 1)).getRegistrationNumber() + " " + this.username + " " + seats);
                            outputFile.close();
                            this.customerView.list3.clearSelection();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        this.customerView.displayError("Seats cannot be negative!");
                    }
                }
            }
        } else if (e.getSource() == this.staffView.jBtnDisplayHireRequest) {
            this.staffView.jBtnDisplayVehicles.setVisible(true);
            this.hideVehiclesList();
            if (this.staffView.displayCustomerData != null) {
                this.staffView.displayCustomerData.setVisible(false);
                this.staffView.customerScrollPane.setVisible(false);
                this.staffView.jLblCustomerListTitle.setVisible(false);
                this.staffView.jLblCustomerDetailsTitle.setVisible(false);
            }

            if (this.staffView.displayHiredVehiclePane != null) {
                this.staffView.displayHiredVehiclePane.setVisible(false);
                this.staffView.jBtnReturnVehicle.setVisible(false);
            }

            this.staffView.jBtnHireOut.setVisible(true);
            ArrayList<String> list = new ArrayList();
            File requestFile = new File("./src/resources/vehicleHireRequests.txt");
            if (requestFile.exists()) {
                try {
                    Scanner inputFile = new Scanner(requestFile);

                    while(inputFile.hasNext()) {
                        list.add(inputFile.nextLine());
                    }

                    inputFile.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            } else {
                list = null;
            }

            ArrayList<String> hiredVehicleList = this.model.getHiredVehicles("./src/resources/hiredVehicle.txt");
            this.staffView.displayHireRequests(this.model.getVehiceHireRequestList(list, hiredVehicleList, "car"), this.model.getVehiceHireRequestList(list, hiredVehicleList, "lorry"), this.model.getVehiceHireRequestList(list, hiredVehicleList, "Truck"));
        } else if (e.getSource() == this.staffView.jBtnHireOut) {
            if (this.staffView.list5.getSelectedIndex() < 1 && this.staffView.list6.getSelectedIndex() < 1 && this.staffView.list7.getSelectedIndex() < 1) {
                this.staffView.displayError("Select One from the list");
            } else {
                if (this.staffView.list5.getSelectedIndex() > 0 && !((String)this.staffView.list5.getSelectedValue()).contentEquals("No Vehicle Hire Request!")) {
                    this.model.writeHiredVehicle("./src/resources/hiredVehicle.txt", (String)this.staffView.list5.getSelectedValue(), "car");
                    this.staffView.getPanel().setVisible(false);
                    JOptionPane.showMessageDialog(this.frame, "The vehicle has been hired out to customer!", "Vehicle Hire System", 1);
                    new DashboardController(this.staffView, this.customerView, this.model, this.frame, "staff", this.username);
                }

                if (this.staffView.list6.getSelectedIndex() > 0 && !((String)this.staffView.list6.getSelectedValue()).contentEquals("No Vehicle Hire Request!")) {
                    this.model.writeHiredVehicle("./src/resources/hiredVehicle.txt", (String)this.staffView.list6.getSelectedValue(), "lorry");
                    this.staffView.getPanel().setVisible(false);
                    JOptionPane.showMessageDialog(this.frame, "The vehicle has been hired out to customer!", "Vehicle Hire System", 1);
                    new DashboardController(this.staffView, this.customerView, this.model, this.frame, "staff", this.username);
                }

                if (this.staffView.list7.getSelectedIndex() > 0 && !((String)this.staffView.list7.getSelectedValue()).contentEquals("No Vehicle Hire Request!")) {
                    this.model.writeHiredVehicle("./src/resources/hiredVehicle.txt", (String)this.staffView.list7.getSelectedValue(), "Truck");
                    this.staffView.getPanel().setVisible(false);
                    JOptionPane.showMessageDialog(this.frame, "The vehicle has been hired out to customer!", "Vehicle Hire System", 1);
                    new DashboardController(this.staffView, this.customerView, this.model, this.frame, "staff", this.username);
                }
            }
        } else if (e.getSource() == this.staffView.jBtnHiredVehicle) {
            this.staffView.jBtnDisplayVehicles.setVisible(true);
            this.hideVehiclesList();
            this.staffView.jBtnReturnVehicle.setVisible(true);
            if (this.staffView.displayHireRequestPanel != null) {
                this.staffView.displayHireRequestPanel.setVisible(false);
                this.staffView.jBtnHireOut.setVisible(false);
            }

            if (this.staffView.displayCustomerData != null) {
                this.staffView.displayCustomerData.setVisible(false);
                this.staffView.customerScrollPane.setVisible(false);
                this.staffView.jLblCustomerListTitle.setVisible(false);
                this.staffView.jLblCustomerDetailsTitle.setVisible(false);
            }

            ArrayList<String> hiredVehicles = this.model.getHiredVehicles("./src/resources/hiredVehicle.txt");
            if (hiredVehicles != null) {
                this.staffView.displayHiredVehicles((String[])hiredVehicles.toArray(new String[0]));
            } else {
                this.staffView.displayHiredVehicles((String[])null);
            }
        } else if (e.getSource() == this.staffView.jBtnReturnVehicle) {
            if (this.staffView.list10.getSelectedIndex() > 0 && !((String)this.staffView.list10.getSelectedValue()).contentEquals("No Vehicle has been Hired!")) {
                ArrayList<String> hiredVehicles = this.model.getHiredVehicles("./src/resources/hiredVehicle.txt");
                String currentVal1 = (String)this.staffView.list10.getSelectedValue();
                String[] currentVal = currentVal1.split("\\s+");

                for(int i = 0; i < hiredVehicles.size(); ++i) {
                    String[] split = ((String)hiredVehicles.get(i)).split(" ");
                    if (currentVal[1].contentEquals(split[1])) {
                        hiredVehicles.remove(i);
                    }
                }

                this.model.rewriteHiredVehicle("./src/resources/hiredVehicle.txt", hiredVehicles);
                this.staffView.getPanel().setVisible(false);
                new DashboardController(this.staffView, this.customerView, this.model, this.frame, "staff", this.username);
            }
        } else if (e.getSource() == this.customerView.jBtnViewProfile) {
            this.customerView.jBtnRequestVehicle.setVisible(false);
            this.customerView.jBtnDisplayVehicles.setVisible(true);
            this.hideCustomerVehicles();
            if (this.customerView.hiredVehiclePanel != null) {
                this.customerView.hiredVehiclePanel.setVisible(false);
                this.customerView.jLblHiredVehicle.setVisible(false);
            }

            User user = this.model.getUser(this.username, this.model.getObjects("./src/resources/customerObjects.dat"));
            this.customerView.displayUserData(user);
        } else if (e.getSource() == this.customerView.jBtnDisplayHiredVehicles) {
            this.customerView.jBtnRequestVehicle.setVisible(false);
            this.customerView.jBtnDisplayVehicles.setVisible(true);
            if (this.customerView.userDataPanel != null) {
                this.customerView.userDataPanel.setVisible(false);
                this.customerView.jLblProfileTitle.setVisible(false);
            }

            this.hideCustomerVehicles();
            this.customerView.displayHiredVehicles(this.model.getCustomersHiredVehicle(this.username, this.cars, this.lorries, this.Truckes));
        } else if (e.getSource() == this.staffView.jBtnLogout) {
            this.staffView.getPanel().setVisible(false);
            Login loginModel = new Login();
            LoginView loginView = new LoginView();
            new LoginController(loginView, loginModel, this.frame);
        } else if (e.getSource() == this.staffView.jBtnDisplayVehicles) {
            this.staffHomepage();
        } else if (e.getSource() == this.customerView.jBtnDisplayVehicles) {
            this.customerHomepage();
        } else if (e.getSource() == this.customerView.jBtnLogout) {
            this.customerView.getPanel().setVisible(false);
            Login loginModel = new Login();
            LoginView loginView = new LoginView();
            new LoginController(loginView, loginModel, this.frame);
        }

    }

    public void hideVehiclesList() {
        if (this.staffView.carScrollPane != null) {
            this.staffView.getVehicleDataDisplayPanel().setVisible(false);
            this.staffView.carScrollPane.setVisible(false);
            this.staffView.TruckScrollPane.setVisible(false);
            this.staffView.lorryScrollPane.setVisible(false);
            this.staffView.jLblCarTitle.setVisible(false);
            this.staffView.jLblLorryTitle.setVisible(false);
            this.staffView.jLblTruckTitle.setVisible(false);
            this.staffView.jLblVehicleDetails.setVisible(false);
        }

    }

    public void staffHomepage() {
        this.staffView.getPanel().setVisible(false);
        new DashboardController(this.staffView, this.customerView, this.model, this.frame, "staff", this.username);
    }

    public void customerHomepage() {
        this.customerView.getPanel().setVisible(false);
        new DashboardController(this.staffView, this.customerView, this.model, this.frame, "customer", this.username);
    }

    public void hideCustomerVehicles() {
        this.customerView.carScrollPane.setVisible(false);
        this.customerView.lorryScrollPane.setVisible(false);
        this.customerView.TruckScrollPane.setVisible(false);
        this.customerView.jLblTruckTitle.setVisible(false);
        this.customerView.jLblCarTitle.setVisible(false);
        this.customerView.jLblLorryTitle.setVisible(false);
    }
}
