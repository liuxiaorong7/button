package example.service;

import example.dao.FreeCarDao;
import example.entity.FreeCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeCarServiceImpl implements FreeCarService {
    @Autowired
    FreeCarDao freeCarDao;
    @Override
    public Integer insert() {
        return this.freeCarDao.insert();
    }



    @Override
    public Integer updateInPark() {
        return this.freeCarDao.updateInPark();
    }

    @Override
    public Integer updateOutPark() {
        return this.freeCarDao.updateOutPark();
    }

    @Override
    public Integer updateFreecar() {
        return this.freeCarDao.updateFreecar();
    }

    @Override
    public Integer delete(int id) {
        return this.freeCarDao.delete();
    }

    @Override
    public List<FreeCar> list() {
        return this.freeCarDao.list();
    }
}
