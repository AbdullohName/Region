package City.Region.service.Impl;

import City.Region.dto.HumanDto;
import City.Region.dto.ResponseDto;
import City.Region.entity.Human;
import City.Region.mapper.HumanMapper;
import City.Region.repository.HumanRepository;
import City.Region.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HumanServiceImpl implements HumanService {
    private final HumanRepository repository;
    private final HumanMapper humanMapper;


    @Override
    public ResponseDto addHuman(HumanDto humanDto) {

        repository.save(humanMapper.toEntity(humanDto));

        return ResponseDto.builder()
                .code(1)
                .success(true)
                .message("succes")
                .build();
    }

    @Override
    public ResponseDto getHumanById(Integer id) {
        Optional<Human> optionalHuman= repository.findById(id);
        if(optionalHuman.isEmpty()){
            return ResponseDto.builder()
                    .code(0)
                    .message("NOT FOUND")
                    .success(false).build();
        }

        HumanDto humanDto =humanMapper.toDto(optionalHuman.get());

        return ResponseDto.builder()
                .code(1)
                .success(true)
                .message("Succes")
                .data(humanDto)
                .build();

    }

    @Override
    public ResponseDto<List<HumanDto>> getAllHuman() {
        List<Human> humans = repository.findAll();
        List<HumanDto> humanDto = humans.stream()
                .map(humanMapper::toDto)
                .collect(Collectors.toList());
        return ResponseDto.<List<HumanDto>>builder().message("OK").success(true).code(1).data(humanDto).build();
    }

    @Override
    public ResponseDto deleteHuman(Integer Id) {
        return null;
    }
}
