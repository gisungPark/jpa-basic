package hellojpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class OrderItem {

    @Id @GeneratedValue
    private Long id;
    @ManyToOne(fetch = LAZY)
    private Order order;
    private int orderPrice;
    private int count;
}
