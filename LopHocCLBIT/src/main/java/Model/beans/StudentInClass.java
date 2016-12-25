/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.beans;

/**
 *
 * @author DatNguyen
 */
public class StudentInClass {
    private String id_student;
    private String id_class;
    private String studentname;
    private String classname;
    private String teachername;
    private String id_teacher;

    public StudentInClass(String id_class, String classname, String id_teacher) {
        this.id_class = id_class;
        this.classname = classname;
        this.id_teacher = id_teacher;
    }

   
    
    public StudentInClass() {
    }

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public String getId_class() {
        return id_class;
    }

    public void setId_class(String id_class) {
        this.id_class = id_class;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(String id_teacher) {
        this.id_teacher = id_teacher;
    }
    
}
