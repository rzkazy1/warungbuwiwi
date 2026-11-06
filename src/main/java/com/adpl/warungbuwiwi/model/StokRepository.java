package com.adpl.warungbuwiwi.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StokRepository implements IStokRepository {

    // CREATE (Tambah Barang & Stok)
    @Override
    public void insert(Barang barang) {
        String sql = "INSERT INTO barang (id_barang, nama_barang, stok_barang) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, barang.getIdBarang());
            ps.setString(2, barang.getNamaBarang());
            ps.setInt(3, barang.getStokBarang());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal tambah data: " + e.getMessage());
        }
    }

    // READ (Ambil Semua Data Barang)
    @Override
    public List<Barang> getAll() {
        List<Barang> list = new ArrayList<>();
        String sql = "SELECT * FROM barang";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Barang(
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getInt("stok_barang")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Gagal baca data: " + e.getMessage());
        }
        return list;
    }

    // UPDATE (Ubah Nama & Stok Barang)
    @Override
    public void update(Barang barang) {
        String sql = "UPDATE barang SET nama_barang = ?, stok_barang = ? WHERE id_barang = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, barang.getNamaBarang());
            ps.setInt(2, barang.getStokBarang());
            ps.setString(3, barang.getIdBarang());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal ubah data: " + e.getMessage());
        }
    }

    // DELETE (Hapus Barang)
    @Override
    public void delete(String idBarang) {
        String sql = "DELETE FROM barang WHERE id_barang = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idBarang);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal hapus data: " + e.getMessage());
        }
    }
}