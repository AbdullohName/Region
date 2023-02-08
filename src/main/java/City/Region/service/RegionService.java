package City.Region.service;

import City.Region.dto.RegionDtos;
import City.Region.dto.ResponseDto;

import java.util.List;

public interface RegionService {
    ResponseDto addRegion(RegionDtos regionDtos);

    ResponseDto getRegionById(Integer id);

    ResponseDto<List<RegionDtos>> getAllRegion();

    ResponseDto deleteRegion(Integer Id);
}
