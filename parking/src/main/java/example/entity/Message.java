package example.entity;

import com.google.gson.Gson;

public class Message {
    Integer parkId;
    Integer freecar;
    public String information;
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
    public String getInformation(){
        return information;
    }
    public void setInformation(String information){
        this.information = information;
    }
    public String toJson(){
        return gson.toJson(this);
    }
    private static Gson gson = new Gson();

}
