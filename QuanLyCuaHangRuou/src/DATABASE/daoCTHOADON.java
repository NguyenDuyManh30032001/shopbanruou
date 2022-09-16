/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import DoiTuong.CTHOADON;
import DoiTuong.Ruou;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author kero
 */
public class daoCTHOADON {
    public static ArrayList<CTHOADON> getDSB() {
        ArrayList<CTHOADON> dsb = new ArrayList<CTHOADON>();
        try{
            String sql = "select MAHD, CTHOADON.MARUOU, SOLUONG, SOLUONG*GIABAN as THANHTIEN  from CTHOADON, RUOU where CTHOADON.MARUOU = RUOU.MARUOU group by MAHD, CTHOADON.MARUOU, SOLUONG, GIABAN";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                CTHOADON b = new CTHOADON(rs.getString("mahd").trim(), rs.getString("maruou").trim(), rs.getInt("soluong"), rs.getInt("thanhtien"));
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
    public static int Dem(String sql){
        int i = -1;
        try
        {
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet st = cn.executeQuery(sql);
            while(st.next())
            {
                i = st.getInt("SoLan");
            }
            cn.close();
        } catch (Exception e){
            System.out.println("Loi khong the lay du lieu ban");
        }
        return i;
    }
        public static ArrayList<Ruou> TimTheoTen(String Ten)
    {
        ArrayList<Ruou> ds = new ArrayList<Ruou>();
        try
        {
            String sql = "select * from RUOU where TENRUOU like '"+Ten+"'";
            ConnectionDB cn =new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                Ruou a = new Ruou(rs.getString("maruou").trim(),rs.getString("tenruou").trim(),rs.getString("xuatxu").trim()
                ,rs.getString("nongdo").trim(),rs.getString("thetich").trim(),rs.getString("giaban").trim(),rs.getString("maloai").trim());
                ds.add(a);
            }
            cn.close();
        }catch(Exception e){
            System.out.println("Loi khong the lay du lieu");
        }
        return ds;
    }
    public static ArrayList<Ruou> TimTheoMa(String Ma)
    {
        ArrayList<Ruou> ds = new ArrayList<Ruou>();
        try
        {
            String sql = "select MARUOU, TENRUOU, XUATXU, NONGDO, THETICH, GIABAN, MALOAI from RUOU where MARUOU like '%"+Ma+"%'";
            ConnectionDB cn =new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                Ruou a = new Ruou(rs.getString("maruou").trim(),rs.getString("tenruou").trim(),rs.getString("xuatxu").trim()
                ,rs.getString("nongdo").trim(),rs.getString("thetich").trim(),rs.getString("giaban").trim(),rs.getString("maloai").trim());
                ds.add(a);
            }
            cn.close();
        }catch(Exception e){
            System.out.println("Loi khong the lay du lieu");
        }
        return ds;
    }

}
