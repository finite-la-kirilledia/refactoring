package example.price;

public class RegularPrice extends Price {

    @Override
    public double getPrice(int daysRented) {
        int price = 2;
        if (daysRented > 2) {
            price += (daysRented - 2) * 15;
        }
        return price;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
