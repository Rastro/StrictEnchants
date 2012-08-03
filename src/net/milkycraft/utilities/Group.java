package net.milkycraft.utilities;

import java.util.Map;

import com.google.common.collect.Maps;

public enum Group {
   DEFAULT(0),
   LOW(1),
   MEDIUM(2),
   HIGH(3),
   MAX(4);

    private final int value;
    private final static Map<Integer, Group> BY_ID = Maps.newHashMap();

    private Group(final int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static Group getByValue(final int value) {
        return BY_ID.get(value);
    }

    static {
        for (Group mode : values()) {
            BY_ID.put(mode.getValue(), mode);
        }
    }
}
