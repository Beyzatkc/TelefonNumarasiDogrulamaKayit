package com.beyza.NumVertification.Registration;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @PostMapping("/registration")
    public ResponseEntity<ResponseDTO> register(@Valid @RequestBody RequestDTO requestDto){
        ResponseDTO dto = registrationService.register(requestDto);
        if(dto.getStatus().equals("accepted")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
        }
    }
    @PostMapping("/phone/validate")
    public ResponseEntity<PhoneRulesResponseDTO> register(@RequestBody PhoneNumberRequestDTO request){
        PhoneRulesResponseDTO dto = registrationService.validation(request.getphoneNumber());
        if(dto.isValid) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
        }
    }
    @GetMapping("/last-three")
    public List<UserResponseDTO> getLastThreeUsers() {
        return registrationService.getLastThreeUsers();
    }

    @GetMapping("/phone/count")
    public ResponseEntity<Long> getTotalUsers() {
        return registrationService.getTotalUsers();
    }
}
