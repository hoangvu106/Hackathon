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
        String sql = "select x.name as studentname, y.name  as teachername, clas.name as nameclass "
                + "from account, member as x, member as y, studentinclass, clas"
                + "where account.username = ?"
                + "and studentinclass.id_student = account.id "
                + "and studentinclass.id_student = x.id"
                + "and studentinclass.id_class = clas.id_class"
                + "and clas.id_teacher = y.id";
                
                
        String id = "";
        ArrayList<StudentInClass> listClass = new ArrayList<StudentInClass>();
        
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            ResultSet res = pstm.getResultSet();
            while(res.next()){
                String studentname = res.getString("studentnam");
                String teachername = res.getString("teachername");
                String classname = res.getString("classname");
                listClass.add(new StudentInClass(studentname, classname, teachername));
            }

            pstm.execute();
        } catch (Exception e) {
        }
        
        
        
        return listClass;
    }

   
    
}
