package example.entity;




public class Park {
    private int parkId;
    private String name;
    private String type;
    private String address;
    private int x;
    private int y;
    private int n;
    private int freecar;

    public int getParkId(){
        return parkId;
    }
    public void setParkId(int parkId){
        this.parkId = parkId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public  String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getN(){
        return n;
    }
    public void setN(int n){
        this.n = n;
    }
    public int getFreecar(){
        return freecar;
    }
    public void setFreecar(int freecar){
        this.freecar = freecar;
    }
}
