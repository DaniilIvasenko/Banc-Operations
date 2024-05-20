package effective.mobile.BankOperationsService.repository;

import effective.mobile.BankOperationsService.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
