package example;

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

        System.out.println(customer.statement());
    }
}
