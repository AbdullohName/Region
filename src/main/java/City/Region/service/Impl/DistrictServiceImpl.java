package City.Region.service.Impl;

import City.Region.dto.DistrictDto;
import City.Region.dto.DistrictDtos;
import City.Region.dto.ResponseDto;
import City.Region.entity.District;
import City.Region.mapper.DistrictMapper;
import City.Region.repository.DistrictRepository;
import City.Region.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository repository;
    private final DistrictMapper districtMapper;



    @Override
    public ResponseDto addDistrict(DistrictDto districtDto) {

        repository.save(districtMapper.toEntity(districtDto));

        return ResponseDto.builder()
                .code(1)
                .success(true)
                .message("succes")
                .build();
    }

    @Override
    public ResponseDto getDistrictById(Integer id) {
        Optional<District> optionalDistrict= repository.findById(id);
        if(optionalDistrict.isEmpty()){
            return ResponseDto.builder()
                    .code(0)
                    .message("NOT FOUND")
                    .success(false).build();
        }

        DistrictDto districtDto = districtMapper.toDto(optionalDistrict.get());

        return ResponseDto.builder()
                .code(1)
                .success(true)
                .message("Succes")
                .data(districtDto)
                .build();

    }

    @Override
    public ResponseDto<List<DistrictDtos>> getAllDistrict() {
        List<District> districts = repository.findAll();
        List<DistrictDtos> districtDtos = districts.stream()
                .map(districtMapper::toDtos)
                .collect(Collectors.toList());
        return ResponseDto.<List<DistrictDtos>>builder().message("OK").success(true).code(1).data(districtDtos).build();
    }

    @Override
    public ResponseDto deleteDistrict(Integer Id) {
        return null;
    }
}
