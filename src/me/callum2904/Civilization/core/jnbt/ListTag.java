package me.callum2904.Civilization.core.jnbt;

import java.util.Collections;
import java.util.List;

public final class ListTag extends Tag {
	private final Class<? extends Tag> type;
	private final List<Tag> value;

	public ListTag(String name, Class<? extends Tag> type, List<Tag> value) {
		super(name);
		this.type = type;
		this.value = Collections.unmodifiableList(value);
	}

	public Class<? extends Tag> getType() {
		return this.type;
	}

	public List<Tag> getValue() {
		return this.value;
	}
}