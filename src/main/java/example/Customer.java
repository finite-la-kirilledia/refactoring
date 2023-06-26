package example;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Учет аренды для " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //определить сумму для каждой строки
            double thisAmount = calculateRentalCost(each);

            // добавить очки для активного арендатора
            frequentRenterPoints++;
            // бонус за аренду новинки на два дня
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            //показать результаты для этой аренды

            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //добавить нижний колонтитул
        result += "Сумма задолженности составляет " +
                String.valueOf(totalAmount) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoints) +
                " очков за активность";
        return result;
    }

    private double calculateRentalCost(Rental rental) {
        double cost = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                cost += 2;
                if (rental.getDaysRented() > 2) {
                    cost += (rental.getDaysRented() - 2) * 15;
                }
                break;
            case Movie.NEW_RELEASE:
                cost += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                cost += 15;
                if (rental.getDaysRented() > 3) {
                    cost += (rental.getDaysRented() - 3) * 15;
                }
                break;
        }
        return cost;
    }
}
