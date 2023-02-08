package City.Region.service.Impl;

import City.Region.dto.HomeDto;
import City.Region.dto.HomeDtos;
import City.Region.dto.ResponseDto;
import City.Region.entity.Home;
import City.Region.mapper.HomeMapper;
import City.Region.repository.HomeRepository;
import City.Region.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
    private final HomeRepository repository;
    private final HomeMapper homeMapper;


    @Override
    public ResponseDto addHome(HomeDtos homeDtos) {

        repository.save(homeMapper.toEntity(homeDtos));

        return ResponseDto.builder()
                .code(1)
                .success(true)
                .message("succes")
                .build();
    }

    @Override
    public ResponseDto getHomeById(Integer id) {
        Optional<Home> optionalHome= repository.findById(id);
        if(optionalHome.isEmpty()){
            return ResponseDto.builder()
                    .code(0)
                    .message("NOT FOUND")
                    .success(false).build();
        }

        HomeDto homeDto = homeMapper.toDto(optionalHome.get());

        return ResponseDto.builder()
                .code(1)
                .success(true)
                .message("Succes")
                .data(homeDto)
                .build();

    }

    @Override
    public ResponseDto<List<HomeDtos>> getAllHome() {
        List<Home> homes = repository.findAll();
        List<HomeDtos> homeDtos = homes.stream()
                .map(homeMapper::toDtos)
                .collect(Collectors.toList());
        return ResponseDto.<List<HomeDtos>>builder().message("OK").success(true).code(1).data(homeDtos).build();
    }

    @Override
    public ResponseDto deleteHome(Integer Id) {
        return null;
    }
}
