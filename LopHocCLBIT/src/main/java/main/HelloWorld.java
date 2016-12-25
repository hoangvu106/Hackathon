/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Model.dao.AccountDao;
import Model.dao.AccountDaoImpl;
import model.beans.Account;
import static spark.Spark.*;

public class HelloWorld {

    public static void main(String[] args) {
        post("/login", (request, response) -> {

            String username = request.queryParams("account");
            String password = request.queryParams("password");
            Account account = new Account(username, password);
            response.type("application/json");
            AccountDao m = new AccountDaoImpl();
            if (m.checkLogin(username, password)) {
                return "{\"code\":1}";
            } else {
                return "{\"code\":0}";
            }
        });
    }
}
