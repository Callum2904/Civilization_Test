package me.callum2904.Civilization.core.region;

import java.util.ArrayList;
import java.util.List;

public class Country {

	private static List<Country> countries = new ArrayList<Country>();
	private List<City> cities;

	public Country() {
		this.cities = new ArrayList<City>();
		countries.add(this);
	}

	public void addCity(City city) {
		this.cities.add(city);
	}

	public void removeCity(City city) {
		this.cities.remove(city);
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void remove() {
		countries.remove(this);
	}

	public static List<Country> getAllCountries() {
		return countries;
	}

}
