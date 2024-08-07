package io.spring.beans;

public class Address {
    // Properties of the Address class
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String apartmentNumber;
    private String landmark;

    // Constructor
    public Address() {
        System.out.println("Address bean created!");
    }

    public Address(String street, String city, String state, String postalCode, String country,
                   String apartmentNumber, String landmark) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.apartmentNumber = apartmentNumber;
        this.landmark = landmark;
    }

    // Getters and Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    // Method to display address details in a decorative manner
    public void displayDetails() {
        String border = "==========================================";
        String header = "            Address Details               ";
        String line1 = String.format("%-20s : %s", "Street", street);
        String line2 = String.format("%-20s : %s", "City", city);
        String line3 = String.format("%-20s : %s", "State", state);
        String line4 = String.format("%-20s : %s", "Postal Code", postalCode);
        String line5 = String.format("%-20s : %s", "Country", country);
        String line6 = String.format("%-20s : %s", "Apartment Number", apartmentNumber);
        String line7 = String.format("%-20s : %s", "Landmark", landmark);

        System.out.println("\n" + border);
        System.out.println(header);
        System.out.println(border);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println(line6);
        System.out.println(line7);
        System.out.println(border);
    }

    // Method to format the address details as a single string
    public String formatAddress() {
        StringBuilder formattedAddress = new StringBuilder();
        if (apartmentNumber != null && !apartmentNumber.isEmpty()) {
            formattedAddress.append(apartmentNumber).append(", ");
        }
        formattedAddress.append(street).append(", ");
        if (landmark != null && !landmark.isEmpty()) {
            formattedAddress.append("near ").append(landmark).append(", ");
        }
        formattedAddress.append(city).append(", ").append(state).append(" ").append(postalCode).append(", ").append(country);
        return formattedAddress.toString();
    }

    // Override toString method
    @Override
    public String toString() {
        return formatAddress();
    }
}
