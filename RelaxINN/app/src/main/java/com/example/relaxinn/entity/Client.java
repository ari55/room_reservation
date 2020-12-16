package com.example.relaxinn.entity;


public class Client {

	private int id;
	private String firstName;
	private String lastName;
	private String email;

	public Client(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Client(String firstName, String lastName, String email) {
		this.id = -1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	// STATIC METHODS :

	static public final String serialize(Client c) {
		return String.join(Resources.SEPARATOR_PARAMETER, "" + c.getId(), c.getFirstName(), c.getLastName(), c.getEmail());
	}

	static public final String serialize(Client[] ca) {
		String[] sa = new String[ca.length];
		for (int i = 0; i < ca.length; i++)
			sa[i] = serialize(ca[i]);
		return String.join(Resources.SEPARATOR_ARRAY, sa);
	}

	static public final Client deserializeItem(String s) {
		String[] sa = s.split(Resources.SEPARATOR_PARAMETER);
		int i = 0;
		return new Client(Integer.parseInt(sa[i++]), sa[i++], sa[i++], sa[i++]);
	}

	static public final Client[] deserializeArray(String s) {
		String[] sa = s.split(Resources.SEPARATOR_ARRAY);
		Client[] ca = new Client[sa.length];
		for (int i = 0; i < sa.length; i++)
			ca[i] = deserializeItem(sa[i]);
		return ca;
	}

}
