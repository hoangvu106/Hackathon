/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main_dat;

import Model.beans.StudentInClass;
import Model.dao.ClassDao;
import Model.dao.ClassDaoImpl;
import Model.dao.ConnectionUtil;
import Model.dao.MemberDAO;
import Model.dao.MemberDAOImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DatNguyen
 */
public class main {
    public static void main(String[] args) {
        ClassDaoImpl c = new ClassDaoImpl();
        ArrayList<StudentInClass> list = c.getListClass("nguyenvana");
        for(StudentInClass s: list){
            System.out.println(s.getId_class());
            System.out.println(s.getClassname());
            System.out.println(s.getTeachername());
        }
        MemberDAOImpl m = new MemberDAOImpl();
        
    }
}
