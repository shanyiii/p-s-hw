package ntou.hw3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SightController {
    @Autowired
    private SightsService service;
    public SightController(){

    }

    @GetMapping("/sightseeing")
    public ArrayList<Sight> getSights(String zone){
        return service.findByZoneLike(zone);
    }
}
