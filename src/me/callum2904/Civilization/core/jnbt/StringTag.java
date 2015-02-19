package me.callum2904.Civilization.core.jnbt;

public final class StringTag extends Tag {
	private final String value;

	public StringTag(String name, String value) {
		super(name);
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}