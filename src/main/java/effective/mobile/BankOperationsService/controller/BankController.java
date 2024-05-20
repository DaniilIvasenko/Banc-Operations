package effective.mobile.BankOperationsService.controller;

import effective.mobile.BankOperationsService.data.User;
import effective.mobile.BankOperationsService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
        @Autowired
        private UserRepository userRepository;
        @GetMapping("test")
        public String test(){
                User user = userRepository.findById(2l).get();
                System.out.println(user.getId());
                return user.toString();
        }

}
