package hellojpa.entity.ch8프록시;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class ch8Team {

    @Id @GeneratedValue
    private Long id;
    private String name;

}
