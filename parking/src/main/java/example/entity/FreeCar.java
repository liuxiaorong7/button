package example.entity;

import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "freecar")
public class FreeCar {

    private int id;
    private int parkId;
    private int freecar;
    private Timestamp time;

    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public int getParkId(){
        return parkId;
    }
    public void setParkId(int parkId){
        this.parkId = parkId;
    }
    public int getFreeCar(){
        return freecar;
    }
    public void setFreeCar(int freecar){
        this.freecar = freecar;
    }
    public Timestamp getTime(){
        return time;
    }
    public void setTime(Timestamp time){
        this.time = time;
    }
}
