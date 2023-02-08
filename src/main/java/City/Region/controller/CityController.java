package City.Region.controller;

import City.Region.dto.CityDto;
import City.Region.dto.CityDtos;
import City.Region.dto.ResponseDto;
import City.Region.service.CityService;
import City.Region.service.Impl.CityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/{id}")
    public ResponseDto getCityById(@PathVariable Integer id){
        return cityService.getCityById(id);
    }

    @PostMapping
    public ResponseDto addCity(@RequestBody CityDto cityDto){
        return cityService.addCity(cityDto);
    }

    @GetMapping()
    public ResponseDto<List<CityDtos>> getAll(){
        return cityService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteCity(@PathVariable Integer id){
        return cityService.deleteCity(id);
    }


}
