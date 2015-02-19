package me.callum2904.Civilization.core.jnbt;

public final class ByteArrayTag extends Tag {
	private final byte[] value;

	public ByteArrayTag(String name, byte[] value) {
		super(name);
		this.value = value;
	}

	public byte[] getValue() {
		return this.value;
	}
}