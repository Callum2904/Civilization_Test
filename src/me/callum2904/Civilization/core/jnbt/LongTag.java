package me.callum2904.Civilization.core.jnbt;

public final class LongTag extends Tag {
	private final long value;

	public LongTag(String name, long value) {
		super(name);
		this.value = value;
	}

	public Long getValue() {
		return Long.valueOf(this.value);
	}
}
