package com.adpl.warungbuwiwi.model;

public class ReturBarang implements IOperasiStok {
    @Override
    public int hitungStokBaru(int stokSaatIni, int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Kuantitas tidak valid");
        }
        if (jumlah > stokSaatIni) {
            throw new IllegalArgumentException("Jumlah retur melebihi ketersediaan stok sistem saat ini");
        }
        return stokSaatIni - jumlah;
    }
}