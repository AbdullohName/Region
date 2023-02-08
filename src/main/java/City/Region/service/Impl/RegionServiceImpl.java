package City.Region.service.Impl;

import City.Region.dto.*;
import City.Region.entity.Region;
import City.Region.mapper.RegionMapper;
import City.Region.repository.RegionRepository;
import City.Region.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository repository;
    private final RegionMapper regionMapper;


    @Override
    public ResponseDto addRegion(RegionDtos regionDtos) {

        repository.save(regionMapper.toEntity(regionDtos));

        return ResponseDto.builder()
                .code(1)
                .success(true)
                .message("succes")
                .build();
    }

    @Override
    public ResponseDto getRegionById(Integer id) {
        Optional<Region> optionalRegion= repository.findById(id);
        if(optionalRegion.isEmpty()){
            return ResponseDto.builder()
                    .code(0)
                    .message("NOT FOUND")
                    .success(false).build();
        }

        RegionDto regionDto = regionMapper.toDto(optionalRegion.get());

        return ResponseDto.builder()
                .code(1)
                .success(true)
                .message("Succes")
                .data(regionDto)
                .build();

    }

    @Override
    public ResponseDto<List<RegionDtos>> getAllRegion() {
        List<Region> regions = repository.findAll();
        List<RegionDtos> regionDtos = regions.stream()
                .map(regionMapper::toDtos)
                .collect(Collectors.toList());
        return ResponseDto.<List<RegionDtos>>builder().message("OK").success(true).code(1).data(regionDtos).build();
    }

    @Override
    public ResponseDto deleteRegion(Integer Id) {
        return null;
    }
}
