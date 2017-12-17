package example.dao;


import example.entity.FreeCar;

import java.util.List;

public interface FreeCarDao {
    Integer insert();
    Integer delete();
    Integer updateInPark();
    Integer updateOutPark();
    Integer updateFreecar();
    List<FreeCar> list();
}
