/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DemoNganHang;

/**
 *
 * @author lehoangphuc
 */
class TaiKhoanCoKyHan extends TaiKhoan {
    private int kyHan;

    public TaiKhoanCoKyHan(String soTaiKhoan, double soDu, double laiSuat, int kyHan) {
        super(soTaiKhoan, soDu);
        this.kyHan = kyHan;
    }

    public void addLaiSuat() {
        double laiSuat = getSoDu() * 0.02; // Giả sử lãi suất là 2% hàng tháng
        napTien(laiSuat);
    }

    public int getKyHan() {
        return kyHan;
    }
    
    /**
     * @param kyHan the kyHan to set
     */
    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }
}
