public  class Dino{
    private int id;
    private String spezies;

    public Dino(int id, String spezies){
        this.id = id;
        this.spezies= spezies;
    }

    public int getID(){
       return id;
    }

    public String getSpezies(){
        return spezies;
    }

    public String toString(){

        String dino= Character.toString(spezies.charAt(0)) + getID();
       

        return dino.toString();

    }

    

    

}