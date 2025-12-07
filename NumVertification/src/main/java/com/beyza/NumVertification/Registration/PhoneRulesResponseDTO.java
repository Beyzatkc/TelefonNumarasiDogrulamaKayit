package com.beyza.NumVertification.Registration;

public class PhoneRulesResponseDTO {
    public String number;
    public PhoneRules rules;
    public boolean isValid;

    public PhoneRulesResponseDTO() {}
    public PhoneRulesResponseDTO(String number, PhoneRules rules, boolean isValid) {
        this.number = number;
        this.rules = rules;
        this.isValid=isValid;
    }
    public PhoneRulesResponseDTO(boolean isValid) {
        this.isValid=isValid;
    }

}
