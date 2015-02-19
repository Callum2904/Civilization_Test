package me.callum2904.Civilization.core.region;

import java.util.ArrayList;
import java.util.List;

public class City {

	private static List<City> cities = new ArrayList<City>();
	private List<Town> towns;

	public City() {
		towns = new ArrayList<Town>();
		cities.add(this);
	}

	public void addTown(Town town) {
		this.towns.add(town);
	}

	public void removeTown(Town town) {
		this.towns.remove(town);
	}

	public List<Town> getTowns() {
		return this.towns;
	}

	public void remove() {
		cities.remove(this);
	}

	public static List<City> getAllCities() {
		return cities;
	}

}
