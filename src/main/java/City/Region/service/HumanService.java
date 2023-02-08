package City.Region.service;


import City.Region.dto.HumanDto;
import City.Region.dto.ResponseDto;

import java.util.List;

public interface HumanService {
    ResponseDto addHuman(HumanDto humanDto);

    ResponseDto getHumanById(Integer id);

    ResponseDto<List<HumanDto>> getAllHuman();

    ResponseDto deleteHuman(Integer Id);
}
