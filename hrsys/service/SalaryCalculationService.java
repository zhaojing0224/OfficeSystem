/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrsys.service;

import hrsys.dao.SalaryCalculationDao;
import hrsys.obj.SalaryCalculationObj;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class SalaryCalculationService {

    public void addSalaryCalculation(SalaryCalculationObj salaryCalculationObj) throws SQLException {

        SalaryCalculationDao salaryCalculationDao = new SalaryCalculationDao();
        salaryCalculationDao.addSalaryCalculation(salaryCalculationObj);

    }

    public void setSalaryCalculation(SalaryCalculationObj salaryCalculationObj) throws SQLException {

        SalaryCalculationDao salaryCalculationDao = new SalaryCalculationDao();

        salaryCalculationDao.setSalaryCalculationList();

    }

    public SalaryCalculationObj getSalaryCalculation(String emCode, String yMonth) {

        SalaryCalculationDao salaryCalculationDao = new SalaryCalculationDao();

        SalaryCalculationObj salaryCalculationObj = salaryCalculationDao.getSalaryCalculation(emCode, yMonth);

        return salaryCalculationObj;
    }

    public void updateSalaryCalculation(SalaryCalculationObj salaryCalculationObj) {

        SalaryCalculationDao salaryCalculationDao = new SalaryCalculationDao();

        salaryCalculationDao.updateSalaryCalculation(salaryCalculationObj);

    }

}
