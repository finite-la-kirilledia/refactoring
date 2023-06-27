package example.price;

public abstract class Price {

    public abstract double getPrice(int daysRented);

    public abstract int getFrequentRenterPoints(int daysRented);
}
