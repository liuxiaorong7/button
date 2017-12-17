package example.service;

import example.entity.FreeCar;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface FreeCarService {
    Integer insert();
    Integer delete(int id);
    Integer updateInPark();
    Integer updateOutPark();
    Integer updateFreecar();

    List<FreeCar> list();

}
