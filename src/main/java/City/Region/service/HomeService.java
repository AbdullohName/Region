package City.Region.service;

import City.Region.dto.HomeDtos;
import City.Region.dto.ResponseDto;

import java.util.List;

public interface HomeService {
    ResponseDto addHome(HomeDtos homeDto);

    ResponseDto getHomeById(Integer id);

    ResponseDto<List<HomeDtos>> getAllHome();

    ResponseDto deleteHome(Integer Id);
}
