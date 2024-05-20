package effective.mobile.BankOperationsService.data;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "phones")
@Data
public class UserPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long phone;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
