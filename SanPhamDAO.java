package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPhamDAO {
    private ArrayList<SanPham> dsSanPham;
    Scanner sc = new Scanner(System.in);

    public SanPhamDAO() {
        this.dsSanPham = new ArrayList<SanPham>();
    }

    public ArrayList<SanPham> getDsSanPham() {
        return this.dsSanPham;
    }

    public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public void taoSanPham(NhomHangDAO NHD) {
        System.out.println("DS nhóm hàng: ");
        NHD.showDsNhomHang();
        System.out.println("Nhập mã nhóm hàng muốn thêm: ");
        String maNH = sc.nextLine();
        int index = NHD.timNhomHangTuMa(maNH);
        if (index == -1) {
            System.out.println("Mã nhóm hàng sai");
        } else if (index == -2) {
            System.out.println("Nhóm hàng k tồn tại");
        } else {
            NhomHang nh = NHD.getDsNhomHang().get(index);
            SanPham sp = new SanPham();
            sp.nhapSanPham(nh);
            this.dsSanPham.add(sp);
        }
    }

    public void taoSanPham(SanPham sp) {
        this.dsSanPham.add(sp);
    }

    // tim tu danh sach va tra ve index
    public int timSanPhamTuMa(String maSP) {
        if (maSP == null || maSP.length() != 8) {
            return -1;
            // ma sp ko dung
        } else {
            for (int i = 0; i < this.dsSanPham.size(); i++) {
                if (this.dsSanPham.get(i).getMaSanPham().equalsIgnoreCase(maSP)) {
                    return i;
                }
            }
        }
        return -2;
        // ko tim thay hoac ko ton tai
    }

    public void showDsSanPham() {
        for (SanPham sanPham : this.dsSanPham) {
            System.out.println(sanPham.toList());
        }
    }

    public void updateSanPham(String maSP, NhomHangDAO nhd) {
        if (maSP == null || maSP.length() != 8) {
            System.out.println("Mã sp k đúng");
        } else {
            int index = this.timSanPhamTuMa(maSP);
            if (index == -2) {
                System.out.println("k tìm thấy sp");
            } else {
                System.out.println("Ds nhóm hàng: ");
                nhd.showDsNhomHang();
                System.out.println("chọn nhóm hàng mới cho sp: ");
                String maNH = sc.nextLine();
                int indexNH = nhd.timNhomHangTuMa(maNH);
                if (indexNH == -1) {
                    System.out.println("Mã nhóm hàng nhập sai");
                } else if (indexNH == -2) {
                    System.out.println("nhóm hàng k tồn tại");
                } else {
                    NhomHang nh = nhd.getDsNhomHang().get(indexNH);
                    SanPham sp = this.dsSanPham.get(index);
                    sp.capNhatSanPham(nh, sp);
                    this.dsSanPham.set(index, sp);
                    if (this.dsSanPham.set(index, sp) == null) {
                        System.out.println("Cập nhật sp thất bại");
                    } else {
                        System.out.println("Cập nhật sp thành công!");
                    }
                }
            }
        }
    }
}

