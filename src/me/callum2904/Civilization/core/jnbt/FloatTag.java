package me.callum2904.Civilization.core.jnbt;

public final class FloatTag extends Tag {
	private final float value;

	public FloatTag(String name, float value) {
		super(name);
		this.value = value;
	}

	public Float getValue() {
		return Float.valueOf(this.value);
	}
}