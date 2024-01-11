/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DemoNganHang;

/**
 *
 * @author lehoangphuc
 */
abstract class TaiKhoan {
    private String soTaiKhoan;
    private double soDu;

    public TaiKhoan(String soTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.soDu = soDu;
    }

    public void napTien(double soTien) {
        this.setSoDu(this.getSoDu() + soTien);
        System.out.println("Nạp tiền thành công. Số dư mới: " + this.getSoDu());
    }

    public void rutTien(double soTien) {
        if (soTien <= this.getSoDu()) {
            this.setSoDu(this.getSoDu() - soTien);
            System.out.println("Rút tiền thành công. Số dư mới: " + this.getSoDu());
        } else {
            System.out.println("Không đủ số dư để rút tiền.");
        }
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }
    
    /**
     * @param soTaiKhoan the soTaiKhoan to set
     */
    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    /**
     * @param soDu the soDu to set
     */
    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }
}
