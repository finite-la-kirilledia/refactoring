package example;

import example.price.ChildrensPrice;
import example.price.NewReleasePrice;
import example.price.Price;
import example.price.RegularPrice;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private Price price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPrice(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public double getCost(int daysRented) {
        return price.getPrice(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

    public void setPrice(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException(String.format("Price code %s does not exist", priceCode));
        }
    }
}
