package user;

public class User implements java.io.Serializable {
    private static final long serialVersionUID = -1854164540782951961L;
    private java.lang.String identificationNumber;
    private java.lang.String corporationName;
    private java.lang.String address;
    private java.lang.String phoneNumber;
    private java.lang.String email;
    private java.lang.String username;
    private java.lang.String password;

    public User() { /* compiled code */ }

    public <T> void storeObject(T cl, java.lang.String fileName) { /* compiled code */ }

    public <T> java.util.ArrayList<T> getObjects(java.lang.String fileName) { /* compiled code */ }

    public java.util.ArrayList<java.lang.String> validateStaff(java.lang.String username, java.lang.String password) { /* compiled code */ }

    public java.util.ArrayList<java.lang.String> validateCustomer(java.lang.String identificationNumber, java.lang.String corporationName, java.lang.String address, java.lang.String phoneNumber, java.lang.String email, java.lang.String username, java.lang.String password) { /* compiled code */ }

    public java.lang.String getIdentificationNumber() { /* compiled code */ }

    public void setIdentificationNumber(java.lang.String identificationNumber) { /* compiled code */ }

    public java.lang.String getCorporationName() { /* compiled code */ }

    public void setCorporationName(java.lang.String corporationName) { /* compiled code */ }

    public java.lang.String getAddress() { /* compiled code */ }

    public void setAddress(java.lang.String address) { /* compiled code */ }

    public java.lang.String getPhoneNumber() { /* compiled code */ }

    public void setPhoneNumber(java.lang.String phoneNumber) { /* compiled code */ }

    public java.lang.String getEmail() { /* compiled code */ }

    public void setEmail(java.lang.String email) { /* compiled code */ }

    public java.lang.String getUsername() { /* compiled code */ }

    public void setUsername(java.lang.String username) { /* compiled code */ }

    public java.lang.String getPassword() { /* compiled code */ }

    public void setPassword(java.lang.String password) { /* compiled code */ }
}