package example.service;

import example.dao.ParkDao;
import example.entity.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParkServiceImpl implements ParkService{
    @Autowired
    ParkDao parkDao;


    @Override
    public List<Park> getList() {
        return this.parkDao.getList();
    }





}
