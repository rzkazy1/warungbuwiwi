package com.adpl.warungbuwiwi.model;

public interface IOperasiStok {
    int hitungStokBaru(int stokSaatIni, int jumlah) throws IllegalArgumentException;
}