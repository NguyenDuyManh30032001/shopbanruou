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
public class CTHOADON {
    private String mahd, maruou;
    private int soluong;
    private int thanhtien;

    public CTHOADON(String mahd, String maruou, int soluong, int thanhtien) {
        this.mahd = mahd;
        this.maruou = maruou;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public CTHOADON() {
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMaruou() {
        return maruou;
    }

    public void setMaruou(String maruou) {
        this.maruou = maruou;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    
}
