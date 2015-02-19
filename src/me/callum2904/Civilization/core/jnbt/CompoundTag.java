package me.callum2904.Civilization.core.jnbt;

import java.util.Collections;
import java.util.Map;

public final class CompoundTag extends Tag {
	private final Map<String, Tag> value;

	public CompoundTag(String name, Map<String, Tag> value) {
		super(name);
		this.value = Collections.unmodifiableMap(value);
	}

	public Map<String, Tag> getValue() {
		return this.value;
	}
}