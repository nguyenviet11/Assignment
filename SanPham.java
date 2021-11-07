package Assignment;

import java.util.Scanner;

public class SanPham {
    private NhomHang nhomHang;
    private String maSanPham, maVach, tenSanPham, moTaSanPham;
    private float giaNhap, giaBan;
    private static int countSP = 1;
    Scanner sc = new Scanner(System.in);

    public SanPham() {
        super();
        this.nhomHang = new NhomHang();
    }

    public SanPham(NhomHang nhomHang, String tenSanPham, String moTaSanPham, float giaNhap, float giaBan) {
        super();
        this.nhomHang = nhomHang;
        this.tenSanPham = tenSanPham;
        this.moTaSanPham = moTaSanPham;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.maSanPham = this.nhomHang.getMaNhomHang() + String.format("%04d", countSP++);
        this.maVach = getMaSanPham() + this.tenSanPham;
    }

    public NhomHang getNhomHang() {
        return this.nhomHang;
    }

    public void setNhomHang(NhomHang nhomHang) {
        this.nhomHang = nhomHang;
    }

    public String getMaSanPham() {
        return this.maSanPham.toUpperCase();
    }

    public void setMaSanPham() {
        this.maSanPham = this.nhomHang.getMaNhomHang() + String.format("%04d", countSP++);
    }

    public void reNewMaSanPham(String maSanPhamOld) {
        this.maSanPham = this.nhomHang.getMaNhomHang() + maSanPhamOld.substring(4);
    }

    public String getMaVach() {
        return this.maVach;
    }

    public void setMaVach() {
        this.maVach = getMaSanPham() + this.tenSanPham;
    }

    public String getTenSanPham() {
        return this.tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTaSanPham() {
        return this.moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public float getGiaNhap() {
        return this.giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return this.giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public void nhapSanPham(NhomHang nhomHang) {
        this.nhomHang = nhomHang;
        setMaSanPham();
        System.out.println("Nhập tên sp:");
        this.tenSanPham = sc.nextLine();
        setMaVach();
        System.out.println(" Mô tả sp: ");
        this.moTaSanPham = sc.nextLine();

        do {
            try {
                System.out.println("Nhập giá gốc sp: ");
                this.giaNhap = sc.nextFloat();
            } catch (Exception e) {
                System.out.println("Giá của sp phải là số");
                sc.nextLine();
            }
        } while (this.giaNhap <= 0);
        do {
            try {
                System.out.println("Nhập giá bán sp ( >= giá nhập): ");
                this.giaBan = sc.nextFloat();
            } catch (Exception e) {
                System.out.println("Giá của sp phải là số");
                sc.nextLine();
            }
        } while (this.giaBan <= 0 || this.giaBan < this.giaNhap);
    }

    public void capNhatSanPham(NhomHang nhomHang, SanPham sanPham) {
        this.nhomHang = nhomHang;
        reNewMaSanPham(sanPham.getMaSanPham());
        System.out.println("Nhập tên sp:");
        this.tenSanPham = sc.nextLine();
        setMaVach();
        System.out.println("Mô tả sp: ");
        this.moTaSanPham = sc.nextLine();

        do {
            try {
                System.out.println("Nhập giá gốc sp: ");
                this.giaNhap = sc.nextFloat();
            } catch (Exception e) {
                System.out.println("Giá sp phải là số");
                sc.nextLine();
            }
        } while (this.giaNhap <= 0);
        do {
            try {
                System.out.println("Nhập giá bán của sp (>= giá nhập): ");
                this.giaBan = sc.nextFloat();
            } catch (Exception e) {
                System.out.println("Giá của sp là số(kp kí tự)");
                sc.nextLine();
            }
        } while (this.giaBan <= 0 || this.giaBan < this.giaNhap);
    }

    @Override
    public String toString() {
        return "San pham: { tenSanPham='" + getTenSanPham() + "'" + ", maSanPham='" + getMaSanPham() + "'"
                + ", maVach='" + getMaVach() + "'" + ", moTaSanPham='" + getMoTaSanPham() + "'" + ", giaBan='"
                + getGiaBan() + "'," + " VAT='" + String.format("%.2f", (getNhomHang().getVatNhomHang() * 100))
                + "%'}\n";
    }

    public String toList() {
        return "{tenSanPham='" + getTenSanPham() + "'" + ", maSanPham='" + getMaSanPham() + "'" + ", maVach='"
                + getMaVach() + "'" + ", moTaSanPham='" + getMoTaSanPham() + "'" + ", giaBan='" + getGiaBan() + "',"
                + " VAT='" + String.format("%.2f", (getNhomHang().getVatNhomHang() * 100)) + "%'}";
    }

    public String toDetail() {
        return "San pham: {tenSanPham='" + getTenSanPham() + "'" + ", maSanPham='" + getMaSanPham() + "'" + ", maVach='"
                + getMaVach() + "'" + ", moTaSanPham='" + getMoTaSanPham() + "'" + ", giaNhap='" + getGiaNhap() + "'"
                + ", giaBan='" + getGiaBan() + "'}, " + getNhomHang() + "}";
    }

}

	