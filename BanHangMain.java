package Assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BanHangMain {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static Scanner sc = new Scanner(System.in);
    static NhomHangDAO NHD = new NhomHangDAO();
    static SanPhamDAO SPD = new SanPhamDAO();
    static DonHangDAO DHD = new DonHangDAO();

    public static void main(String[] args) {
  
        String confirm = "";
        boolean isError = false;
        do {
            try {
                isError = false;
                
                mainMenu();
                System.out.println("Nhap lua chon: ");
                int menu0 = sc.nextInt();
                switch (menu0) {
                case 1: // crud nhom hang
                   
                    int menu1;
                    do {
                        crudNhomHang();
                        System.out.println("Nhập lựa chọn: ");
                        menu1 = sc.nextInt();
                        switch (menu1) {
                        case 1:// tao nhom hang
                            System.out.println("Tạo nhóm hàng");
                            NHD.taoNhomHang();
                            break;
                        case 2: // show nhom hang
                            System.out.println("Danh sách nhóm hàng");
                            NHD.showDsNhomHang();
                            break;
                        case 3: // tim kiem nhom hang
                            System.out.println("Tìm kiếm nhóm hàng");
                            sc.nextLine();
                            System.out.println("Nhập mã nhóm hàng cần tìm: ");
                            String maNH = sc.nextLine();
                            int index = NHD.timNhomHangTuMa(maNH);
                            if (index == -1) {
                                System.out.println("Mã nhóm hàng sai.");
                            } else if (index == -2) {
                                System.out.println("Không tìm thấy nhóm hàng");
                            } else {
                                System.out.println(NHD.getDsNhomHang().get(index));
                            }
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ");
                            break;
                        }
                        if (menu1 == 4) {
                            break;
                        }
                    } while (menu1 != 4);
                    break;
                case 2: // crud san pham
                    
                    int menu2;
                    do {
                        crudSanPham();
                        System.out.println("Nhập lựa chọn: ");
                        menu2 = sc.nextInt();
                        int index = -1;
                        String maSP = "";
                        switch (menu2) {
                        case 1: // tao san pham
                            System.out.println("Tạo sản phẩm");
                            SPD.taoSanPham(NHD);
                            break;
                        case 2: // show san pham
                            System.out.println("Danh sách sản phẩm");
                            SPD.showDsSanPham();
                            break;
                        case 3: // tim kiem san pham theo ma
                            System.out.println("Tìm kiếm sản phẩm");
                            sc.nextLine();
                            System.out.println("Nhập mã sản phẩm cần tìm: ");
                            maSP = sc.nextLine();
                            index = SPD.timSanPhamTuMa(maSP);
                            if (index == -1) {
                                System.out.println("Mã sản phẩm nhập sai.");
                            } else if (index == -2) {
                                System.out.println("Không tìm thấy sản phẩm");
                            } else {
                                System.out.println(SPD.getDsSanPham().get(index).toDetail());
                            }
                            break;
                    
                        case 4: 
                            System.out.println("Update sản phẩm");
                            sc.nextLine();
                            System.out.println("Nhập mã sản phẩm cần sửa thông tin: ");
                            maSP = sc.nextLine();
                            SPD.updateSanPham(maSP, NHD);
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ");
                            break;
                        }
                        if (menu2 == 5) {
                            break;
                        }
                    } while (menu2 != 5);
                    break;
                case 3: // crud don hang
                    
                    int menu3;
                    do {
                        crudDonHang();
                        System.out.println("Nhập lựa chọn: ");
                        menu3 = sc.nextInt();
                        switch (menu3) {
                        case 1: // tao don hang
                            System.out.println("Tạo đơn hàng");
                            DHD.taoDonHang(SPD);
                            break;
                        case 2: // show all don hang cua ca nam
                            System.out.println("Danh sách đơn hàng");
                            DHD.showDsDonHang();
                            break;                
                        case 3:
                            break;
                        default:
                            System.out.println("lựa chọn không hợp lệ");
                            break;
                        }
                        if (menu3 == 3) {
                            break;
                        }
                    } while (menu3 != 3);
                    break;
                case 4: 
                    break;
                    
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn k hơp lệ");
                    break;
                }
                if (menu0 == 5) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Lựa chọn k hơp lệ");
                isError = true;
            }
            sc.nextLine();
            System.out.println("Bạn có muốn tiếp tục (n  = không)");
            confirm = sc.nextLine();
        } while (!"n".equalsIgnoreCase(confirm) || isError);
    }

    public static void mainMenu() {
        System.out.println("MENU");
        System.out.println("1. CRUD Nhóm Hàng.");
        System.out.println("2. CRUD Sản Phẩm.");
        System.out.println("3. CRUD Đơn Hàng.");
        System.out.println("4. Báo Cáo.");
        System.out.println("5. Thoát.");
    }

    public static void crudNhomHang() {
        System.out.println("CRUD Nhóm hàng");
        System.out.println("1. Thêm Nhóm Hàng.");
        System.out.println("2. Hiển thị Nhóm Hàng.");
        System.out.println("3. Tìm Nhóm Hàng.");
        System.out.println("4. Quay lại.");
    }

    public static void crudSanPham() {
        System.out.println("CRUD Sản phẩm");
        System.out.println("1. Thêm Sản Phẩm.");
        System.out.println("2. Hiển Thị Sản Phẩm.");
        System.out.println("3. Tìm sản phẩm theo mã sản phẩm.");
        System.out.println("4. Update Thong tin San Pham.");
        System.out.println("5. Quay lai.");
    }

    public static void crudDonHang() {
        System.out.println("CRUD đơn hàng");
        System.out.println("1. Thêm đơn hàng.");
        System.out.println("2. Hiển thị danh sách đơn hàng.");       
        System.out.println("3. Quay lại.");
    }

    // Data demo
    


}
