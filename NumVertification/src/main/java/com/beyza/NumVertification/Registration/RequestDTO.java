package com.beyza.NumVertification.Registration;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RequestDTO {
    @NotBlank(message = "Kullanıcı adı boş olamaz")
    private String name;

    @NotBlank(message = "Geçerli bir email girin")
    @NotBlank(message = "Email boş olamaz")
    private String email;

    @NotBlank(message = "Telefon numarası boş olamaz")
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
