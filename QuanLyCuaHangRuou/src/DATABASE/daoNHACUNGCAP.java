/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

import DoiTuong.NHACUNGCAP;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author kero
 */
public class daoNHACUNGCAP {
    public static ArrayList<NHACUNGCAP> getDSB() {
        ArrayList<NHACUNGCAP> dsb = new ArrayList<NHACUNGCAP>();
        try{
            String sql = "select * from NHACUNGCAP";
            ConnectionDB cn = new ConnectionDB();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                NHACUNGCAP b = new NHACUNGCAP(rs.getString("macc").trim(), rs.getString("tencc").trim());
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

}

