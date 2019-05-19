package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    return header() + body() + footer();
  }

  public String htmlStatement() {
    return htmlHeader() + htmlBody() + htmlFooter();
  }

  private String header() {
    return "Rental Record for " + getName() + "\n";
  }

  private String htmlHeader() {
    return "<h1>Rental Record for <b>" + getName() + "</b></h1>";
  }

  private String body() {
    String result = "";
    for (Rental rental : rentals) {
      result += "\t" + rental.getMovie().getTitle() + "\t" +
          String.valueOf(rental.amount()) + "\n";
    }
    return result;
  }

  private String htmlBody() {
    String result = "";
    for (Rental rental : rentals) {
      result += rental.getMovie().getTitle() + " " +
          String.valueOf(rental.amount()) + "<br/>";
    }
    return result;
  }

  private String footer() {
    String result = "";
    result += "Amount owed is " + String.valueOf(totalAmount()) + "\n";
    result += "You earned " + String.valueOf(totalFrequentRenterPoints())
        + " frequent renter points";
    return result;
  }

  private String htmlFooter() {
    String result = "";
    result += "Amount owed is <b>" + String.valueOf(totalAmount()) + "</b><br/>";
    result += "You earned <b>" + String.valueOf(totalFrequentRenterPoints())
        + "</b> frequent renter points";
    return result;
  }

  private double totalAmount() {
    double totalAmount = 0;
    for (Rental rental : rentals) {
      totalAmount += rental.amount();
    }
    return totalAmount;
  }

  private int totalFrequentRenterPoints() {
    int totalFrequentRenterPoints = 0;
    for (Rental rental : rentals) {
      totalFrequentRenterPoints += rental.frequentRenterPoints();
    }
    return totalFrequentRenterPoints;
  }
}

