package Assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NhomHang {
    private String maNhomHang, tenNhomHang;
    private float vatNhomHang;
    Scanner sc = new Scanner(System.in);

    public NhomHang() {
        super();
    }

    public NhomHang(String maNhomHang, String tenNhomHang, float vatNhomHang) {
        super();
        this.maNhomHang = maNhomHang;
        this.tenNhomHang = tenNhomHang;
        this.vatNhomHang = vatNhomHang;
    }

    public String getMaNhomHang() {
        return this.maNhomHang.toUpperCase();
    }

    public void setMaNhomHang(String maNhomHang) {
        this.maNhomHang = (maNhomHang == null) ? "KHAC"
                : (maNhomHang.length() != 4) ? "KHAC" : (maNhomHang.contains(" ") ? "KHAC" : maNhomHang.toUpperCase());
    }

    public String getTenNhomHang() {
        return this.tenNhomHang.toUpperCase();
    }

    public void setTenNhomHang(String tenNhomHang) {
        this.tenNhomHang = tenNhomHang.toUpperCase();
    }

    public float getVatNhomHang() {
        return this.vatNhomHang;
    }

    public void setVatNhomHang(float vatNhomHang) {
        this.vatNhomHang = vatNhomHang;
    }

    public void nhapNhomHang(String maNH) {
        this.maNhomHang = maNH;
        System.out.println("Nhập tên nhóm hàng: ");
        this.tenNhomHang = sc.nextLine();
        do {
            try {
                System.out.println("Nhập VAT cho nhóm hàng: ");
                this.vatNhomHang = sc.nextFloat();
                System.out.println("thêm nhóm hàng thành công");
            } catch (InputMismatchException e) {
                System.out.println("yêu cầu vat > 0 và vat < 1");
                sc.nextLine();
            }
        } while (this.vatNhomHang <= 0 || this.vatNhomHang >= 1);
    }

    @Override
    public String toString() {
        return "Nhom hang: {maNhomHang='" + getMaNhomHang() + "'" + ", tenNhomHang='" + getTenNhomHang() + "'"
                + ", vatNhomHang='" + getVatNhomHang();  }
    
}
