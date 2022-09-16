/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import DoiTuong.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class LayDSNV {
     public static ArrayList<NhanVien> getDSNV()
    {
        ArrayList<NhanVien> dsl = new ArrayList<NhanVien>();
        try
        {
            String sql = "select manv,tennv,ngsinh,diachi,dthoai,taikhoan,matkhau from NhanVien";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next())
            {
                NhanVien a = new NhanVien(rs.getString("manv").trim(),rs.getString("tennv").trim(),rs.getString("ngsinh").trim(),rs.getString("diachi").trim()
                ,rs.getString("dthoai").trim(),rs.getString("taikhoan").trim(),rs.getString("matkhau").trim());
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
