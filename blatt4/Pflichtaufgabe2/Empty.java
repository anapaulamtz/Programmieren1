class Empty implements MapObjekt {

    MapObjektType type = MapObjektType.EMPTY;

    public MapObjektType getType() {
        return this.type;
    }

    public String print() {
        return "[     ]";
    }

    public boolean isEdible() {
        return false;
    }

    public boolean canMove() {
        return false;
    }

}

