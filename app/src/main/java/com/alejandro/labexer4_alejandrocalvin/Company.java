package com.alejandro.labexer4_alejandrocalvin;

public class Company {
    private int logo;
    private String name, country, industry, ceo, description;

    public Company(int logo, String name, String country, String industry, String ceo, String description) {
        this.logo = logo;
        this.name = name;
        this.country = country;
        this.industry = industry;
        this.ceo = ceo;
        this.description = description;
    }
    public int getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getIndustry() {
        return industry;
    }

    public String getCEO() {
        return ceo;
    }

    public String getDescription() {
        return description;
    }
}
