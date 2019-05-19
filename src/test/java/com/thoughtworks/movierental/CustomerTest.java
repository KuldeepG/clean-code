package com.thoughtworks.movierental;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    @Test
    public void shouldGenerateStatement(){
        Customer customer = new Customer("Kuldeep");

        customer.addRental(new Rental(new Movie("Avengers - End game", Movie.NEW_RELEASE), 5));
        customer.addRental(new Rental(new Movie("Infinity Wars", Movie.REGULAR), 5));
        customer.addRental(new Rental(new Movie("Lion King", Movie.CHILDRENS), 5));
        String actualStatement = customer.statement();

        String statement = "Rental Record for Kuldeep\n" +
            "\tAvengers - End game\t15.0\n" +
            "\tInfinity Wars\t6.5\n" +
            "\tLion King\t4.5\n" +
            "Amount owed is 26.0\n" +
            "You earned 4 frequent renter points";

        assertThat(actualStatement, is(statement));
    }

    @Test
    public void shouldGenerateHtmlStatement(){
        Customer customer = new Customer("Kuldeep");

        customer.addRental(new Rental(new Movie("Avengers - End game", Movie.NEW_RELEASE), 5));
        customer.addRental(new Rental(new Movie("Infinity Wars", Movie.REGULAR), 5));
        customer.addRental(new Rental(new Movie("Lion King", Movie.CHILDRENS), 5));
        String actualStatement = customer.htmlStatement();

        String statement = "<h1>Rental Record for <b>Kuldeep</b></h1>" +
            "Avengers - End game 15.0<br/>" +
            "Infinity Wars 6.5<br/>" +
            "Lion King 4.5<br/>" +
            "Amount owed is <b>26.0</b><br/>" +
            "You earned <b>4</b> frequent renter points";

        assertThat(actualStatement, is(statement));
    }
    
}