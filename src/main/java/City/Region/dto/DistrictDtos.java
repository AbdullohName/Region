package City.Region.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDtos {
    private Integer id;
    private String name;
    private Integer parent_id;
}
