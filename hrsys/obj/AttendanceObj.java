/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrsys.obj;

/**
 *
 * @author user
 */
public class AttendanceObj {

    // 従業員コード
    private String employeeCode;

    // 年月
    private String yearMonth;

    // 名前
    private String name;

    //当月出勤日数
    private String monthAttendanceDays;

    //実際出勤日数
    private String actualAttendanceDays;

    //当月勤務時間
    private String monthlyWorkingHours;

    //実際勤務時間
    private String actualWorkingHours;

    //欠勤日数
    private String absentAys;

    //休日出勤日数
    private String holidayWorkDays;

    //休日労働時間
    private String holidayWorkingHours;

    //平日普通残業
    private String weekdayOvertime;

    //深夜残業
    private String lateNightOvertime;

    //遅刻早退
    private String tardinessAndEarlyDeparture;

    //有給残日数
    private String remainingPaidLeaveDays;

    //有給残消化日数
    private String consumedPaidLeaveDays;

    //備考
    private String remarks;

    // 検索
    private String Search;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonthAttendanceDays() {
        return monthAttendanceDays;
    }

    public void setMonthAttendanceDays(String monthAttendanceDays) {
        this.monthAttendanceDays = monthAttendanceDays;
    }

    public String getActualAttendanceDays() {
        return actualAttendanceDays;
    }

    public void setActualAttendanceDays(String actualAttendanceDays) {
        this.actualAttendanceDays = actualAttendanceDays;
    }

    public String getMonthlyWorkingHours() {
        return monthlyWorkingHours;
    }

    public void setMonthlyWorkingHours(String monthlyWorkingHours) {
        this.monthlyWorkingHours = monthlyWorkingHours;
    }

    public String getActualWorkingHours() {
        return actualWorkingHours;
    }

    public void setActualWorkingHours(String actualWorkingHours) {
        this.actualWorkingHours = actualWorkingHours;
    }

    public String getAbsentAys() {
        return absentAys;
    }

    public void setAbsentAys(String absentAys) {
        this.absentAys = absentAys;
    }

    public String getHolidayWorkDays() {
        return holidayWorkDays;
    }

    public void setHolidayWorkDays(String holidayWorkDays) {
        this.holidayWorkDays = holidayWorkDays;
    }

    public String getHolidayWorkingHours() {
        return holidayWorkingHours;
    }

    public void setHolidayWorkingHours(String holidayWorkingHours) {
        this.holidayWorkingHours = holidayWorkingHours;
    }

    public String getWeekdayOvertime() {
        return weekdayOvertime;
    }

    public void setWeekdayOvertime(String weekdayOvertime) {
        this.weekdayOvertime = weekdayOvertime;
    }

    public String getTardinessAndEarlyDeparture() {
        return tardinessAndEarlyDeparture;
    }

    public void setTardinessAndEarlyDeparture(String tardinessAndEarlyDeparture) {
        this.tardinessAndEarlyDeparture = tardinessAndEarlyDeparture;
    }

    public String getRemainingPaidLeaveDays() {
        return remainingPaidLeaveDays;
    }

    public void setRemainingPaidLeaveDays(String remainingPaidLeaveDays) {
        this.remainingPaidLeaveDays = remainingPaidLeaveDays;
    }

    public String getConsumedPaidLeaveDays() {
        return consumedPaidLeaveDays;
    }

    public void setConsumedPaidLeaveDays(String consumedPaidLeaveDays) {
        this.consumedPaidLeaveDays = consumedPaidLeaveDays;
    }

    public String getSearch() {
        return Search;
    }

    public void setSearch(String Search) {
        this.Search = Search;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getLateNightOvertime() {
        return lateNightOvertime;
    }

    public void setLateNightOvertime(String lateNightOvertime) {
        this.lateNightOvertime = lateNightOvertime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
