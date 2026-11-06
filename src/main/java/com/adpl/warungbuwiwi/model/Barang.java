package com.adpl.warungbuwiwi.model;

public class Barang {
    private String idBarang;
    private String namaBarang;
    private int stokBarang;

    public Barang(String idBarang, String namaBarang, int stokBarang) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.stokBarang = stokBarang;
    }

    public String getIdBarang() { return idBarang; }
    public String getNamaBarang() { return namaBarang; }
    public int getStokBarang() { return stokBarang; }
}