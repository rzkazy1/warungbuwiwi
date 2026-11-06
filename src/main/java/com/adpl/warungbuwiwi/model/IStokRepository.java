package com.adpl.warungbuwiwi.model;

import java.util.List;

public interface IStokRepository {
    List<Barang> getAllBarang();
    Barang getBarangById(String id);
    void updateStok(String id, int stokBaru);
}