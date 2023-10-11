/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrsys.service;

import hrsys.dao.EmployeeInfoDao;
import hrsys.obj.EmployeeObj;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class EmployeeInfoService {

    public void addEmployeeInfo(EmployeeObj employeeObj) {

        EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();

        employeeInfoDao.addEmployeeInfo(employeeObj);

    }

    public void setEmployeeInfo(EmployeeObj employeeObj) throws SQLException {

        EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();

        employeeInfoDao.setEmployeeList();

    }

    public List<EmployeeObj> getEmployeeInfoList() {

        EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();

        List<EmployeeObj> employeeObjList = employeeInfoDao.getEmployeeInfoList();

        return employeeObjList;
    }

    public EmployeeObj getEmployeeInfo(String emCode) {

        EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();

        EmployeeObj employeeObj = employeeInfoDao.getEmployeeInfo(emCode);

        return employeeObj;
    }

    /**
     * 従業員情報編集
     *
     * @param employeeObj
     */
    public void updateEmployeeInfo(EmployeeObj employeeObj) {

        EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();

        employeeInfoDao.updateEmployeeInfo(employeeObj);

    }

     public void deleteEmployeeInfo(String employeeCode) {

        EmployeeInfoDao employeeInfoDao = new EmployeeInfoDao();

        employeeInfoDao.deleteEmployeeInfo(employeeCode);
    }
}
