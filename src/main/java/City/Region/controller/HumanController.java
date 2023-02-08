package City.Region.controller;

import City.Region.dto.CityDto;
import City.Region.dto.HumanDto;
import City.Region.dto.ResponseDto;
import City.Region.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/human")
public class HumanController {
    @Autowired
    private HumanService humanService;

    @GetMapping
    public ResponseDto<List<HumanDto>> getAllHuman(){
        return humanService.getAllHuman();
    }

    @GetMapping("/{id}")
    public ResponseDto getHumanById(@PathVariable Integer id){

        return humanService.getHumanById(id);
    }

    @PostMapping
    public ResponseDto addDistrict(@RequestBody HumanDto humanDto){

        return humanService.addHuman(humanDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteHuman(@PathVariable Integer id){
        return humanService.deleteHuman(id);
    }
}
