package hellojpa.entity.ch7고급매핑;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Album extends Item{
    private String artist;
}
