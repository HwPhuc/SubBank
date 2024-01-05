/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DemoNganHang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author lehoangphuc
 */
class NganHang {
    private List<KhachHang> danhSachKhachHang;

    public NganHang() {
        this.danhSachKhachHang = new ArrayList<>();
    }

    public void themKhachHang(KhachHang khachHang) {
        getDanhSachKhachHang().add(khachHang);
    }

    public KhachHang getKhachHangTheoTenDangNhapVaMatKhau(String tenDangNhap, String matKhau) {
        for (KhachHang khachHang : getDanhSachKhachHang()) {
            if (khachHang.getTenDangNhap().equals(tenDangNhap) && khachHang.getMatKhau().equals(matKhau)) {
                return khachHang;
            }
        }
        return null;
    }

    public List<KhachHang> timKiemKhachHangTheoTen(String ten) {
        List<KhachHang> ketQuaTimKiem = new ArrayList<>();
        for (KhachHang khachHang : getDanhSachKhachHang()) {
            if (khachHang.getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                ketQuaTimKiem.add(khachHang);
            }
        }
        return ketQuaTimKiem;
    }

//    public void sapXepKhachHangTheoSoDu() {
//        Collections.sort(getDanhSachKhachHang(), (kh1, kh2) -> {
//            double tongSoDu1 = kh1.getDanhSachTaiKhoan().stream().mapToDouble(TaiKhoan::getSoDu).sum();
//            double tongSoDu2 = kh2.getDanhSachTaiKhoan().stream().mapToDouble(TaiKhoan::getSoDu).sum();
//            return Double.compare(tongSoDu2, tongSoDu1);
//        });
//    }
    
    public void sapXepKhachHangTheoSoDu() {
    List<KhachHang> danhSachKhachHang = getDanhSachKhachHang();
    
    Collections.sort(danhSachKhachHang, (kh1, kh2) -> {
        double tongSoDu1 = kh1.getDanhSachTaiKhoan().stream().mapToDouble(TaiKhoan::getSoDu).sum();
        double tongSoDu2 = kh2.getDanhSachTaiKhoan().stream().mapToDouble(TaiKhoan::getSoDu).sum();
        return Double.compare(tongSoDu2, tongSoDu1);
    });

    System.out.println("Danh sách khách hàng sau khi sắp xếp:");
    for (KhachHang khachHang : danhSachKhachHang) {
        System.out.println("Mã khách hàng: " + khachHang.getMaKhachHang() + ", Tên: " + khachHang.getHoTen() +
                ", Tổng số dư: " + khachHang.getDanhSachTaiKhoan().stream().mapToDouble(TaiKhoan::getSoDu).sum());
    }
}

    /**
     * @return the danhSachKhachHang
     */
    public List<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    /**
     * @param danhSachKhachHang the danhSachKhachHang to set
     */
    public void setDanhSachKhachHang(List<KhachHang> danhSachKhachHang) {
        this.danhSachKhachHang = danhSachKhachHang;
    }
}
