/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrsys.service;

import hrsys.dao.PayslipCreationDao;
import hrsys.obj.PayslipCreationObj;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class PayslipCreationService {

    public void addPayslipCreation(PayslipCreationObj payslipCreationObj) {

        PayslipCreationDao payslipCreationDao = new PayslipCreationDao();

        payslipCreationDao.addPayslipCreation(payslipCreationObj);

    }

    public void setPayslipCreation(PayslipCreationObj payslipCreationObj) throws SQLException {

        PayslipCreationDao payslipCreationDao = new PayslipCreationDao();

        payslipCreationDao.setPayslipCreationList();

    }

    public PayslipCreationObj getPayslipCreation(String emCode, String yMonth) {

        PayslipCreationDao payslipCreationDao = new PayslipCreationDao();

        PayslipCreationObj payslipCreationObj = payslipCreationDao.getPayslipCreation(emCode, yMonth);

        return payslipCreationObj;
    }

}
