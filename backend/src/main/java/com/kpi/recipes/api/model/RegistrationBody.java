package com.kpi.recipes.api.model;

import jakarta.validation.constraints.*;

import java.util.Date;

public class RegistrationBody {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Surname cannot be empty")
    private String surname;

    @NotBlank(message = "Patronymic cannot be empty")
    private String patronymic;

    @NotBlank(message = "Email cannot be empty")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Birthday cannot be empty")
    private Date birthdate;

    @NotBlank(message = "Gender cannot be empty")
    @NotNull(message = "Gender cannot be null")
    private String gender;

    @NotBlank(message = "Phone cannot be empty")
    private String phone;

    @NotBlank(message = "Password cannot be empty")
    @NotNull(message = "Password cannot be null")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "Invalid password format")
    private String password;

    @NotBlank(message = "Username cannot be empty")
    @NotNull(message = "Username cannot be null")
    private String username;

    @NotBlank(message = "Role cannot be empty")
    @NotNull(message = "Role cannot be null")
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {return birthdate;}

    public void setBirthdate(Date birthdate) {this.birthdate = birthdate;}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
