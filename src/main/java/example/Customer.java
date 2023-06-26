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
            Rental rental = (Rental) rentals.nextElement();

            //определить сумму для каждой строки
            double rentalCost = rental.getCost();

            // добавить очки для активного арендатора
            frequentRenterPoints += rental.getFrequentRenterPoints();

            //показать результаты для этой аренды
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rentalCost) + "\n";
            totalAmount += rentalCost;
        }
        //добавить нижний колонтитул
        result += "Сумма задолженности составляет " +
                String.valueOf(totalAmount) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoints) +
                " очков за активность";
        return result;
    }
}
