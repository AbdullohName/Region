package City.Region.service;


import City.Region.dto.CityDto;
import City.Region.dto.CityDtos;
import City.Region.dto.ResponseDto;

import java.util.List;

public interface CityService {
    ResponseDto addCity(CityDto cityDto);

    ResponseDto getCityById(Integer id);

    ResponseDto<List<CityDtos>> getAll();

    ResponseDto deleteCity(Integer Id);
}
