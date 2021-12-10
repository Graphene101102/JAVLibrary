package JavLibrary;

public class Book {
    private String ten, ID, tacGia, theLoai, NXB;

    public Book() {

    }

    public Book(String iD) {
        super();
        ID = iD;
    }

    public Book(String ten, String iD, String tacGia, String theLoai, String nXB) {
        super();
        this.ten = ten;
        this.ID = iD;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.NXB = nXB;
    }

    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }

    public String getTacGia() {
        return tacGia;
    }
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNXB() {
        return NXB;
    }
    public void setNXB(String nXB) {
        NXB = nXB;
    }

    public void display(){
        System.out.println("-TEN :" + ten + ", ID: " + ID + ", TAC GIA: " + tacGia +
                ", THE LOAI: " + theLoai + ", NXB: " + NXB);
    }
}