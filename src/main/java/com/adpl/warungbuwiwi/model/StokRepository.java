package com.adpl.warungbuwiwi.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StokRepository implements IStokRepository {

    @Override
    public List<Barang> getAllBarang() {
        List<Barang> list = new ArrayList<>();
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM barang")) {
            while (rs.next()) {
                list.add(new Barang(
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getInt("stok_barang")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan membaca data: " + e.getMessage());
        }
        return list;
    }

    @Override
    public Barang getBarangById(String id) {
        String sql = "SELECT * FROM barang WHERE id_barang = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Barang(
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getInt("stok_barang")
                );
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan mencari barang: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateStok(String id, int stokBaru) {
        String sql = "UPDATE barang SET stok_barang = ? WHERE id_barang = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, stokBaru);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kesalahan memperbarui stok: " + e.getMessage());
        }
    }
}