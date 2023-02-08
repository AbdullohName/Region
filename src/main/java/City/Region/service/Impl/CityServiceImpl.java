package City.Region.service.Impl;

import City.Region.dto.CityDto;
import City.Region.dto.CityDtos;
import City.Region.dto.ResponseDto;
import City.Region.entity.City;
import City.Region.mapper.CItyMapper;
import City.Region.repository.CityRepository;
import City.Region.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;
    private final CItyMapper cItyMapper;
    private final CityRepository cityRepository;


    @Override
    public ResponseDto addCity(CityDto cityDto) {

        repository.save(cItyMapper.toEntity(cityDto));

        return ResponseDto.builder()
                .code(1)
                .success(true)
                .message("succes")
                .build();
    }

    @Override
    public ResponseDto getCityById(Integer id) {
        Optional<City> optionalCity = repository.findById(id);
        if(optionalCity.isEmpty()){
            return ResponseDto.builder()
                    .code(0)
                    .message("NOT FOUND")
                    .success(false).build();
        }

        CityDto cityDto = cItyMapper.toDto(optionalCity.get());

        return ResponseDto.builder()
                .code(1)
                .success(true)
                .message("Succes")
                .data(cityDto)
                .build();

    }

    @Override
    public ResponseDto<List<CityDtos>> getAll() {
        List<City> cities = cityRepository.findAll();
        List<CityDtos> cityDtos = cities.stream()
                .map(cItyMapper::toDtos)
                .collect(Collectors.toList());
        return ResponseDto.<List<CityDtos>>builder().message("OK").success(true).code(1).data(cityDtos).build();
    }

    @Override
    public ResponseDto deleteCity(Integer Id) {
        return null;
    }
}
