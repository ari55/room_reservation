package com.example.relaxinn.entity;


public class Hotel {

	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String addrL1;
	private String addrL2;
	private String zip;
	private String city;
	private String state;
	private String country;
	private int parkNumber;
	private boolean breakfast;
	private boolean lunch;
	private boolean dinner;

	public Hotel(int id, String name, String phoneNumber, String email, String addrL1, String addrL2, String zip, String city, String state, String country, int parkNumber, boolean breakfast, boolean lunch, boolean dinner) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.addrL1 = addrL1;
		this.addrL2 = addrL2;
		this.zip = zip;
		this.city = city;
		this.state = state;
		this.country = country;
		this.parkNumber = parkNumber;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
	}

	public Hotel(String name, String phoneNumber, String email, String addrL1, String addrL2, String zip, String city, String state, String country, int parkNumber, boolean breakfast, boolean lunch, boolean dinner) {
		this.id = -1;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.addrL1 = addrL1;
		this.addrL2 = addrL2;
		this.zip = zip;
		this.city = city;
		this.state = state;
		this.country = country;
		this.parkNumber = parkNumber;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getAddrL1() {
		return addrL1;
	}

	public String getAddrL2() {
		return addrL2;
	}

	public String getZip() {
		return zip;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public int getParkNumber() {
		return parkNumber;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public boolean isLunch() {
		return lunch;
	}

	public boolean isDinner() {
		return dinner;
	}

	// STATIC METHODS :

	static public final String serialize(Hotel h) {
		return String.join(Resources.SEPARATOR_PARAMETER, "" + h.getId(), h.getName(), h.getPhoneNumber(), h.getEmail(), h.getAddrL1(), h.getAddrL2(), h.getZip(), h.getCity(), h.getState(), h.getCountry(), "" + h.getParkNumber(), "" + h.isBreakfast(), "" + h.isLunch(), "" + h.isDinner());
	}

	static public final String serialize(Hotel[] ha) {
		String[] sa = new String[ha.length];
		for (int i = 0; i < ha.length; i++)
			sa[i] = serialize(ha[i]);
		return String.join(Resources.SEPARATOR_ARRAY, sa);
	}

	static public final Hotel deserializeItem(String s) {
		String[] sa = s.split(Resources.SEPARATOR_PARAMETER);
		int i = 0;
		return new Hotel(Integer.parseInt(sa[i++]), sa[i++], sa[i++], sa[i++], sa[i++], sa[i++], sa[i++], sa[i++], sa[i++], sa[i++], Integer.parseInt(sa[i++]), Boolean.parseBoolean(sa[i++]), Boolean.parseBoolean(sa[i++]), Boolean.parseBoolean(sa[i++]));
	}

	static public final Hotel[] deserializeArray(String s) {
		String[] sa = s.split(Resources.SEPARATOR_ARRAY);
		Hotel[] ha = new Hotel[sa.length];
		for (int i = 0; i < sa.length; i++)
			ha[i] = deserializeItem(sa[i]);
		return ha;
	}

}
