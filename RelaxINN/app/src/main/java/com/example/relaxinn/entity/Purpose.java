package com.example.relaxinn.entity;


public class Purpose {

	private int id;
	private String name;

	public Purpose(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Purpose(String name) {
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

	static public final String serialize(Purpose p) {
		return String.join(Resources.SEPARATOR_PARAMETER, "" + p.getId(), p.getName());
	}

	static public final String serialize(Purpose[] pa) {
		String[] sa = new String[pa.length];
		for (int i = 0; i < pa.length; i++)
			sa[i] = serialize(pa[i]);
		return String.join(Resources.SEPARATOR_ARRAY, sa);
	}

	static public final Purpose deserializeItem(String s) {
		String[] sa = s.split(Resources.SEPARATOR_PARAMETER);
		int i = 0;
		return new Purpose(Integer.parseInt(sa[i++]), sa[i++]);
	}

	static public final Purpose[] deserializeArray(String s) {
		String[] sa = s.split(Resources.SEPARATOR_ARRAY);
		Purpose[] pa = new Purpose[sa.length];
		for (int i = 0; i < sa.length; i++)
			pa[i] = deserializeItem(sa[i]);
		return pa;
	}

}
