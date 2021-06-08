package hellojpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Delivery {

    @Id @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;


    private String city;
    private String zipcode;
    private DeliveryStatus status;

}
