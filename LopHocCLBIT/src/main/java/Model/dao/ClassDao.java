/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.dao;

import Model.beans.StudentInClass;
import java.util.ArrayList;

/**
 *
 * @author DatNguyen
 */
public interface ClassDao {
    ArrayList<StudentInClass> getListClass(String username);
}
