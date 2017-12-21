package example.dao;


import example.entity.FreeCar;

import java.util.List;

public interface FreeCarDao {
  /**  List<FreeCar> findFreeCarByID(int ID);
    List<FreeCar> findFreeCarByFreeCar(int freeCar);
    List<FreeCar> findByTime(Timestamp time);
   **/
    Integer insert();

    Integer delete(int id);
    Integer updatePark();
    Integer updateFreecar();
    List<FreeCar> list();


}
