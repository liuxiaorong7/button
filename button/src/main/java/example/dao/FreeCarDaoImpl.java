package example.dao;

import example.entity.FreeCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FreeCarDaoImpl implements FreeCarDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
            //= new JdbcTemplate();

    @Override
    public Integer insert() {
        String sql = "insert into freecar(parkId)values(ceiling(rand()*8))";
        Integer rows = this.jdbcTemplate.update(sql,new Object[]{});

        return rows;
    }
    @Override
    public Integer updatePark() {

        String sql = "update park set freecar = freecar-1 where park.parkId = (select parkId from freecar where id = @@identity)";
        Integer rows = this.jdbcTemplate.update(sql,new Object[]{});

        return rows;
    }

    @Override
    public Integer updateFreecar() {
        String sql = "update freecar set freecar = (select freecar from park where park.parkId=freecar.parkId)";
        Integer rows = this.jdbcTemplate.update(sql,new Object[]{});
        return rows;
    }

    @Override
    public Integer delete(int id) {
        String sql = "delete from freecar where id = ?";
        int rows = this.jdbcTemplate.update(sql, new Object[]{id});
        return rows;
    }

    @Override
    public List <FreeCar> list() {
        String sql="select * from freecar";
        List<FreeCar> freeCarList = this.jdbcTemplate.query(sql,new BeanPropertyRowMapper<FreeCar>(FreeCar.class));

        return freeCarList;
    }


}
//concat(char(round((rand())*7)+97))
//select cast(ceiling(rand()*8)as int)
//        String sql = "insert into freecar(parkId,freecar)values(cast(ceiling(rand()*8)as int)
// ,'freecar'-1 where freecar.freecar=park.freecar AND parkId IN (select parkId from freecar where id = @@identity))";
// Integer parkId = freeCar.getParkId();
//Integer freecar = freeCar.getFreeCar();
/**
 *  Park park = new Park();
 Integer max=8;
 Integer min=1;
 Random random = new Random();
 Integer parkId = random.nextInt(max)%(max-min+1)+min;

 Park park = new Park();
 Integer parkId = park.getParkId();
 ceiling(rand()*8)
 **/