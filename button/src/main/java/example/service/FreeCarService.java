package example.service;

import example.entity.FreeCar;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface FreeCarService {
    Integer insert();
    Integer updatePark();
    Integer updateFreecar();
    Integer delete(int id);
    List<FreeCar> list();

}
