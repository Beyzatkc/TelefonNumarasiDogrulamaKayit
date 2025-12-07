package com.beyza.NumVertification.Registration;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationService {
    private final RegistrationRepo registrationRepo;

    public RegistrationService(RegistrationRepo registrationRepo) {
        this.registrationRepo = registrationRepo;
    }
    @Transactional
    public ResponseDTO register(RequestDTO requestDTO){
         if(registrationRepo.existsByPhoneNumber(requestDTO.getPhoneNumber())){
                return new ResponseDTO("denied","Bu numara zaten kayıtlı",false);
         }
        PhoneRulesResponseDTO response=validation(requestDTO.getPhoneNumber());
         if(response.isValid){
             RegistrationEntity entity=new RegistrationEntity();
             entity.setEmail(requestDTO.getEmail());
             entity.setName(requestDTO.getName());
             entity.setRegisterDate(LocalDateTime.now());
             entity.setPhoneNumber(requestDTO.getPhoneNumber());
             registrationRepo.saveAndFlush(entity);
             UserResponseDTO userResponseDTO=new UserResponseDTO(entity);
             return new ResponseDTO("accepted", "Telefon numarası geçerli, kayıt başarıyla oluşturuldu.",userResponseDTO,response.isValid);
         }else{
             return new ResponseDTO("denied","Geçersiz telefon numarası. Lütfen yeni bir numara deneyin.",false);
         }
    }

    public PhoneRulesResponseDTO validation(String phoneNumber){
        boolean nonZero=false;
        boolean three_sum=false;
        boolean odd_even_sum=false;
        boolean isValid=false;

        if (phoneNumber.length() != 6 || !phoneNumber.chars().allMatch(Character::isDigit)) {
            return new PhoneRulesResponseDTO(isValid);
        }
        int[] number = new int[6];
            for (int i = 0; i < 6; i++) {
            number[i] = phoneNumber.charAt(i) - '0';
        }
        for(int i=0;i<6;i++){
            if(number[i]!=0){
                nonZero=true;
            }
        }
        if(number[0]+number[1]+number[2]==number[3]+number[4]+number[5]){
            three_sum=true;
        }

        if(number[0]+number[2]+number[4]==number[1]+number[3]+number[5]){
            odd_even_sum=true;
        }
        PhoneRules rules = new PhoneRules(nonZero, three_sum, odd_even_sum);
        if(nonZero&&three_sum&&odd_even_sum){
            isValid=true;
        }
        return new PhoneRulesResponseDTO(phoneNumber, rules,isValid);
    }

    public List<UserResponseDTO> getLastThreeUsers() {
        List<RegistrationEntity> lastThree = registrationRepo.findLastRegistrations(PageRequest.of(0, 3));
        return lastThree.stream().map(UserResponseDTO::new).toList();
    }

    public ResponseEntity<Long> getTotalUsers() {
        long total = registrationRepo.count();
        return ResponseEntity.ok(total);
    }
}
