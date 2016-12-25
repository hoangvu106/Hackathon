/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.dao;

import Model.beans.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.beans.Account;

/**
 *
 * @author DatNguyen
 */
public class MemberDAOImpl implements MemberDAO{
    Connection conn;

    public MemberDAOImpl() {
        conn = ConnectionUtil.getConnection();
    }
    
    @Override
    public Member getInfo(String username) {
        String name = "";
        String id = "";
        String grade = "";
        String sql = "select member.* from member, account"
                + "where account.id = member.id"
                + "and account.username = '" + username +"'";        
        try {
            Statement stm = conn.prepareStatement(sql);
            ResultSet res = stm.getResultSet();
            name = res.getString("name");
            id = res.getString("id");
            grade = res.getString("grade");
        } catch (Exception e) {
        }
        return new Member(id, name, grade);
    }
    
}
