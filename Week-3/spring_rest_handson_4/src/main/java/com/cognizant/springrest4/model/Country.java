package com.cognizant.springrest4.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Country {

    @NotBlank
    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;

    @NotBlank
    private String name;

    @NotBlank
    private String capital;

    public Country() {
    }

    public Country(String code, String name, String capital) {
        this.code = code;
        this.name = name;
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}