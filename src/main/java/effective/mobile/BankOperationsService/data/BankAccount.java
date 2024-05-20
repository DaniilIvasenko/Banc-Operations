package effective.mobile.BankOperationsService.data;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "bank_accounts")
@Data
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_phone")
    private UserPhone loginPhone;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_email")
    private  UserEmail loginEmail;
    private String password;
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "user_id")
    private  User user;

    @Transient
    @OneToMany(mappedBy = "from", fetch = FetchType.LAZY)
    private List<Transfer> transfersFromThisUser;
    @Transient
    @OneToMany(mappedBy = "to", fetch = FetchType.LAZY)
    private List<Transfer> transfersToThisUser;
}
