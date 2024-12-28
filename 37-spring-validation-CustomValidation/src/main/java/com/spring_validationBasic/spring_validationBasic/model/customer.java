package com.spring_validationBasic.spring_validationBasic.model;

import jakarta.validation.constraints.*;

public class customer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=2, message = "min 2 is required")
    private String lastName;
    @NotNull(message = "is required")
    @Min(value=4,message = "min should be 4")
    @Max(value=10,message = "max should be 10 number")
    private Integer phoneNumber;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}
