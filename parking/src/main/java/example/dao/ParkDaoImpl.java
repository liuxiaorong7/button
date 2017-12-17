package example.dao;

import example.entity.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ParkDaoImpl implements ParkDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List <Park> getList() {
        String sql="select * from park";
        List<Park> parkList = this.jdbcTemplate.query(sql,new BeanPropertyRowMapper<Park>(Park.class));

        return parkList;
    }
}
/**            String sql = "select * from park";

            List<Park> parkList = jdbcTemplate.query(sql, new RowMapper<Park>() {
                @Override
                public Park mapRow(ResultSet resultSet, int i) throws SQLException {
                    Park park = new Park();
                    park.setID(resultSet.getInt("ID"));
                    park.setName(resultSet.getString("name"));

                    park.setAddress(resultSet.getString("address"));
                    return park;
                }
            });

            return parkList;
    }


 String sql = "select * from park";
 return (List<Park>) jdbcTemplate.query(sql, new RowMapper<Park>(){

@Override
public Park mapRow(ResultSet rs, int rowNum) throws SQLException {
Park park = new Park();
park.setID(rs.getInt("ID"));
park.setName(rs.getString("name"));
park.setType(rs.getString("type"));
park.setAddress(rs.getString("address"));
park.setX(rs.getInt("x"));
park.setY(rs.getInt("y"));
park.setN(rs.getInt("n"));

return park;
}

});
 **/

