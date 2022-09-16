/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import DoiTuong.Ruou;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class ThongTin {
    public static ArrayList<Ruou> getDSR()
    {
        ArrayList<Ruou> dsl = new ArrayList<Ruou>();
        try
        {
            String sql = "select * from Ruou";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                Ruou a = new Ruou(rs.getString("maruou").trim(),rs.getString("tenruou").trim(),rs.getString("xuatxu").trim()
                ,rs.getString("nongdo").trim(),rs.getString("thetich").trim(),rs.getString("giaban").trim(),rs.getString("maloai").trim());
                dsl.add(a);
            }
            cn.close();
        } catch (Exception e){
            System.out.println("Loi khong the lay du lieu loai san pham");
        }
        return dsl;
    }
    public static int ThemXoaSuaBan(String sql){
        int i = -1;
        try
        {
           
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            i = cn.executeUpdate(sql);
           System.out.println("Them/xoa/sua thanh cong");
         
        } catch (Exception e){
            System.out.println("Them/xoa/sua khong thanh cong");
        }
        return i;
    }
}
