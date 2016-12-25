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
        String sql = "select x.name as studentname, y.name  as teachername, class.name as classname\n" +
"                from account, member as x, member as y, studentinclass, class\n" +
"                where account.username = ?" +
"                and studentinclass.id_student = account.id\n" +
"                and studentinclass.id_student = x.id\n" +
"                and studentinclass.id_class = class.id_class\n" +
"                and class.id_teacher = y.id";
                
                
        String id = "";
        ArrayList<StudentInClass> listClass = new ArrayList<StudentInClass>();
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            ResultSet res = pstm.executeQuery();
            System.out.println(res);
            while(res.next()){
                String studentname = res.getString("studentname");
                String teachername = res.getString("teachername");
                String classname = res.getString("classname");
                System.out.println(studentname);
                listClass.add(new StudentInClass(studentname, classname, teachername));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        return listClass;
    }

   
    
}
