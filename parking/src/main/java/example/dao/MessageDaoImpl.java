package example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl implements MessageDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String sendInContent() {
        String sql1 = "select parkId from freecar where id = @@identity";
        Integer parkId = this.jdbcTemplate.queryForObject(sql1,Integer.class);
        String sql2 = "select freecar from freecar where id = @@identity";;
        //List freecar = this.jdbcTemplate.queryForList(sql2);
        Integer freecar = this.jdbcTemplate.queryForObject(sql2,Integer.class);
        String msg = parkId + "号停车场有车辆进入,剩余车位为：" + freecar;
        return msg;
    }

    @Override
    public String sendOutContent() {
        String sql1 = "select parkId from freecar where id = @@identity";
        Integer parkId = this.jdbcTemplate.queryForObject(sql1,Integer.class);
        String sql2 = "select freecar from freecar where id = @@identity";
        Integer freecar = this.jdbcTemplate.queryForObject(sql2,Integer.class);
        String msg = parkId + "号停车场有车辆出来,剩余车位为：" + freecar;
        return msg;
    }

    @Override
    public Integer getParkId() {
        String sql = "select parkId from freecar where id = @@identity";
        Integer parkId = this.jdbcTemplate.queryForObject(sql,Integer.class);
        return parkId;
    }
    @Override
    public Integer getFreecar() {
        String sql = "select freecar from freecar where id = @@identity";
        Integer freecar = this.jdbcTemplate.queryForObject(sql,Integer.class);

        return freecar;
    }
}
