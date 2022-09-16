    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;


import DoiTuong.LoaiRuou;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class PhanLoai {
    public static ArrayList<LoaiRuou> getDSL()
    {
        ArrayList<LoaiRuou> dsl = new ArrayList<LoaiRuou>();
        try
        {
            String sql = "select * from LoaiRuou";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                LoaiRuou a = new LoaiRuou(rs.getString("maloai").trim(),rs.getString("tenloai").trim());
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

