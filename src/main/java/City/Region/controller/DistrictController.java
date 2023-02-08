package City.Region.controller;

import City.Region.dto.DistrictDto;
import City.Region.dto.DistrictDtos;
import City.Region.dto.ResponseDto;
import City.Region.service.Impl.DistrictServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
@RequiredArgsConstructor
public class DistrictController {
    private final DistrictServiceImpl districtService;

    @GetMapping
    public ResponseDto<List<DistrictDtos>> getAllDistric(){
        return districtService.getAllDistrict();
    }

    @GetMapping("/{id}")
    public ResponseDto getDistrictById(@PathVariable Integer id){
        return districtService.getDistrictById(id);
    }

    @PostMapping
    public ResponseDto addDistrict(@RequestBody DistrictDto districtDto){

        return districtService.addDistrict(districtDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteDistrict(@PathVariable Integer id){
        return districtService.deleteDistrict(id);
    }

}
