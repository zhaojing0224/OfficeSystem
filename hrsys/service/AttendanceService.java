/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrsys.service;

import hrsys.dao.AttendanceDao;
import hrsys.obj.AttendanceObj;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class AttendanceService {

    public void addAttendance(AttendanceObj attendanceObj) throws SQLException {

        AttendanceDao attendanceDao = new AttendanceDao();
        attendanceDao.addAttendance(attendanceObj);

    }

    public void setAttendance(AttendanceObj attendanceObj) throws SQLException {

        AttendanceDao attendanceDao = new AttendanceDao();

        attendanceDao.setAttendanceList();

    }

    public List<AttendanceObj> getAttendanceList() {

        AttendanceDao attendanceDao = new AttendanceDao();

        List<AttendanceObj> attendanceObjList = attendanceDao.getAttendanceList();

        return attendanceObjList;
    }

    public AttendanceObj getAttendance(String emCode, String yMonth) {

        AttendanceDao attendanceDao = new AttendanceDao();

        AttendanceObj attendanceObj = attendanceDao.getAttendance(emCode, yMonth);

        return attendanceObj;
    }

    public void updateAttendance(AttendanceObj attendanceObj) {

        AttendanceDao attendanceDao = new AttendanceDao();

        attendanceDao.updateAttendance(attendanceObj);

    }

}
