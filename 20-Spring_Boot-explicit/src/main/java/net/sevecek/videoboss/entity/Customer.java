package net.sevecek.videoboss.entity;

import java.util.Objects;
import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    private String email;
    private String street;
    private String city;
    private String postalCode;

    @Deprecated
    public Customer() {
        // This constructor is here just for JPA, Jackson & other mapping frameworks.
        // Do NOT use call it directly.
    }

    public Customer(UUID id) {
        this(id, null, null, null, null, null);
    }

    public Customer(String name, String email, String street, String city, String postalCode) {
        this(null, name, email, street, city, postalCode);
    }

    public Customer(UUID id, String name, String email, String street, String city, String postalCode) {
        if (id == null) {
            id = UUID.randomUUID();
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newValue) {
        email = newValue;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String newValue) {
        street = newValue;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String newValue) {
        city = newValue;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String newValue) {
        postalCode = newValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        if (getId() == null) return false;
        return getId().equals(customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Customer " +
                "id=" + id + ", " +
                "name=\"" + name + "\"" + ", " +
                "email=\"" + email + "\"" + ", " +
                "street=\"" + street + "\"" + ", " +
                "city=\"" + city + "\"" + ", " +
                "postalCode=\"" + postalCode + "\"";
    }
}
