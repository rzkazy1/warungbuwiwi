package com.adpl.warungbuwiwi.controller;

import com.adpl.warungbuwiwi.model.*;
import com.adpl.warungbuwiwi.view.StokView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StokController {
    private final IStokRepository repository;
    private final StokView view;

    public StokController(IStokRepository repository, StokView view) {
        this.repository = repository;
        this.view = view;

        loadTable();
        this.view.addProsesListener(e -> prosesStok());
    }

    private void prosesStok() {
        try {
            String id = view.getIdBarang();
            int jumlah = Integer.parseInt(view.getJumlah());

            Barang barang = repository.getBarangById(id);
            if (barang == null) {
                JOptionPane.showMessageDialog(view, "ID Barang tidak ditemukan!");
                return;
            }

            IOperasiStok operasi;
            if (view.getJenisOperasi().equals("Stok Masuk")) {
                operasi = new StokMasuk();
            } else {
                operasi = new ReturBarang();
            }

            int stokBaru = operasi.hitungStokBaru(barang.getStokBarang(), jumlah);
            repository.updateStok(id, stokBaru);

            view.resetForm();
            loadTable();
            JOptionPane.showMessageDialog(view, "Stok berhasil diperbarui!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Kuantitas tidak valid");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    private void loadTable() {
        DefaultTableModel model = view.getTableModel();
        model.setRowCount(0);
        for (Barang b : repository.getAllBarang()) {
            model.addRow(new Object[]{b.getIdBarang(), b.getNamaBarang(), b.getStokBarang()});
        }
    }
}