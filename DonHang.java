package Assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DonHang {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    private String tenKhachHang;
    private Date ngayMuaHang;
    private ArrayList<SanPham> dsSanPham;

    public DonHang() {
        super();
        this.dsSanPham = new ArrayList<SanPham>();
    }

    public DonHang(String tenKhachHang, Date ngayMuaHang, ArrayList<SanPham> dsSanPham) {
        super();
        this.tenKhachHang = tenKhachHang;
        this.ngayMuaHang = ngayMuaHang;
        this.dsSanPham = dsSanPham;
    }

    public String getTenKhachHang() {
        return this.tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgayMuaHang() {
        return this.ngayMuaHang;
    }

    public void setNgayMuaHang(Date ngayMuaHang) {
        this.ngayMuaHang = ngayMuaHang;
    }

    public ArrayList<SanPham> getDsSanPham() {
        return this.dsSanPham;
    }

    public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public void nhapDonHang() {
        System.out.println("Tên KH: ");
        this.tenKhachHang = sc.nextLine();
        do {
            System.out.println("Ngày mua hàng (dd/MM/yyyy): ");
            try {
                this.ngayMuaHang = sdf.parse(sc.nextLine());
            } catch (ParseException e) {
            }
        } while (this.ngayMuaHang == null);
        System.out.println("Thêm sp vào đơn hàng của bạn");
    }

    @Override
    public String toString() {
        return "Don hang { tenKhachHang='" + getTenKhachHang() + "'" + ", ngayMuaHang='"
                + sdf.format(getNgayMuaHang()) + "'}," + "\nDS SanPham:\n" + getDsSanPham() + "\n}";
    }

}
