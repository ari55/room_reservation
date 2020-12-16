package com.example.relaxinn.entity;

import java.sql.Date;

public class Booking {

	private int id;
	private int idClient;
	private int idHotel;
	private int idRoom;
	private int idPurpose;
	private Date fromDate;
	private Date toDate;
	private int breakfastNumber;
	private int lunchNumber;
	private int dinnerNumber;

	public Booking(int id, int idClient, int idHotel, int idRoom, int idPurpose, Date fromDate, Date toDate, int breakfastNumber, int lunchNumber, int dinnerNumber) {
		this.id = id;
		this.idClient = idClient;
		this.idHotel = idHotel;
		this.idRoom = idRoom;
		this.idPurpose = idPurpose;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.breakfastNumber = breakfastNumber;
		this.lunchNumber = lunchNumber;
		this.dinnerNumber = dinnerNumber;
	}

	public Booking(int idClient, int idHotel, int idRoom, int idPurpose, Date fromDate, Date toDate, int breakfastNumber, int lunchNumber, int dinnerNumber) {
		this.id = -1;
		this.idClient = idClient;
		this.idHotel = idHotel;
		this.idRoom = idRoom;
		this.idPurpose = idPurpose;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.breakfastNumber = breakfastNumber;
		this.lunchNumber = lunchNumber;
		this.dinnerNumber = dinnerNumber;
	}

	public int getId() {
		return id;
	}

	public int getIdClient() {
		return idClient;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public int getIdPurpose() {
		return idPurpose;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public int getBreakfastNumber() {
		return breakfastNumber;
	}

	public int getLunchNumber() {
		return lunchNumber;
	}

	public int getDinnerNumber() {
		return dinnerNumber;
	}

	// STATIC METHODS :

	static public final String serialize(Booking b) {
		return String.join(Resources.SEPARATOR_PARAMETER, "" + b.getId(), "" + b.getIdClient(), "" + b.getIdHotel(), "" + b.getIdRoom(), "" + b.getIdPurpose(), b.getFromDate().toString(), b.getToDate().toString(), "" + b.getBreakfastNumber(), "" + b.getLunchNumber(), "" + b.getDinnerNumber());
	}

	static public final String serialize(Booking[] ba) {
		String[] sa = new String[ba.length];
		for (int i = 0; i < ba.length; i++)
			sa[i] = serialize(ba[i]);
		return String.join(Resources.SEPARATOR_ARRAY, sa);
	}

	static public final Booking deserializeItem(String s) {
		String[] sa = s.split(Resources.SEPARATOR_PARAMETER);
		int i = 0;
		return new Booking(Integer.parseInt(sa[i++]), Integer.parseInt(sa[i++]), Integer.parseInt(sa[i++]), Integer.parseInt(sa[i++]), Integer.parseInt(sa[i++]), Date.valueOf(sa[i++]), Date.valueOf(sa[i++]), Integer.parseInt(sa[i++]), Integer.parseInt(sa[i++]), Integer.parseInt(sa[i++]));
	}

	static public final Booking[] deserializeArray(String s) {
		String[] sa = s.split(Resources.SEPARATOR_ARRAY);
		Booking[] ba = new Booking[sa.length];
		for (int i = 0; i < sa.length; i++)
			ba[i] = deserializeItem(sa[i]);
		return ba;
	}

}
