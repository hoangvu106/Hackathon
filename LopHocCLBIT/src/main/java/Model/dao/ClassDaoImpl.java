/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.dao;

import Model.beans.StudentInClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DatNguyen
 */
public class ClassDaoImpl implements ClassDao {
    Connection conn = ConnectionUtil.getConnection();
    @Override
    public ArrayList<StudentInClass> getListClass(String username) {
        String sql = "select class.id_class, member.name  as teachername, class.name as classname\n" +
"                from account, member, studentinclass, class\n" +
"                where account.username = ?" +
"                and studentinclass.id_student = account.id\n" +
"                and class.id_teacher = member.id\n" +
"                and studentinclass.id_class = class.id_class";
                
        String id = "";
        ArrayList<StudentInClass> listClass = new ArrayList<StudentInClass>();
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                String classid = res.getString("id_class");
                String teachername = res.getString("teachername");
                String classname = res.getString("classname");
                listClass.add(new StudentInClass(classid, classname, teachername));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        return listClass;
    }

   
    
}
