package usantatecla.movies.v22;

import usantatecla.movies.v22.ChildrenPrice;
import usantatecla.movies.v22.Movie;
import usantatecla.movies.v22.NewReleasePrice;
import usantatecla.movies.v22.Price;
import usantatecla.movies.v22.RegularPrice;

public class MovieBuilder {

	private String title;
	
	private Price price;
	
	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public MovieBuilder childrens() {
		this.price = new ChildrenPrice();
		return this;
	}
	
	public MovieBuilder regular() {
		this.price = new RegularPrice();
		return this;
	}
	
	public MovieBuilder newRelease() {
		this.price = new NewReleasePrice();
		return this;
	}
	
	public Movie build() {
		return new Movie(title, price);
	}
}
