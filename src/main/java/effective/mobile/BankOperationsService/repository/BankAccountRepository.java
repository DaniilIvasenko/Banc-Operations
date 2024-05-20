package effective.mobile.BankOperationsService.repository;

import effective.mobile.BankOperationsService.data.BankAccount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    @Query(value = "select b from BankAccount b " +
            "inner join b.loginPhone p " +
            "where p.phone = ?1")
    BankAccount findAccountByPhone(String phone);
    @Query(value = "select b from BankAccount b " +
            "inner join b.loginEmail e " +
            "where e.email = ?1")
    BankAccount findAccountByEmail(String email);
}
