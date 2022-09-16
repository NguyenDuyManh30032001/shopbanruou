/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoiTuong;

/**
 *
 * @author kero
 */
public class HOADON {
    private String mahd, ngayhd, makh, manv;
    private int tongtien;

    public HOADON(String mahd, String ngayhd, String makh, String manv, int tongtien) {
        this.mahd = mahd;
        this.ngayhd = ngayhd;
        this.makh = makh;
        this.manv = manv;
        this.tongtien = tongtien;
    }

    public HOADON() {
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getNgayhd() {
        return ngayhd;
    }

    public void setNgayhd(String ngayhd) {
        this.ngayhd = ngayhd;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
}
