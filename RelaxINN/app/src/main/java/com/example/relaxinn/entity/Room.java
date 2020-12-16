package com.example.relaxinn.entity;


public class Room {

	private int id;
	private String description;
	private int idHotel;
	private int idView;
	private int singleBedNumber;
	private int doubleBedNumber;
	private float price;
	private boolean smoker;

	public Room(int id, String description, int idHotel, int idView, int singleBedNumber, int doubleBedNumber, float price, boolean smoker) {
		this.id = id;
		this.description = description;
		this.idHotel = idHotel;
		this.idView = idView;
		this.singleBedNumber = singleBedNumber;
		this.doubleBedNumber = doubleBedNumber;
		this.price = price;
		this.smoker = smoker;
	}

	public Room(String description, int idHotel, int idView, int singleBedNumber, int doubleBedNumber, float price, boolean smoker) {
		this.id = -1;
		this.description = description;
		this.idHotel = idHotel;
		this.idView = idView;
		this.singleBedNumber = singleBedNumber;
		this.doubleBedNumber = doubleBedNumber;
		this.price = price;
		this.smoker = smoker;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public int getIdView() {
		return idView;
	}

	public int getSingleBedNumber() {
		return singleBedNumber;
	}

	public int getDoubleBedNumber() {
		return doubleBedNumber;
	}

	public float getPrice() {
		return price;
	}

	public boolean isSmoker() {
		return smoker;
	}

	// STATIC METHODS :

	static public final String serialize(Room r) {
		return String.join(Resources.SEPARATOR_PARAMETER, "" + r.getId(), r.getDescription(), "" + r.getIdHotel(), "" + r.getIdView(), "" + r.getSingleBedNumber(), "" + r.getDoubleBedNumber(), "" + r.getPrice(), "" + r.isSmoker());
	}

	static public final String serialize(Room[] ra) {
		String[] sa = new String[ra.length];
		for (int i = 0; i < ra.length; i++)
			sa[i] = serialize(ra[i]);
		return String.join(Resources.SEPARATOR_ARRAY, sa);
	}

	static public final Room deserializeItem(String s) {
		String[] sa = s.split(Resources.SEPARATOR_PARAMETER);
		int i = 0;
		return new Room(Integer.parseInt(sa[i++]), sa[i++], Integer.parseInt(sa[i++]), Integer.parseInt(sa[i++]), Integer.parseInt(sa[i++]), Integer.parseInt(sa[i++]), Float.parseFloat(sa[i++]), Boolean.parseBoolean(sa[i++]));
	}

	static public final Room[] deserializeArray(String s) {
		String[] sa = s.split(Resources.SEPARATOR_ARRAY);
		Room[] ra = new Room[sa.length];
		for (int i = 0; i < sa.length; i++)
			ra[i] = deserializeItem(sa[i]);
		return ra;
	}

}
