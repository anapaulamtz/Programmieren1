class Fence implements MapObjekt {

    MapObjektType type = MapObjektType.FENCE;

    public MapObjektType getType() {
        return this.type;
    }
    
    public String print() {   
        return "\033[0;32m[XXXXX]" + "\033[0m";
    }

    public boolean isEdible() {
        return false;
    }

    public boolean canMove() {
        return false;
    }

}

