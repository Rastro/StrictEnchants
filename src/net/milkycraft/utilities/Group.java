package net.milkycraft.utilities;

import java.util.Map;

import com.google.common.collect.Maps;

// TODO: Auto-generated Javadoc
/**
 * The Enum Group.
 */
public enum Group {
	
	DEFAULT(0),
	LOW(1),
	MEDIUM(2),
	HIGH(3),
	MAX(4);
	
	private final int value;
	private final static Map<Integer, Group> BY_ID = Maps.newHashMap();

	/**
	 * Instantiates a new group.
	 * 
	 * @param value
	 *            the value
	 */
	private Group(final int value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Gets the value.
	 * 
	 * @param value
	 *            the value
	 * @return the by value
	 */
	public static Group getByValue(final int value) {
		return BY_ID.get(value);
	}

	static {
		for (Group mode : values()) {
			BY_ID.put(mode.getValue(), mode);
		}
	}
}
