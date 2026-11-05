package com.adpl.warungbuwiwi.model;

public class StokMasuk implements IOperasiStok {
    @Override
    public int hitungStokBaru(int stokSaatIni, int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Kuantitas tidak valid");
        }
        return stokSaatIni + jumlah;
    }
}