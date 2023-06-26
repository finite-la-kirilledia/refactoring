package example;

public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getCost() {
        double cost = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                cost += 2;
                if (getDaysRented() > 2) {
                    cost += (getDaysRented() - 2) * 15;
                }
                break;
            case Movie.NEW_RELEASE:
                cost += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                cost += 15;
                if (getDaysRented() > 3) {
                    cost += (getDaysRented() - 3) * 15;
                }
                break;
        }
        return cost;
    }

    public int getFrequentRenterPoints() {
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }
}
