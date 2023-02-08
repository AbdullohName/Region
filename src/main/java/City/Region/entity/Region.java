package City.Region.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Region")
public class Region {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Integer cityId;

    @OneToMany(mappedBy = "regionId")
    private List<District> districts;

}
