package com.spring_validationBasic.spring_validationBasic.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class customer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=2, message = "min 2 is required")
    private String lastName;
    @Min(value=4,message = "min should be 4")
    @Max(value=10,message = "max should be 10 number")
    private int phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
