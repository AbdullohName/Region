package City.Region.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeDto {
    private Integer id;
    private String name;
    private Integer parent_id;
    private List<HumanDto> humans;
}
