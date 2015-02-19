package me.callum2904.Civilization.core.jnbt;

public final class ByteTag extends Tag {
	private final byte value;

	public ByteTag(String name, byte value) {
		super(name);
		this.value = value;
	}

	public Byte getValue() {
		return Byte.valueOf(this.value);
	}
}