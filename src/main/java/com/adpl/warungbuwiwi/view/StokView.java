package com.adpl.warungbuwiwi.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class StokView extends JFrame {
    private final JTextField txtIdBarang = new JTextField();
    private final JTextField txtJumlah = new JTextField();
    private final JComboBox<String> cmbJenis = new JComboBox<>(new String[]{"Stok Masuk", "Retur Barang"});
    private final JButton btnProses = new JButton("Proses Stok");
    private final DefaultTableModel tableModel;
    private final JTable table;

    public StokView() {
        setTitle("Kelola Stok Barang - Warung Bu Wiwi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelForm = new JPanel(new GridLayout(4, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("ID Barang (misal B01):"));
        panelForm.add(txtIdBarang);
        panelForm.add(new JLabel("Jenis Operasi:"));
        panelForm.add(cmbJenis);
        panelForm.add(new JLabel("Jumlah Barang:"));
        panelForm.add(txtJumlah);
        panelForm.add(new JLabel(""));
        panelForm.add(btnProses);

        tableModel = new DefaultTableModel(new String[]{"ID Barang", "Nama Barang", "Stok Saat Ini"}, 0);
        table = new JTable(tableModel);

        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public String getIdBarang() { return txtIdBarang.getText().trim(); }
    public String getJumlah() { return txtJumlah.getText().trim(); }
    public String getJenisOperasi() { return (String) cmbJenis.getSelectedItem(); }
    public DefaultTableModel getTableModel() { return tableModel; }

    public void resetForm() {
        txtIdBarang.setText("");
        txtJumlah.setText("");
    }

    public void addProsesListener(ActionListener listener) {
        btnProses.addActionListener(listener);
    }
} 