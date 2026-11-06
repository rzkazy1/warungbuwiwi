package com.adpl.warungbuwiwi.model;

import java.util.List;

public interface IStokRepository {
    void insert(Barang barang);
    List<Barang> getAll();
    void update(Barang barang);
    void delete(String idBarang);
}