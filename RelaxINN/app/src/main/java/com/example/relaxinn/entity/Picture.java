package com.example.relaxinn.entity;


public class Picture {

    private int id;
    private int idRoom;
    private String url;

    public Picture(int id, int idRoom, String url) {
        this.id = id;
        this.idRoom = idRoom;
        this.url = url;
    }

    public Picture(int idRoom, String url) {
        this.id = -1;
        this.idRoom = idRoom;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public String getUrl() {
        return url;
    }

    // STATIC METHODS :

    static public final String serialize(Picture p) {
        return String.join(Resources.SEPARATOR_PARAMETER, "" + p.getId(), "" + p.getIdRoom(), p.getUrl());
    }

    static public final String serialize(Picture[] pa) {
        String[] sa = new String[pa.length];
        for (int i = 0; i < pa.length; i++)
            sa[i] = serialize(pa[i]);
        return String.join(Resources.SEPARATOR_ARRAY, sa);
    }

    static public final Picture deserializeItem(String s) {
        String[] sa = s.split(Resources.SEPARATOR_PARAMETER);
        int i = 0;
        return new Picture(Integer.parseInt(sa[i++]), Integer.parseInt(sa[i++]), sa[i++]);
    }

    static public final Picture[] deserializeArray(String s) {
        String[] sa = s.split(Resources.SEPARATOR_ARRAY);
        Picture[] pa = new Picture[sa.length];
        for (int i = 0; i < sa.length; i++)
            pa[i] = deserializeItem(sa[i]);
        return pa;
    }

}
