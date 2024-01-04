/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DemoNganHang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lehoangphuc
 */
class KhachHang {
    private String maKhachHang;
    private String hoTen;
    private String tenDangNhap;
    private String matKhau;
    private List<TaiKhoan> danhSachTaiKhoan;

    public KhachHang(String maKhachHang, String hoTen) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.tenDangNhap = "User" + System.currentTimeMillis();
        this.matKhau = generatePassword();
        this.danhSachTaiKhoan = new ArrayList<>();
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public List<TaiKhoan> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }

    public void taoTaiKhoan(TaiKhoan taiKhoan) {
        getDanhSachTaiKhoan().add(taiKhoan);
    }

    public void napTien(double soTien, String soTaiKhoan) {
        for (TaiKhoan taiKhoan : getDanhSachTaiKhoan()) {
            if (taiKhoan.getSoTaiKhoan().equals(soTaiKhoan)) {
                taiKhoan.napTien(soTien);
                return;
            }
        }
        System.out.println("Không tìm thấy tài khoản có số " + soTaiKhoan);
    }

    public void rutTien(double soTien, String soTaiKhoan) {
        for (TaiKhoan taiKhoan : getDanhSachTaiKhoan()) {
            if (taiKhoan.getSoTaiKhoan().equals(soTaiKhoan)) {
                taiKhoan.rutTien(soTien);
                return;
            }
        }
        System.out.println("Không tìm thấy tài khoản có số " + soTaiKhoan);
    }

    private String generatePassword() {
        // Logic để tạo mật khẩu ngẫu nhiên
        return "Pass" + new Random().nextInt(1000000);
    }

    /**
     * @param maKhachHang the maKhachHang to set
     */
    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @param tenDangNhap the tenDangNhap to set
     */
    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    /**
     * @param danhSachTaiKhoan the danhSachTaiKhoan to set
     */
    public void setDanhSachTaiKhoan(List<TaiKhoan> danhSachTaiKhoan) {
        this.danhSachTaiKhoan = danhSachTaiKhoan;
    }
}
