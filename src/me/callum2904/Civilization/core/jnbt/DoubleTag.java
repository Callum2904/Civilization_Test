package me.callum2904.Civilization.core.jnbt;

public final class DoubleTag extends Tag {
	private final double value;

	public DoubleTag(String name, double value) {
		super(name);
		this.value = value;
	}

	public Double getValue() {
		return Double.valueOf(this.value);
	}
}