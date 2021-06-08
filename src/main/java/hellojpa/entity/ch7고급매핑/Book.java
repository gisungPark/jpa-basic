package hellojpa.entity.ch7고급매핑;

import hellojpa.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book extends Item {
    private String author;
    private String isbn;
}
