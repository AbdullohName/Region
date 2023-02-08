package City.Region.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Home")
public class Home {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Integer districtId;

    @OneToMany(mappedBy = "homeId")
    private List<Human> humans;
}
