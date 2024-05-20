package effective.mobile.BankOperationsService.security.service;

import effective.mobile.BankOperationsService.data.BankAccount;
import effective.mobile.BankOperationsService.repository.BankAccountRepository;
import effective.mobile.BankOperationsService.security.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class LoginService {

    private final BankAccountRepository bankAccountRepository;

    //Hard coded login setup for JWT showcase, do not use in a real application.
    public Optional<Long> login(LoginDTO loginDTO) {
        BankAccount account = null;
        try{
            Long.parseLong(loginDTO.username());
            account = bankAccountRepository.findAccountByPhone(loginDTO.username());
        }catch (NumberFormatException e){
            account = bankAccountRepository.findAccountByEmail(loginDTO.username());
        }

        if(account==null){
                return Optional.empty();
        }
        String password = account.getPassword();

        if(password != null && password.equals(loginDTO.password())){
            return Optional.of(account.getId());
        }

        return Optional.empty();
    }
}