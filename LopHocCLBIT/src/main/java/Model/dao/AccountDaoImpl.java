/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.beans.Account;



/**
 *
 * @author DatNguyen
 */
public class AccountDaoImpl implements AccountDao {
    Connection conn;
    
    
    

    public AccountDaoImpl() {
        conn =  ConnectionUtil.getConnection();
    }

    @Override
    public boolean checkLogin(String account, String password) {
        
        String s1 = "select * from account";
        try{
            Statement stm = conn.createStatement();
            ResultSet rs =  stm.executeQuery(s1);
            while(rs.next()){
                String name = rs.getString("username");
                String pass = rs.getString("password");
                if(name.equals(account) && pass.equals(password)){
                    return true;
                }
            }
            
        }catch(Exception e){
            
        } 
        return false;
    }

    @Override
    public Account getAccount(String account) {
        String sql = "SELECT id, name, account, password FROM user WHERE account = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, account);

            ResultSet rs = pstm.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String password = rs.getString("password");
            return new Account(name, password);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateAccount(Account account) {
        String sql = "UPDATE account SET username = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, account.getUserName());
            pstm.setString(2, account.getPassWord());
            pstm.setString(3, account.getId());

            pstm.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAccount(Account account) {
        String sql = "DELETE account WHERE id = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, account.getId());

            pstm.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insertAccount(Account user) {
        String sql = "INSERT INTO user(id, username, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getId());
            pstm.setString(2, user.getUserName());
            pstm.setString(3, user.getPassWord());

            pstm.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    


   
}
