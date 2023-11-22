package com.example.fitnessapp.Model;

public class User {
    String username, password, confirmPassword,
            firstName, surname, displayName, dob,
            phoneNumber, email, address, country,
            personalWebpage, role, notes;

    public User(String username, String password, String confirmPassword, String firstName, String surname, String displayName, String dob, String phoneNumber, String email, String address, String country, String personalWebpage, String role, String notes) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.surname = surname;
        this.displayName = displayName;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.country = country;
        this.personalWebpage = personalWebpage;
        this.role = role;
        this.notes = notes;
    }

    public User(String username, String password,  String firstName, String surname, String displayName, String dob, String phoneNumber, String email, String address, String country, String personalWebpage, String role, String notes) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.displayName = displayName;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.country = country;
        this.personalWebpage = personalWebpage;
        this.role = role;
        this.notes = notes;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPersonalWebpage() {
        return personalWebpage;
    }

    public void setPersonalWebpage(String personalWebpage) {
        this.personalWebpage = personalWebpage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
