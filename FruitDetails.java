class FruitDetails {
    private String fruitName;
    private Integer fruitQuantity;
    private Double pricePerKilo;

    public FruitDetails(final String fruitName, final Integer fruitQuantity, final Double pricePerKilo) {
        this.fruitName = fruitName;
        this.fruitQuantity = fruitQuantity;
        this.pricePerKilo = pricePerKilo;
    }

    @Override
    public String toString() {
        return "FruitDetails [fruitName = " + fruitName + ", fruitQuantity = " + fruitQuantity + ", pricePerKilo = "
                + pricePerKilo + "]";
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(final String fruitName) {
        this.fruitName = fruitName;
    }

    public Integer getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(final Integer fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    public Double getPricePerKilo() {
        return pricePerKilo;
    }

    public void setPricePerKilo(final Double pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }
}