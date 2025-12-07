package com.beyza.NumVertification.Registration;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    private String status;
    private String message;
    private UserResponseDTO userResponseDTO;
    private boolean isValid;

    public ResponseDTO() {

    }
    public ResponseDTO(String status, String message, UserResponseDTO userResponseDTO,boolean isValid) {
        this.status = status;
        this.message = message;
        this.userResponseDTO = userResponseDTO;
        this.isValid=isValid;
    }
    public ResponseDTO(String status, String message, boolean isValid) {
        this.status = status;
        this.message = message;
        this.isValid = isValid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserResponseDTO getUserResponseDTO() {
        return userResponseDTO;
    }

    public void setUserResponseDTO(UserResponseDTO userResponseDTO) {
        this.userResponseDTO = userResponseDTO;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
