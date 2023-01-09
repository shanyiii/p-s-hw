package ntou.hw3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class SightsService {
    @Autowired
    private SightsRepository repo;

    public ArrayList<Sight> findByZoneLike(String zone){
        return repo.findByZoneLike(zone);
    }
}
