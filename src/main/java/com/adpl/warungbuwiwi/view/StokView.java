package com.adpl.warungbuwiwi.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class StokView extends JFrame {
    private final JTextField txtId = new JTextField();
    private final JTextField txtNama = new JTextField();
    private final JTextField txtStok = new JTextField();

    private final JButton btnTambah = new JButton("Tambah");
    private final JButton btnUbah = new JButton("Ubah");
    private final JButton btnHapus = new JButton("Hapus");
    private final JButton btnClear = new JButton("Clear");

    private final DefaultTableModel tableModel;
    private final JTable table;

    public StokView() {
        setTitle("CRUD Kelola Stok - Warung Bu Wiwi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel Form Input
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        panelForm.add(new JLabel("ID Barang:"));
        panelForm.add(txtId);
        panelForm.add(new JLabel("Nama Barang:"));
        panelForm.add(txtNama);
        panelForm.add(new JLabel("Jumlah Stok:"));
        panelForm.add(txtStok);

        // Panel Tombol CRUD
        JPanel panelTombol = new JPanel(new FlowLayout());
        panelTombol.add(btnTambah);
        panelTombol.add(btnUbah);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        JPanel panelUtara = new JPanel(new BorderLayout());
        panelUtara.add(panelForm, BorderLayout.CENTER);
        panelUtara.add(panelTombol, BorderLayout.SOUTH);

        // Tabel Data Barang
        tableModel = new DefaultTableModel(new String[]{"ID Barang", "Nama Barang", "Stok"}, 0);
        table = new JTable(tableModel);

        add(panelUtara, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public String getIdInput() { return txtId.getText().trim(); }
    public String getNamaInput() { return txtNama.getText().trim(); }
    public String getStokInput() { return txtStok.getText().trim(); }
    public JTable getTable() { return table; }
    public DefaultTableModel getTableModel() { return tableModel; }

    public void setForm(String id, String nama, String stok) {
        txtId.setText(id);
        txtNama.setText(nama);
        txtStok.setText(stok);
    }

    public void clearForm() {
        txtId.setText("");
        txtNama.setText("");
        txtStok.setText("");
    }

    public void addTambahListener(ActionListener l) { btnTambah.addActionListener(l); }
    public void addUbahListener(ActionListener l) { btnUbah.addActionListener(l); }
    public void addHapusListener(ActionListener l) { btnHapus.addActionListener(l); }
    public void addClearListener(ActionListener l) { btnClear.addActionListener(l); }
}