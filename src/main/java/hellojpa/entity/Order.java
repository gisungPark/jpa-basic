package hellojpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    private LocalDate date;
    private OrderStatus status;
}
