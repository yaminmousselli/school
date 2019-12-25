package model;

/**
 * Represents an angler unit that can build a FishingShack
 *
 * @author Jim Harris
 * @version 1.0
 */
class AnglerUnit extends Unit implements Convertable {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    public AnglerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return getOwner().getFishingShack();
    }

    @Override
    public boolean canConvert(TileType type) {
        return type == TileType.WATER;
    }

    @Override
    public char symbol() {
        return 'a';
    }

    @Override
    public String toString() {
        return "Anglers. " + super.toString();
    }
}
