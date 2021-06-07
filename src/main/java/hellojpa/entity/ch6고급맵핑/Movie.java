package hellojpa.entity.ch6고급맵핑;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie extends Item{
    private String director;
    private String actor;
}
