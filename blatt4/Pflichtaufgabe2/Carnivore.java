import java.util.Random;
public class Carnivore extends Dino implements MapObjekt {

    MapObjektType type = MapObjektType.CARNIVORE;

    public MapObjektType getType() {
        return this.type;
    }
    
    public Carnivore(int id, String spezie) {
        super(id, spezie);
        //TODO Auto-generated constructor stub
    }

    public String print() {
        return "\033[0;31m[C:" + toString() + "]" + "\033[0m";
    }

    public boolean attemptEat() {
        Random random = new Random();
        int erfolgChance = random.nextInt(3);
        if ( erfolgChance == 2 ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEdible() {
        return false;
    }

    public boolean canMove() {
        return true;
    }
}


