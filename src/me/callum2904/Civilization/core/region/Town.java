package me.callum2904.Civilization.core.region;

import java.util.ArrayList;
import java.util.List;

import me.callum2904.Civilization.core.Structure;

public class Town {

	private static List<Town> towns = new ArrayList<Town>();
	private List<Structure> buildings;

	public Town() {
		buildings = new ArrayList<Structure>();
		towns.add(this);
	}

	public void addBuilding(Structure building) {
		this.buildings.add(building);
	}

	public void removeBuilding(Structure building) {
		this.buildings.remove(building);
	}

	public List<Structure> getBuildings() {
		return this.buildings;
	}

	public void remove() {
		towns.remove(this);
	}

	public static List<Town> getAllTowns() {
		return towns;
	}

}
