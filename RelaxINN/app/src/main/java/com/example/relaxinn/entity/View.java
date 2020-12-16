package com.example.relaxinn.entity;


public class View {

	private int id;
	private String name;

	public View(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public View(String name) {
		this.id = -1;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// STATIC METHODS :

	static public final String serialize(View v) {
		return String.join(Resources.SEPARATOR_PARAMETER, "" + v.getId(), v.getName());
	}

	static public final String serialize(View[] va) {
		String[] sa = new String[va.length];
		for (int i = 0; i < va.length; i++)
			sa[i] = serialize(va[i]);
		return String.join(Resources.SEPARATOR_ARRAY, sa);
	}

	static public final View deserializeItem(String s) {
		String[] sa = s.split(Resources.SEPARATOR_PARAMETER);
		int i = 0;
		return new View(Integer.parseInt(sa[i++]), sa[i++]);
	}

	static public final View[] deserializeArray(String s) {
		String[] sa = s.split(Resources.SEPARATOR_ARRAY);
		View[] va = new View[sa.length];
		for (int i = 0; i < sa.length; i++)
			va[i] = deserializeItem(sa[i]);
		return va;
	}

}
