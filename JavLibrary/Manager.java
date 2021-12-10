package JavLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Person {
    Scanner scan = new Scanner(System.in);

    ArrayList<Book> quanLiSach = new ArrayList<>();
    ArrayList<Customer> quanLiKhach = new ArrayList<>();

    public Manager() {
    }

    // ------------------------QUAN LI SACH-----------------------------------------


    // Nhap them sach
    public void addBook() {
        Book bookAdd = null;
        String ten, ID, tacGia, theLoai, NXB;
        boolean check = true;

        System.out.print("\t ID : ");			ID = scan.nextLine();
        System.out.print("\t Ten sach : ");	    ten = scan.nextLine();
        System.out.print("\t Tac gia : ");		tacGia = scan.nextLine();
        System.out.print("\t The loai : ");	    theLoai = scan.nextLine();
        System.out.print("\t NXB : ");			NXB = scan.nextLine();
        System.out.println("\n");

        // check = true neu sach chua co
        for (int i = 0; i < quanLiSach.size(); i++) {
            if (quanLiSach.get(i).getID().equals(ID)) {
                check = false;
                break;
            }
        }
        // Neu check = true thi them sach
        if (check) {
            bookAdd = new Book(ten, ID, tacGia, theLoai, NXB);
            quanLiSach.add(bookAdd);
        } else{
            System.out.println("ID sach da ton tai!!!");
        }
    }

    // Tim sach theo ten
    public void findNameBook(String name) {
        int dem = 0;	//Dem so luong và hien thi thu tu
        for (int i = 0; i < quanLiSach.size(); i++) {
            // tim chuoi khong phan biet hoa thuong
            if (quanLiSach.get(i).getTen().toLowerCase().contains(name.toLowerCase())) {
                dem++;
                System.out.print(dem + ". ");
                quanLiSach.get(i).display();
            }
        }
        if (dem == 0) {
            System.err.println("Khong tim thay!");
        }
    }

    // Tim sach theo the loai
    public void findKindBook(String kind) {
        int dem = 0;
        for (int i = 0; i < quanLiSach.size(); i++) {
            //Khong phan biet hoa thuong
            if (quanLiSach.get(i).getTheLoai().toLowerCase().contains(kind.toLowerCase())) {
                dem++;
                System.out.print(dem + ". ");
                quanLiSach.get(i).display();
            }
        }
        if (dem == 0) {
            System.err.println("Khong tim thay!");
        }
    }

    // Tim sach theo NXB
    public void findNXB(String NXB) {
        int dem = 0;
        for (int i = 0; i < quanLiSach.size(); i++) {
            if (quanLiSach.get(i).getNXB().toLowerCase().contains(NXB.toLowerCase())) {
                dem++;
                System.out.print(dem + ". ");
                quanLiSach.get(i).display();
            }
        }
        if (dem == 0) {
            System.err.println("Khong tim thay!");
        }
    }

    // Tim sach theo tac gia
    public void findAuthor(String author) {
        int dem = 0;
        for (int i = 0; i < quanLiSach.size(); i++) {
            if (quanLiSach.get(i).getTacGia().toLowerCase().contains(author.toLowerCase())) {
                dem++;
                System.out.print(dem + ". ");
                quanLiSach.get(i).display();
            }
        }
        if (dem == 0) {
            System.err.println("Khong tim thay!");
        }
    }
    // ------------------------------QUAN LI KHACH HANG------------------------------------

    // Them khach hang vao he thong
    public void addCustomer() {
        Customer customerAdd = null;
        String ten, diaChi, ID, soDT;
        int tuoi;
        boolean check = true;

        System.out.print("\t ID : ");				ID = scan.nextLine();
        System.out.print("\t Ten khach hang : ");	ten = scan.nextLine();
        System.out.print("\t Dia chi : ");			diaChi = scan.nextLine();
        System.out.print("\t So dien thoai : ");	soDT = scan.nextLine();
        System.out.print("\t Tuoi : ");			    tuoi = Integer.parseInt(scan.nextLine());
        System.out.println("\n");

        for (int i = 0; i < quanLiKhach.size(); i++) {
            if (quanLiKhach.get(i).getID().equals(ID)) {
                check = false;
                break;
            }
        }
        if (check) {
            customerAdd = new Customer(ID, ten, tuoi, soDT, diaChi);
            quanLiKhach.add(customerAdd);
        } else{
            System.err.println("ID khach hang da ton tai!!!");
        }
    }
        //Tim theo ten khach hang
    public void findNameCustomer(String name) {
        int dem = 0;
        for (int i = 0; i < quanLiKhach.size(); i++) {
            if (quanLiKhach.get(i).getTen().toLowerCase().contains(name.toLowerCase())) {
                dem++;
                System.out.print(dem + ". ");
                quanLiKhach.get(i).display();
            }
        }
        if (dem == 0) {
            System.err.println("Khong tim thay!");
        }
    }
        //Tim theo ID
    public void findIdCustomer(String id) {
        int dem = 0;
        for (int i = 0; i < quanLiKhach.size(); i++) {
            // Tim chinh xac va khong phan biet hoa thuong
            if (quanLiKhach.get(i).getID().toLowerCase().equals(id.toLowerCase())) {
                dem++;
                quanLiKhach.get(i).display();
            }
        }
        if (dem == 0) {
            System.err.println("Khong tim thay!");
        }
    }
        //Tim theo SDT
    public void findNumberPhoneCustomer(String numberPhone) {
        int dem = 0;
        for (int i = 0; i < quanLiKhach.size(); i++) {
            // Tim chinh xac
            if (quanLiKhach.get(i).getSoDT().toLowerCase().equals(numberPhone.toLowerCase())) {
                dem++;
                quanLiKhach.get(i).display();
            }
        }
        if (dem == 0) {
            System.err.println("Khong tim thay!");
        }
    }

    //-------------------------------CHO MUON SACH---------------------------------

    public void Muon_Sach() {
        if (quanLiSach.size() < 1) {
            System.err.println("Kho dang trong, hay nhap them sach!!!");
            return;
        }

        //Tao danh sach sach can muon
        ArrayList<Integer> listSachBan = new ArrayList<>();
        System.out.println("===Nhap list sach muon muon===");
        String IDSach;
        boolean check = false;
        int viTriSach = -1;
        String ans;
        do {
            System.out.print("Ma sach (ID): ");
            IDSach = scan.nextLine();

            // check = true neu sach co trong kho chua
            for (int i = 0; i < quanLiSach.size(); i++) {
                if (quanLiSach.get(i).getID().equalsIgnoreCase(IDSach)) {
                    check = true;
                    viTriSach = i;
                    break;
                } else {
                    check = false;
                }
            }
            if (check) {
                listSachBan.add(viTriSach);
            } else {
                System.out.println("Sach khong co, hay chon sach khac!!!");
            }

            System.out.print("Muon them sach khac? (y/n) ");
            ans = scan.nextLine();
        } while (ans.contains("y"));


        // Neu da chon sach thi tiep tuc chon khach hang
        if (listSachBan.size() > 0) {
            int m = 0;
            do {
                System.out.print("Nhap ID khach hang mua sach: ");
                String IDKhach = scan.nextLine();
                boolean find = false;
                int viTriKhach = -1;

                //find = true neu khach hang co ton tai
                for (int i = 0; i < quanLiKhach.size(); i++) {
                    if (quanLiKhach.get(i).getID().equals(IDKhach)) {
                        find = true;
                        viTriKhach = i;
                        break;
                    }
                }

                // Neu find = true thi tien hanh cho muon
                if (find) {
                    m=1;
                    System.out.println("****************************************************************");
                    System.out.println("\t\t\t ===Hoa don=== ");
                    System.out.println("\t Khach hang: \t" + quanLiKhach.get(viTriKhach).getTen());
                    System.out.println("\t Sach: ");
                    for (int i = 0; i < listSachBan.size(); i++) {
                        System.out.println("\t\t\t\t\t" + quanLiSach.get(listSachBan.get(i)).getID() + "\t" + quanLiSach.get(listSachBan.get(i)).getTen());
                        break;
                    }
                    System.out.println("\t\t Cam on va hen gap lai quy khach");
                    System.out.println("****************************************************************");
                } else {
                    System.out.println("ID khach hang chua ton tai");
                    m = 0;
                }
            } while (m == 0);
        } else {
            System.err.println("Ban chua chon sach can muon!!!");
            System.out.println("");
        }
    }

    //-------------------------------MAIN-------------------------------------------

    //Quan li sach
    public void quanLi_Sach() {
        int stop = 0;

        do {
            System.out.println("\n\t === Quan li sach ===");
            System.out.println("\t---------------------");
            System.out.println("\t| 1. Them sach      |");
            System.out.println("\t| 2. Tim sach       |");
            System.out.println("\t| 3. In kho sach    |");
            System.out.println("\t| 4. Tro lai        |");
            System.out.println("\t---------------------");

            System.out.print("Moi lua chon: ");
            int choose = Integer.valueOf(scan.nextLine());

            String stop2;
            int choose2;

            switch (choose) {
                case 1:
                    do {
                        addBook();
                        System.out.print("Tiep tuc them sach? (y/n) ");
                        stop2 = scan.nextLine();
                        System.out.println("\n");
                    } while (stop2.contains("y"));
                    break;
                case 2:
                    System.out.println("\t\t-----------------------------");
                    System.out.println("\t\t| 1. Tim theo ten           |");
                    System.out.println("\t\t| 2. Tim theo tac gia       |");
                    System.out.println("\t\t| 3. Tim theo the loai      |");
                    System.out.println("\t\t| 4. Tim theo Nha xuat ban  |");
                    System.out.println("\t\t-----------------------------");

                    System.out.print("Moi lua chon: ");
                    choose2 = Integer.valueOf(scan.nextLine());
                    switch (choose2) {
                        case 1:
                            System.out.print("Nhap sach can tim: ");
                            String bookName = scan.nextLine();
                            findNameBook(bookName);
                            break;
                        case 2:
                            System.out.print("Nhap tac gia can tim: ");
                            String bookAuthor = scan.nextLine();
                            findAuthor(bookAuthor);
                            break;
                        case 3:
                            System.out.print("Nhap sach the loai can tim: ");
                            String bookKind = scan.nextLine();
                            findKindBook(bookKind);
                            break;
                        case 4:
                            System.out.print("Nhap Nha xuat ban can tim: ");
                            String bookNXB = scan.nextLine();
                            findNXB(bookNXB);
                            break;
                        default:
                            System.out.println("Yeu cau khong hop le!");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("======= Danh sach sach ===============================");
                    for(int i=0; i<quanLiSach.size(); i++){
                        quanLiSach.get(i).display();
                    }
                    break;
                case 4:
                    stop = 1;
                    break;
                default:
                    System.out.println("Yeu cau khong hop le!");
                    break;
            }
        } while (stop == 0);
    }

    //Quan li khach hang
    public void quanLi_KhachHang(){
        int stop = 0, choose;

        do {
            System.out.println("\n\t === Quan li khach hang ===");
            System.out.println("\t----------------------------");
            System.out.println("\t| 1. Them khach hang       |");
            System.out.println("\t| 2. Tim khach hang        |");
            System.out.println("\t| 3. Danh sach khach hang  |");
            System.out.println("\t| 4. Quay lai              |");
            System.out.println("\t----------------------------");

            System.out.print("Moi lua chon: ");
            choose = Integer.valueOf(scan.nextLine());

            int choose2;

            switch (choose) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    System.out.println("\t\t------------------------------");
                    System.out.println("\t\t| 1. Tim theo ten            |");
                    System.out.println("\t\t| 2. Tim theo ID             |");
                    System.out.println("\t\t| 3. Tim theo so dien thoai  |");
                    System.out.println("\t\t------------------------------");

                    System.out.print("Moi lua chon: ");
                    choose2 = Integer.valueOf(scan.nextLine());
                    switch (choose2) {
                        case 1:
                            System.out.print("Nhap ten can tim: ");
                            String customerName = scan.nextLine();
                            findNameCustomer(customerName);
                            break;
                        case 2:
                            System.out.print("Nhap ID can tim: ");
                            String customerID = scan.nextLine();
                            findIdCustomer(customerID);
                            break;
                        case 3:
                            System.out.print("Nhap so dien thoai can tim: ");
                            String customerSDT = scan.nextLine();
                            findNumberPhoneCustomer(customerSDT);
                            break;
                        default:
                            System.out.println("Yeu cau khong hop le!");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("=======Danh sach khach hang======================================= : ");
                    for (int i=0; i< quanLiKhach.size(); i++){
                        quanLiKhach.get(i).display();
                    }
                    break;
                case 4:
                    stop = 1;
                    break;
                default:
                    System.out.println("Yeu cau khong hop le!");
                    break;
            }
        } while (stop == 0);
    }

    public void Library() {
        System.out.println("=====================================================================");
        System.out.println("\t ===Welcom to JAV library!===");

        int stop = 0, choose;

        do {
            System.out.println("\t--------------------------");
            System.out.println("\t| 1. Quan li sach        |");
            System.out.println("\t| 2. Quan li khach hang  |");
            System.out.println("\t| 3. Muon sach           |");
            System.out.println("\t| 4. Thoat he thong      |");
            System.out.println("\t--------------------------");

            System.out.print("Moi lua chon: ");
            choose = Integer.valueOf(scan.nextLine());
            switch (choose){
                case 1:
                    quanLi_Sach();
                    break;
                case 2:
                    quanLi_KhachHang();
                    break;
                case 3:
                    Muon_Sach();
                    break;
                case 4:
                    stop = 1;
                    System.out.println("\n\t\tTam biet!");
                    break;
                default:
            }
        } while (stop == 0);
    }
}