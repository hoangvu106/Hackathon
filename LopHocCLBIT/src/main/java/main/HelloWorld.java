/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Model.beans.Member;
import Model.beans.StudentInClass;
import Model.dao.AccountDao;
import Model.dao.AccountDaoImpl;
import Model.dao.ClassDao;
import Model.dao.ClassDaoImpl;
import Model.dao.MemberDAOImpl;
import java.util.ArrayList;
import model.beans.Account;
import static spark.Spark.*;

public class HelloWorld {

    public static void main(String[] args) {
        post("/login", (request, response) -> {
            String username = request.queryParams("username");
            String password = request.queryParams("password");
            Account account = new Account(username, password);
            response.type("application/json");
            System.out.println(username + " " + password);
            AccountDao m = new AccountDaoImpl();
            if (m.checkLogin(username, password)) {
                return "{\"code\":1}";
            } 
                return "{\"code\":0}";
        });
        post("/get-list-class", (request, response) -> {

            String username = request.queryParams("username");
            StringBuffer json = new StringBuffer();
            response.type("application/json");
            ClassDao c = new ClassDaoImpl();
            ArrayList<StudentInClass> arrayList = new ArrayList<>();
            System.out.println(username );
            arrayList = c.getListClass(username);
            AccountDao m = new AccountDaoImpl();
            String result = "[";
            System.out.println(arrayList.size());
            for(int i=0;i<arrayList.size();i++){
                System.out.println( arrayList.get(i).getId_class()+" "+arrayList.get(i).getClassname()+" "+arrayList.get(i).getTeachername());
                
            } 
            for(int i=0;i<arrayList.size();i++){
                result+=String.format("{\"id_class\": %s ,\"name_class\": %s ,\"name_techer\": %s}", arrayList.get(i).getId_class(),arrayList.get(i).getClassname(),arrayList.get(i).getTeachername());
                if(i<arrayList.size()-1) result+=",";
            }   
            result+="]";
            System.out.println(result);
            return result;
        });
        post("/get-info", (request, response) -> {
            String username = request.queryParams("username");
            Member mem = new Member(username, username, username);
            MemberDAOImpl memt = new MemberDAOImpl();
            mem = memt.getInfo(username);
            response.type("application/json");
            System.out.println(username );
            System.out.println( mem.getId()+" "+mem.getName()+" "+mem.getGrade());
            String s ="";
            s+=String.format("{\"id\": %s,\"name\": %s,\"grade\": %s }", mem.getId(),mem.getName(),mem.getGrade());
            System.out.println(s);
                return s;
        });
    }
}
