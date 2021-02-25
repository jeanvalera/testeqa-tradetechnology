package br.com.tradetechnology.testeqa.dto;

public class Product {

    private String name;
    private String brand;
    private String dueDate;
    private double calories;
    private String flavor;
    private String category;
    private int stock;
    private int amount;
    private Measurement measurement;
    private ProductType type;
    private double purchasePrice;
    private int salePrice;
    private String pathToProductImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getPathToProductImage() {
        return pathToProductImage;
    }

    public void setPathToProductImage(String pathToProductImage) {
        this.pathToProductImage = pathToProductImage;
    }

    public Product(String name, String brand, String dueDate, double calories, String flavor, String category,
            int stock, int amount, Measurement measurement, ProductType type, double purchasePrice, int salePrice,
            String pathToProductImage) {
        this.name = name;
        this.brand = brand;
        this.dueDate = dueDate;
        this.calories = calories;
        this.flavor = flavor;
        this.category = category;
        this.stock = stock;
        this.amount = amount;
        this.measurement = measurement;
        this.type = type;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.pathToProductImage = pathToProductImage;
    }

}
