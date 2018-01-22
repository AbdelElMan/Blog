package com.blog.enums;

public enum Roles {
       
	ROLE_ADMIN(0, "ROLE_ADMIN"), 
	ROLE_USER (1, "ROLE_USER");

	private final int value;
	private final String name;

	Roles(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public static Roles getEnum(int value) {
		for (Roles v : values())
			if (v.getValue() == value)
				return v;
		throw new IllegalArgumentException();
	}

}
