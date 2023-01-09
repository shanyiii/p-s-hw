package ntou.hw2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController

public class SightController {
	 public SightController(){

	    }

	    @GetMapping("/sightseeing")
	    public ArrayList<Sight> getSights(@RequestParam(value = "zone", defaultValue = "") String zone){
	        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
	        ArrayList<Sight> sights = crawler.getItem(zone);
	   //     sights = crawler.getItem(zone);
	        for(Sight s : sights){
	            System.out.println(s);
	        }
	        return sights;
	    }
}
