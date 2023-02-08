package City.Region.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "district")
public class District {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Integer regionId;

    @OneToMany(mappedBy = "districtId")
    private List<Home> homes;
}
