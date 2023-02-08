package City.Region.entity;

import City.Region.dto.RegionDtos;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "city")
public class City {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cityId")
    private List<Region> regions;

}
