package crud.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role  {
    @Id
    private Long ig;

    private String role;


}
