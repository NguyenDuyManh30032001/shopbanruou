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
public class NHACUNGCAP {
    private String macc, tencc;

    public NHACUNGCAP(String macc, String tencc) {
        this.macc = macc;
        this.tencc = tencc;
    }

    public NHACUNGCAP() {
    }
    public String getMacc() {
        return macc;
    }

    public void setMacc(String macc) {
        this.macc = macc;
    }

    public String getTencc() {
        return tencc;
    }

    public void setTencc(String tencc) {
        this.tencc = tencc;
    }
    
}
