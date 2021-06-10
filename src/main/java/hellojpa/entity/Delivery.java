package hellojpa.entity;

import hellojpa.entity.ch7고급매핑.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;


    private String city;
    private String zipcode;
    private DeliveryStatus status;

}
