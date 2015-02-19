package me.callum2904.Civilization.core.jnbt;

public final class ShortTag extends Tag {
	private final short value;

	public ShortTag(String name, short value) {
		super(name);
		this.value = value;
	}

	public Short getValue() {
		return Short.valueOf(this.value);
	}
}
