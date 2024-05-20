package effective.mobile.BankOperationsService.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String firstName;
    private  String surname;
    private  String lastName;
    @Column(columnDefinition = "DATE")
    private LocalDate DateOfBirth;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserEmail>  emails;
    //todo попробовать реализовать невозвожность удалить последний телефон и email за счет CascadeType

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private  List<UserPhone> phones;
    @OneToOne(mappedBy = "user")
    private BankAccount bankAccount;
}
