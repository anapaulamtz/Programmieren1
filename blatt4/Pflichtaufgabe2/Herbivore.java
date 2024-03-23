public class Herbivore extends Dino implements MapObjekt {

    MapObjektType type = MapObjektType.HERBIVORE;

    public MapObjektType getType() {
        return this.type;
    }

    public Herbivore(int id, String spezie) {
        super(id, spezie);
        //TODO Auto-generated constructor stub
    }

    public String print() {
        return "\033[0;33m[H:" + toString() + "]" + "\033[0m";
    }

    public boolean isEdible() {
        return true;
    }

    public boolean canMove() {
        return true;
    }

}


