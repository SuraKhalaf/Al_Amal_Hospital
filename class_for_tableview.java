/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author zaytona
 */
public class class_for_tableview {
  String dr_id,dr_name,dr_number,dr_job,dr_title,med_id,dr_email,dr_pass,dr_salary;

    public class_for_tableview(String dr_id, String dr_name, String dr_number, String dr_job, String dr_title, String med_id, String dr_email, String dr_pass, String dr_salary) {
        this.dr_id = dr_id;
        this.dr_name = dr_name;
        this.dr_number = dr_number;
        this.dr_job = dr_job;
        this.dr_title = dr_title;
        this.med_id = med_id;
        this.dr_email = dr_email;
        this.dr_pass = dr_pass;
        this.dr_salary = dr_salary;
    }

    public void setDr_id(String dr_id) {
        this.dr_id = dr_id;
    }

    public void setDr_name(String dr_name) {
        this.dr_name = dr_name;
    }

    public void setDr_number(String dr_number) {
        this.dr_number = dr_number;
    }

    public void setDr_job(String dr_job) {
        this.dr_job = dr_job;
    }

    public void setDr_title(String dr_title) {
        this.dr_title = dr_title;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public void setDr_email(String dr_email) {
        this.dr_email = dr_email;
    }

    public void setDr_pass(String dr_pass) {
        this.dr_pass = dr_pass;
    }

    public void setDr_salary(String dr_salary) {
        this.dr_salary = dr_salary;
    }

    public String getDr_id() {
        return dr_id;
    }

    public String getDr_name() {
        return dr_name;
    }

    public String getDr_number() {
        return dr_number;
    }

    public String getDr_job() {
        return dr_job;
    }

    public String getDr_title() {
        return dr_title;
    }

    public String getMed_id() {
        return med_id;
    }

    public String getDr_email() {
        return dr_email;
    }

    public String getDr_pass() {
        return dr_pass;
    }

    public String getDr_salary() {
        return dr_salary;
    }

}