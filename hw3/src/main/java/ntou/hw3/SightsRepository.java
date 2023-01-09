package ntou.hw3;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SightsRepository extends MongoRepository<Sight, String> {
    ArrayList<Sight> findByZoneLike(String zone);

}
