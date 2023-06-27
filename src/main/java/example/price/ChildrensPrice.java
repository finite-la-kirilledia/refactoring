package example.price;

public class ChildrensPrice extends Price {

    @Override
    public double getPrice(int daysRented) {
        int price = 15;
        if (daysRented > 3) {
            price += (daysRented - 3) * 15;
        }
        return price;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
