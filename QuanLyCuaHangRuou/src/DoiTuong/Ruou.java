/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoiTuong;

/**
 *
 * @author LENOVO
 */
public class Ruou {
     String   maruou,tenruou,xuatxu,nongdo,thetich,giaban,mal;

    public Ruou() {
    }

    public Ruou(String maruou, String tenruou, String xuatxu, String nongdo, String thetich, String giaban, String mal) {
        this.maruou = maruou;
        this.tenruou = tenruou;
        this.xuatxu = xuatxu;
        this.nongdo = nongdo;
        this.thetich = thetich;
        this.giaban = giaban;
        this.mal = mal;
    }

    public String getMaruou() {
        return maruou;
    }

    public void setMaruou(String maruou) {
        this.maruou = maruou;
    }

    public String getTenruou() {
        return tenruou;
    }

    public void setTenruou(String tenruou) {
        this.tenruou = tenruou;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public String getNongdo() {
        return nongdo;
    }

    public void setNongdo(String nongdo) {
        this.nongdo = nongdo;
    }

    public String getThetich() {
        return thetich;
    }

    public void setThetich(String thetich) {
        this.thetich = thetich;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    public String getMal() {
        return mal;
    }

    public void setMal(String mal) {
        this.mal = mal;
    }

    @Override
    public String toString() {
        return "Ruou{" + "maruou=" + maruou + ", tenruou=" + tenruou + ", xuatxu=" + xuatxu + ", nongdo=" + nongdo + ", thetich=" + thetich + ", giaban=" + giaban + ", mal=" + mal + '}';
    }
    
}
