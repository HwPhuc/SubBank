/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.DemoNganHang;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lehoangphuc
 */
public class DemoNganHang {

    private static final Scanner scanner = new Scanner(System.in);
    private static final NganHang nganHang = new NganHang();
    private static KhachHang khachHangHienTai;

    public static void main(String[] args) {
        while (true) {
            hienThiMenu();
            int luaChon = getLuaChonNguoiDung();

            switch (luaChon) {
                case 1:
                    taoTaiKhoan();
                    break;
                case 2:
                    dangNhap();
                    break;
                case 3:
                    moTaiKhoanCoKyHan();
                    break;
                case 4:
                    napTien();
                    break;
                case 5:
                    rutTien();
                    break;
                case 6:
                    timKiemKhachHang();
                    break;
                case 7:
                    hienThiDanhSachTaiKhoan();
                    break;
                case 8:
                    sapXepDanhSachKhachHangTheoSoDu();
                    break;
                case 9:
                    thayDoiMatKhau();
                    break;
                case 10:
                    dangXuat();
                    break;
                case 11:
                    System.out.println("Chương trình kết thúc. Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private static void hienThiMenu() {
        System.out.println("===== Menu Ngân Hàng =====");
        System.out.println("1. Tạo Tài Khoản");
        System.out.println("2. Đăng Nhập");
        System.out.println("3. Mở Tài Khoản Có Kỳ Hạn");
        System.out.println("4. Nạp Tiền");
        System.out.println("5. Rút Tiền");
        System.out.println("6. Tìm Kiếm Khách Hàng");
        System.out.println("7. Hiển Thị Danh Sách Tài Khoản");
        System.out.println("8. Sắp Xếp Danh Sách Khách Hàng Theo Số Dư");
        System.out.println("9. Thay Đổi Mật Khẩu");
        System.out.println("10. Đăng Xuất");
        System.out.println("11. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    private static int getLuaChonNguoiDung() {
        return scanner.nextInt();
    }

    private static void taoTaiKhoan() {
        System.out.print("Nhập họ tên đầy đủ của bạn: ");
        scanner.nextLine();
        String hoTen = scanner.nextLine();
        
        KhachHang khachHang = new KhachHang(taoMaKhachHang(), hoTen);
        nganHang.themKhachHang(khachHang);
        
        System.out.println("Tài khoản đã được tạo thành công. Tên đăng nhập của bạn: " + khachHang.getTenDangNhap() +
                ", Mật khẩu: " + khachHang.getMatKhau());
    }

    private static void dangNhap() {
        System.out.print("Nhập tên đăng nhập của bạn: ");
        String tenDangNhap = scanner.next();
        System.out.print("Nhập mật khẩu của bạn: ");
        String matKhau = scanner.next();

        khachHangHienTai = nganHang.getKhachHangTheoTenDangNhapVaMatKhau(tenDangNhap, matKhau);

        if (khachHangHienTai != null) {
            System.out.println("Đăng nhập thành công. Chào mừng, " + khachHangHienTai.getHoTen() + "!");
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng thử lại.");
        }
    }

    private static void moTaiKhoanCoKyHan() {
        if (daDangNhap()) {
            System.out.print("Nhập số tiền gửi ban đầu (tối thiểu 100): ");
            double soTienBanDau = scanner.nextDouble();

            if (soTienBanDau < 100) {
                System.out.println("Số tiền tối thiểu để mở tài khoản là 100. Tài khoản không được mở.");
            } else {
                System.out.print("Nhập kỳ hạn cho tài khoản có kỳ hạn (theo tháng): ");
                int kyHan = scanner.nextInt();

                TaiKhoanCoKyHan taiKhoan = new TaiKhoanCoKyHan(taoSoTaiKhoan(), soTienBanDau, 0.0, kyHan);
                khachHangHienTai.taoTaiKhoan(taiKhoan);
                System.out.println("Tài khoản có kỳ hạn đã được mở thành công. Số tài khoản: " + taiKhoan.getSoTaiKhoan());
            }
        }
    }

    private static void napTien() {
        if (daDangNhap()) {
            System.out.print("Nhập số tài khoản: ");
            String soTaiKhoan = scanner.next();
            System.out.print("Nhập số tiền nạp: ");
            double soTien = scanner.nextDouble();

            khachHangHienTai.napTien(soTien, soTaiKhoan);
        }
    }

    private static void rutTien() {
        if (daDangNhap()) {
            System.out.print("Nhập số tài khoản: ");
            String soTaiKhoan = scanner.next();
            System.out.print("Nhập số tiền rút: ");
            double soTien = scanner.nextDouble();

            khachHangHienTai.rutTien(soTien, soTaiKhoan);
        }
    }

    private static void timKiemKhachHang() {
        System.out.print("Nhập tên để tìm kiếm: ");
        scanner.nextLine();
        String ten = scanner.nextLine();
        List<KhachHang> ketQuaTimKiem = nganHang.timKiemKhachHangTheoTen(ten);

        if (ketQuaTimKiem.isEmpty()) {
            System.out.println("Không tìm thấy khách hàng phù hợp.");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (KhachHang khachHang : ketQuaTimKiem) {
                System.out.println("Mã khách hàng: " + khachHang.getMaKhachHang() + ", Tên: " + khachHang.getHoTen());
            }
        }
    }

    private static void hienThiDanhSachTaiKhoan() {
        if (daDangNhap()) {
            List<TaiKhoan> taiKhoanList = khachHangHienTai.getDanhSachTaiKhoan();

            if (taiKhoanList.isEmpty()) {
                System.out.println("Không tìm thấy tài khoản cho khách hàng này.");
            } else {
                System.out.println("Danh sách tài khoản của khách hàng:");
                for (TaiKhoan taiKhoan : taiKhoanList) {
                    System.out.println("Số tài khoản: " + taiKhoan.getSoTaiKhoan() +
                            ", Số dư: " + taiKhoan.getSoDu());
                }
            }
        }
    }

    private static void sapXepDanhSachKhachHangTheoSoDu() {
        nganHang.sapXepKhachHangTheoSoDu();
        System.out.println("Danh sách khách hàng đã được sắp xếp theo số dư giảm dần.");
    }

    private static void thayDoiMatKhau() {
        if (daDangNhap()) {
            System.out.print("Nhập mật khẩu hiện tại của bạn: ");
            String matKhauHienTai = scanner.next();

            if (matKhauHienTai.equals(khachHangHienTai.getMatKhau())) {
                System.out.print("Nhập mật khẩu mới của bạn: ");
                String matKhauMoi = scanner.next();
                khachHangHienTai.setMatKhau(matKhauMoi);
                System.out.println("Mật khẩu đã được thay đổi thành công.");
            } else {
                System.out.println("Mật khẩu hiện tại không đúng. Mật khẩu không thay đổi.");
            }
        }
    }

    private static void dangXuat() {
        khachHangHienTai = null;
        System.out.println("Đăng xuất thành công. Hẹn gặp lại!");
    }

    private static boolean daDangNhap() {
        if (khachHangHienTai == null) {
            System.out.println("Bạn cần đăng nhập để thực hiện hành động này.");
            return false;
        }
        return true;
    }

    private static String taoMaKhachHang() {
        // Thực hiện logic để tạo mã khách hàng duy nhất
        return "KH" + System.currentTimeMillis();
    }

    private static String taoSoTaiKhoan() {
        // Thực hiện logic để tạo số tài khoản duy nhất
        return "TK" + System.currentTimeMillis();
    }
}
