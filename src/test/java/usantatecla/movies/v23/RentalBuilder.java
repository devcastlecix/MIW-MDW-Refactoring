package usantatecla.movies.v23;

import usantatecla.movies.v23.Movie;
import usantatecla.movies.v23.Rental;

public class RentalBuilder {

	private Movie movie;
	private int daysRented;
	
	public RentalBuilder movie(Movie movie) {
		this.movie = movie;
		return this;
	}
	
	public RentalBuilder daysRented(int daysRented) {
		this.daysRented = daysRented;
		return this;
	}
	
	public Rental build() {
		return new Rental(movie, daysRented);
	}
	
	
}
