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
        Enumeration rentals = _rentals.elements();
        String result = "Учет аренды для " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();

            //показать результаты для этой аренды
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCost() + "\n";
        }

        //добавить нижний колонтитул
        result += "Сумма задолженности составляет " + getTotalCost() + "\n";
        result += "Вы заработали " + getTotalFrequentRenterPoints() + " очков за активность";
        return result;
    }

    private double getTotalCost() {
        double totalCost = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            totalCost += rental.getCost();
        }
        return totalCost;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }
}
