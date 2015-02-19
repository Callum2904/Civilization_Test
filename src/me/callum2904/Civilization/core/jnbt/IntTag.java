package me.callum2904.Civilization.core.jnbt;

public final class IntTag extends Tag {
	private final int value;

	public IntTag(String name, int value) {
		super(name);
		this.value = value;
	}

	public Integer getValue() {
		return Integer.valueOf(this.value);
	}
}