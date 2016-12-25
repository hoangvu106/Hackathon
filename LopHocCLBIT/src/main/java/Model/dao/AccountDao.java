/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.dao;

import model.beans.Account;


/**
 *
 * @author DatNguyen
 */
public interface AccountDao {
    boolean checkLogin(String username, String password);
    Account getAccount(String account);

    boolean updateAccount(Account user);

    boolean deleteAccount(Account user);

    boolean insertAccount(Account user);
}
