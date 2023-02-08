package City.Region.controller;

import City.Region.dto.CityDto;
import City.Region.dto.HomeDto;
import City.Region.dto.HomeDtos;
import City.Region.dto.ResponseDto;
import City.Region.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping
    public ResponseDto<List<HomeDtos>> getAllHome(){
        return homeService.getAllHome();
    }

    @GetMapping("/{id}")
    public ResponseDto getHomeById(@PathVariable Integer id){
        return homeService.getHomeById(id);
    }

    @PostMapping
    public ResponseDto addHome(@RequestBody HomeDtos homeDtos){
        return homeService.addHome(homeDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteHome(@PathVariable Integer id){
        return homeService.deleteHome(id);
    }


}
