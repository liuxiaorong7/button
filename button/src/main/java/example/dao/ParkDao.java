package example.dao;

import example.entity.Park;

import java.util.List;


public interface ParkDao {


    /**   List<Park> findParkInfoByID(int id);
    List<Park> findByName(String name);
    List<Park> findByX(int x);
    List<Park> findByY(int y);
**/


   List <Park> getList();
}
