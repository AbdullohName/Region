package City.Region.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Human")
public class Human {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Integer homeId;

    @Column(name = "age")
    private Integer age;

}
