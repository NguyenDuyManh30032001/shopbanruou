/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import DoiTuong.HOADON;
import DoiTuong.LoaiRuou;
import DoiTuong.Ruou;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author kero
 */
public class daoHOADON {
    public static ArrayList<HOADON> getDSB() {
        ArrayList<HOADON> dsb = new ArrayList<HOADON>();
        try{
            String sql = "select * from HOADON";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                HOADON b = new HOADON(rs.getString("mahd").trim(), rs.getString("ngayhd").trim(), rs.getString("makh").trim(), rs.getString("manv").trim(), rs.getInt("tongtien"));
                dsb.add(b);
            }
            cn.close();
        } catch(Exception e) {
            System.out.println("Lỗi");
        }
        return dsb;
    }
    public static int ThemXoaSua(String sql){
        int i = -1;
        try {
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            i = cn.executeUpdate(sql);
            cn.close();
            System.out.println("Thành Công");
        } catch(Exception e)
        {
            System.out.println("Không thành công");
        }
        return i;
    }
    public static int Update(String sql){
        int kq=0;
        try {
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            kq = cn.executeUpdate(sql);
            cn.close();
            System.out.println("Thành Công");
        } catch(Exception e)
        {
            System.out.println("Không thành công");
        }
        return kq;
    }
    public static ArrayList<LoaiRuou> TimTheoTen(String Ten)
    {
        ArrayList<LoaiRuou> ds = new ArrayList<LoaiRuou>();
        try
        {
            String sql = "select Distinct(RUOU.MALOAI), TENLOAI from HOADON, CTHOADON, RUOU, LOAIRUOU, KHACHHANG where HOADON.MAHD = CTHOADON.MAHD and CTHOADON.MARUOU = RUOU.MARUOU and RUOU.MALOAI = LOAIRUOU.MALOAI and KHACHHANG.MAKH = HOADON.MAKH and TENKH like '"+Ten+"'";
            ConnectionDB cn =new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                LoaiRuou a = new LoaiRuou(rs.getString("maloai").trim(),rs.getString("tenloai").trim());
                ds.add(a);
            }
            cn.close();
        }catch(Exception e){
            System.out.println("Loi khong the lay du lieu");
        }
        return ds;
    }
}
