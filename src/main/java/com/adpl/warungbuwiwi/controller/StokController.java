package com.adpl.warungbuwiwi.controller;

import com.adpl.warungbuwiwi.model.Barang;
import com.adpl.warungbuwiwi.model.IStokRepository;
import com.adpl.warungbuwiwi.view.StokView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StokController {
    private final IStokRepository repository;
    private final StokView view;

    public StokController(IStokRepository repository, StokView view) {
        this.repository = repository;
        this.view = view;

        loadTable();

        // Event Tombol CREATE
        view.addTambahListener(e -> {
            try {
                Barang b = new Barang(
                    view.getIdInput(),
                    view.getNamaInput(),
                    Integer.parseInt(view.getStokInput())
                );
                repository.insert(b);
                view.clearForm();
                loadTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Stok harus berupa angka!");
            }
        });

        // Event Tombol UPDATE
        view.addUbahListener(e -> {
            try {
                Barang b = new Barang(
                    view.getIdInput(),
                    view.getNamaInput(),
                    Integer.parseInt(view.getStokInput())
                );
                repository.update(b);
                view.clearForm();
                loadTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Stok harus berupa angka!");
            }
        });

        // Event Tombol DELETE
        view.addHapusListener(e -> {
            String id = view.getIdInput();
            if (!id.isEmpty()) {
                repository.delete(id);
                view.clearForm();
                loadTable();
            } else {
                JOptionPane.showMessageDialog(view, "Pilih baris di tabel yang ingin dihapus!");
            }
        });

        // Event Tombol CLEAR
        view.addClearListener(e -> view.clearForm());

        // Klik baris tabel otomatis mengisi form input
        view.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = view.getTable().getSelectedRow();
                if (row != -1) {
                    DefaultTableModel model = view.getTableModel();
                    view.setForm(
                        model.getValueAt(row, 0).toString(),
                        model.getValueAt(row, 1).toString(),
                        model.getValueAt(row, 2).toString()
                    );
                }
            }
        });
    }

    // Fungsi READ ke Tabel
    private void loadTable() {
        DefaultTableModel model = view.getTableModel();
        model.setRowCount(0);
        for (Barang b : repository.getAll()) {
            model.addRow(new Object[]{b.getIdBarang(), b.getNamaBarang(), b.getStokBarang()});
        }
    }
}