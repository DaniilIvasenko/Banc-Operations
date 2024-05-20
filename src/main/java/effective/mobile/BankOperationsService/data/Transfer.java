package effective.mobile.BankOperationsService.data;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfers")
@Data
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name ="from_user")
    private  BankAccount from;
    @ManyToOne
    @JoinColumn(name = "to_user")
    private  BankAccount to;

    private BigDecimal amount;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateOfCreation;
}
