package me.callum2904.Civilization.core.region;

import java.util.ArrayList;
import java.util.List;

public class Empire {

	private static List<Empire> empires = new ArrayList<Empire>();
	private List<Country> countries;

	public Empire() {
		this.countries = new ArrayList<Country>();
		empires.add(this);
	}

	public void addCountry(Country country) {
		this.countries.add(country);
	}

	public void removeCountry(Country country) {
		this.countries.remove(country);
	}

	public List<Country> getCountries() {
		return this.countries;
	}

	public void remove() {
		empires.remove(this);
	}

	public static List<Empire> getAllEmpires() {
		return empires;
	}

}
