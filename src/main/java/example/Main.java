package example;

import org.testng.Assert;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Martin");

        Movie одинДома = new Movie("Один дома", Movie.CHILDRENS);
        Movie корольЛев = new Movie("Король Лев", Movie.CHILDRENS);
        Movie оппенгеймер = new Movie("Оппенгеймер", Movie.NEW_RELEASE);
        Movie гонка = new Movie("Гонка", Movie.REGULAR);

        customer.addRental(new Rental(одинДома, 1));
        customer.addRental(new Rental(корольЛев, 2));
        customer.addRental(new Rental(оппенгеймер, 3));
        customer.addRental(new Rental(гонка, 4));

        String statement = customer.statement();
        System.out.println(statement);

        String expected = "Учет аренды для Martin\n" +
                "\tОдин дома	15.0\n" +
                "\tКороль Лев	15.0\n" +
                "\tОппенгеймер	9.0\n" +
                "\tГонка	32.0\n" +
                "Сумма задолженности составляет 71.0\n" +
                "Вы заработали 5 очков за активность";

        Assert.assertEquals(expected, customer.statement());
    }
}
