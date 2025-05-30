package usantatecla.movies.v24;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Customer {

	private String name;

	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		String result = "Rental Record for " + this.getName() + "\n";

		result = summarizeRentals(result, (currentText, rental) ->
				currentText + "\t" + rental.getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n");

		result += "Amount owed is " + String.valueOf(this.getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(this.getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	private double getTotalCharge() {
		return summarizeRentals(0.0, (total, rental) -> total + rental.getCharge());
	}

	private int getTotalFrequentRenterPoints() {
		return summarizeRentals(0, (total, rental) -> total + rental.getFrequentRenterPoints());
	}

	private <T> T summarizeRentals(T summary, BiFunction<T, Rental, T> process) {
		for (Rental rental : this.rentals) {
			summary = process.apply(summary, rental);
		}
		return summary;
	}
}
