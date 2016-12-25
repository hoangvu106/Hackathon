/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.dao;

import Model.beans.Member;
import model.beans.Account;

/**
 *
 * @author DatNguyen
 */
public interface MemberDAO {
    Member getInfo(String username);
    
    
}
