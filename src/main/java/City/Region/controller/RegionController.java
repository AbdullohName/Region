package City.Region.controller;

import City.Region.dto.RegionDto;
import City.Region.dto.RegionDtos;
import City.Region.dto.ResponseDto;
import City.Region.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseDto<List<RegionDtos>> getAllRegion(){
        return regionService.getAllRegion();
    }

    @GetMapping("/{id}")
    public ResponseDto getRegionById(@PathVariable Integer id){

        return regionService.getRegionById(id);
    }

    @PostMapping
    public ResponseDto addRegion(@RequestBody RegionDtos regionDtos){

        return regionService.addRegion(regionDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteRegion(@PathVariable Integer id){
        return regionService.deleteRegion(id);
    }
}
