package City.Region.service;

import City.Region.dto.DistrictDto;
import City.Region.dto.DistrictDtos;
import City.Region.dto.ResponseDto;

import java.util.List;

public interface DistrictService {
    ResponseDto addDistrict(DistrictDto districtDto);

    ResponseDto getDistrictById(Integer id);

    ResponseDto<List<DistrictDtos>> getAllDistrict();

    ResponseDto deleteDistrict(Integer Id);
}
