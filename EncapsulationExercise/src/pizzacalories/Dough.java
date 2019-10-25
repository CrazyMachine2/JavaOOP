package pizzacalories;

public class Dough {
    private static int DEFAULT_MODIFIER = 2;

    private String flourType;
    private FlourType flourtype;
    private String bakingTechnique;
    private BakingTechnique bakingtechnique;
    private double weight;

    public Dough(String flourtype, String bakingtechnique, double weight) {
        this.setFlourtype(flourtype);
        this.setBakingtechnique(bakingtechnique);
        this.setWeight(weight);
    }

    private void setFlourtype(String flourtype) {
        if (!isValidFlourType(flourtype)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourtype = FlourType.valueOf(flourtype);
    }

    private void setBakingtechnique(String bakingtechnique) {
        if (!isValidBakingTechnique(bakingtechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingtechnique = BakingTechnique.valueOf(bakingtechnique);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1...200].");
        }
        this.weight = weight;
    }

    public FlourType getFlourtype() {
        return this.flourtype;
    }

    public BakingTechnique getBakingtechnique() {
        return this.bakingtechnique;
    }

    public double getWeight() {
        return this.weight;
    }

    private boolean isValidFlourType(String flourType) {
        for (FlourType type : FlourType.values()) {
            if (type.name().equals(flourType)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidBakingTechnique(String bakingTechnique) {
        for (BakingTechnique technique : BakingTechnique.values()) {
            if (technique.name().equals(bakingTechnique)) {
                return true;
            }
        }
        return false;
    }

    public double calculateCalories() {
        return (Dough.DEFAULT_MODIFIER * this.getWeight())
                * this.getFlourtype().getValue()
                * this.getBakingtechnique().getValue();
    }
}
