/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrsys.dao;

import hrsys.obj.PayslipCreationObj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class PayslipCreationDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    final String jdbcUrl = "jdbc:postgresql://localhost:5432/zhao";
    final String username = "postgres";
    final String password = "postgres";

    public void addPayslipCreation(PayslipCreationObj payslipCreationObj) {

        System.out.println("6666?");

        // 获取当前系统时间
        LocalDateTime currentTime = LocalDateTime.now();

        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. 创建 SQL 语句
            StringBuffer sb = new StringBuffer();
            sb.append("INSERT INTO payslip_creation (employee_code, year_month, month_attendance_days, actual_attendance_days, monthly_working_hours, actual_working_hours, absent_ays, holiday_work_days, holiday_working_hours, weekday_overtime, late_night_overtime, tardiness_and_early_departure, remaining_paid_leave_days, consumed_paid_leave_days, base_salary, position_allowance, qualification_allowance, housing_allowance, family_allowance, commute_allowance, expected_monthly_overtime_allowance, late_night_allowance, holiday_allowance, total_payment_amount, health_insurance, employment_insurance,welfare_pension, Long_Term_Care_Insurance, total_insurance_premiums, withholding_incometax, resident_tax, total_deductions, total_taxes, total_deductible, deletion_flag, creation_date, update_date) VALUES(");

            sb.append("'" + payslipCreationObj.getEmployeeCode() + "',");
            sb.append("'" + payslipCreationObj.getYearMonth() + "',");
            sb.append("'" + payslipCreationObj.getMonthAttendanceDays() + "',");
            sb.append("'" + payslipCreationObj.getActualAttendanceDays() + "',");
            sb.append("'" + payslipCreationObj.getMonthlyWorkingHours() + "',");
            sb.append("'" + payslipCreationObj.getActualWorkingHours() + "',");
            sb.append("'" + payslipCreationObj.getAbsentAys() + "',");
            sb.append("'" + payslipCreationObj.getHolidayWorkDays() + "',");
            sb.append("'" + payslipCreationObj.getHolidayWorkingHours() + "',");
            sb.append("'" + payslipCreationObj.getWeekdayOvertime() + "',");
            sb.append("'" + payslipCreationObj.getLateNightOvertime() + "',");
            sb.append("'" + payslipCreationObj.getTardinessAndEarlyDeparture() + "',");
            sb.append("'" + payslipCreationObj.getRemainingPaidLeaveDays() + "',");
            sb.append("'" + payslipCreationObj.getConsumedPaidLeaveDays() + "',");
            sb.append("'" + payslipCreationObj.getBaseSalary() + "',");
            sb.append("'" + payslipCreationObj.getPositionAllowance() + "',");
            sb.append("'" + payslipCreationObj.getQualificationAllowance() + "',");
            sb.append("'" + payslipCreationObj.getHousingAllowance() + "',");
            sb.append("'" + payslipCreationObj.getFamilyAllowance() + "',");
            sb.append("'" + payslipCreationObj.getCommuteAllowance() + "',");
            sb.append("'" + payslipCreationObj.getExpectedMonthlyOvertimeAllowance() + "',");
            sb.append("'" + payslipCreationObj.getLateNightAllowance() + "',");
            sb.append("'" + payslipCreationObj.getHolidayAllowance() + "',");
            sb.append("'" + payslipCreationObj.getTotalPaymentAmount() + "',");
            sb.append("'" + payslipCreationObj.getHealthInsurance() + "',");
            sb.append("'" + payslipCreationObj.getEmploymentInsurance() + "',");
            sb.append("'" + payslipCreationObj.getWelfarePension() + "',");
            sb.append("'" + payslipCreationObj.getLongTermCareInsurance() + "',");
            sb.append("'" + payslipCreationObj.getTotalInsurancePremiums() + "',");
            sb.append("'" + payslipCreationObj.getWithholdingIncomeTax() + "',");
            sb.append("'" + payslipCreationObj.getResidentTax() + "',");
            sb.append("'" + payslipCreationObj.getTotalDeductions() + "',");
            sb.append("'" + payslipCreationObj.getTotalTaxes() + "',");
            sb.append("'" + payslipCreationObj.getTotalDeductible() + "',");
            sb.append("'" + 0 + "',");
            sb.append("'" + currentTime + "',");
            sb.append("'" + currentTime + "');");

            System.out.println(sb.toString());

            // 4. 创建 Statement 对象
            Statement statement = connection.createStatement();

            // 5. 执行查询并获取结果集
            statement.executeUpdate(sb.toString());

            // 7. 关闭资源
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<PayslipCreationObj> setPayslipCreationList() throws SQLException {

        System.out.println("aaaaa");

        List<PayslipCreationObj> list = new ArrayList<PayslipCreationObj>();

        String jdbcUrl = "jdbc:postgresql://localhost:5432/zhao";
        String username = "postgres";
        String password = "postgres";

        try {
            // 1. 注册 PostgreSQL 驱动程序
            Class.forName("org.postgresql.Driver");
            // 2. 建立数据库连接
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. 创建 SQL 语句
            String sql = "INSERT INTO payslip_creation("
                    + "month_attendance_days, actual_attendance_days, monthly_working_hours, actual_working_hours, "
                    + "absent_ays, holiday_work_days, holiday_working_hours, weekday_overtime, late_night_overtime, "
                    + "tardiness_and_early_departure, remaining_paid_leave_days, consumed_paid_leave_days, base_salary, "
                    + "position_allowance, qualification_allowance, housing_allowance, family_allowance, commute_allowance, "
                    + "expected_monthly_overtime_allowance, late_night_allowance, holiday_allowance, total_payment_amount, "
                    + "health_insurance, employment_insurance, welfare_pension, long_term_care_insurance, "
                    + "total_insurance_premiums, withholding_incometax, resident_tax, total_deductions, total_taxes, "
                    + "total_deductible, deletion_flag, creation_date, update_date) "
                    + "SELECT a.month_attendance_days, a.actual_attendance_days, a.monthly_working_hours, "
                    + "a.actual_working_hours, a.absent_ays, a.holiday_work_days, a.holiday_working_hours, "
                    + "a.weekday_overtime, a.late_night_overtime, a.tardiness_and_early_departure, "
                    + "a.remaining_paid_leave_days, a.consumed_paid_leave_days, s.base_salary, s.position_allowance, "
                    + "s.qualification_allowance, s.housing_allowance, s.family_allowance, s.commute_allowance, "
                    + "s.expected_monthly_overtime_allowance, s.late_night_allowance, s.holiday_allowance, "
                    + "s.total_payment_amount, s.health_insurance, s.employment_insurance, s.welfare_pension, "
                    + "s.long_term_care_insurance, s.total_insurance_premiums, s.withholding_incometax, s.resident_tax, "
                    + "s.total_deductions, s.total_taxes, s.total_deductible, s.deletion_flag, s.creation_date, "
                    + "s.update_date "
                    + "FROM employee_info e "
                    + "INNER JOIN attendance a ON e.employee_code = a.employee_code "
                    + "INNER JOIN salary_calculation s ON a.employee_code = s.employee_code "
                    + "WHERE a.deletion_flag = '0' AND e.deletion_flag = '0' AND s.deletion_flag = '0'";

            // 4. 创建 Statement 对象
            Statement statement = connection.createStatement();

            // 5. 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery(sql);

            // 6. 处理结果集
            while (resultSet.next()) {
                String employeeCode = resultSet.getString("employee_code");
                String name = resultSet.getString("name");

                PayslipCreationObj obj = new PayslipCreationObj();
                obj.setEmployeeCode(employeeCode);
                obj.setName(name);
                list.add(obj);

            }

            // 7. 关闭资源
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public PayslipCreationObj getPayslipCreation(String emCode, String yMonth) {

        System.out.println("6666?");
        PayslipCreationObj obj = new PayslipCreationObj();

        String jdbcUrl = "jdbc:postgresql://localhost:5432/zhao";
        String username = "postgres";
        String password = "postgres";

        try {
            // 1. 注册 PostgreSQL 驱动程序
            Class.forName("org.postgresql.Driver");
            // 2. 建立数据库连接
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. 创建 SQL 语句
//            String sql = "select * from PayslipCreation where employee_code = '" + emCode + "'" + "and year_month = " + "'" + yMonth + "';";
            String sql = "SELECT "
                    + "e.employee_code, "
                    + "e.name, "
                    + "s.year_month, "
                    + "a.month_attendance_days, "
                    + "a.actual_attendance_days, "
                    + "a.monthly_working_hours, "
                    + "a.actual_working_hours, "
                    + " a.absent_ays, "
                    + "a.holiday_work_days, "
                    + "a.holiday_working_hours, "
                    + "a.weekday_overtime, "
                    + "a.late_night_overtime, "
                    + "a.tardiness_and_early_departure, "
                    + "a.remaining_paid_leave_days, "
                    + "a.consumed_paid_leave_days, "
                    + "s.base_salary, "
                    + "s.position_allowance, "
                    + "s.qualification_allowance, "
                    + "s.housing_allowance, "
                    + "s.family_allowance, "
                    + "s.commute_allowance, "
                    + "s.expected_monthly_overtime_allowance, "
                    + "s.late_night_allowance, "
                    + "s.holiday_allowance, "
                    + "s.total_payment_amount, "
                    + "s.health_insurance, "
                    + "s.employment_insurance, "
                    + "s.welfare_pension, "
                    + "s.long_term_care_insurance, "
                    + "s.total_insurance_premiums, "
                    + "s.withholding_incometax, "
                    + "s.resident_tax, "
                    + "s.total_deductions, "
                    + "s.total_taxes, "
                    + "s.total_deductible, "
                    + "s.deletion_flag, "
                    + "s.creation_date, "
                    + "s.update_date "
                    + "FROM "
                    + "employee_info e "
                    + "INNER JOIN attendance a ON e.employee_code = a.employee_code "
                    + "INNER JOIN salary_calculation s ON a.employee_code = s.employee_code "
                    + "WHERE "
                    + "e.employee_code = '"
                    + emCode
                    + "'"
                    + "AND s.year_month = '"
                    + yMonth
                    + "'"
                    + "AND a.deletion_flag = '0' "
                    + "AND e.deletion_flag = '0' "
                    + "AND s.deletion_flag = '0'";

            System.out.println("emCode: " + emCode);
            System.out.println("yearMonth: " + yMonth);
            System.out.println("SQL" + sql);
            // 4. 创建 Statement 对象
            Statement statement = connection.createStatement();

            System.out.println(sql);
            // 5. 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery(sql);

            // 6. 处理结果集
            while (resultSet.next()) {
                String employeeCode = resultSet.getString("employee_code");
                String name = resultSet.getString("name");
                String monthAttendanceDays = resultSet.getString("month_attendance_days");
                String actualAttendanceDays = resultSet.getString("actual_attendance_days");
                String monthlyWorkingHours = resultSet.getString("monthly_working_hours");
                String actualWorkingHours = resultSet.getString("actual_working_hours");
                String absentAys = resultSet.getString("absent_ays");
                String holidayWorkDays = resultSet.getString("holiday_work_days");
                String holidayWorkingHours = resultSet.getString("holiday_working_hours");
                String weekdayOvertime = resultSet.getString("weekday_overtime");
                String lateNightOvertime = resultSet.getString("late_night_overtime");
                String tardinessAndEarlyDeparture = resultSet.getString("tardiness_and_early_departure");
                String remainingPaidLeaveDays = resultSet.getString("remaining_paid_leave_days");
                String consumedPaidLeaveDays = resultSet.getString("consumed_paid_leave_days");
                Double baseSalary = resultSet.getDouble("Base_Salary");
                Double positionAllowance = resultSet.getDouble("Position_Allowance");
                Double qualificationAllowance = resultSet.getDouble("Qualification_Allowance");
                Double housingAllowance = resultSet.getDouble("Housing_Allowance");
                Double familyAllowance = resultSet.getDouble("Family_Allowance");
                Double commuteAllowance = resultSet.getDouble("Commute_Allowance");
                Double expectedMonthlyOvertimeAllowance = resultSet.getDouble("Expected_Monthly_Overtime_Allowance");
                Double lateNightAllowance = resultSet.getDouble("Late_Night_Allowance");
                Double holidayAllowance = resultSet.getDouble("Holiday_Allowance");
                Double totalPaymentAmount = resultSet.getDouble("Total_Payment_Amount");
                Double healthInsurance = resultSet.getDouble("Health_Insurance");
                Double employmentInsurance = resultSet.getDouble("Employment_Insurance");
                Double welfarePension = resultSet.getDouble("Welfare_Pension");
                Double longTermCareInsurance = resultSet.getDouble("Long_Term_Care_Insurance");
                Double totalInsurancePremiums = resultSet.getDouble("Total_Insurance_Premiums");
                Double withholdingIncomeTax = resultSet.getDouble("Withholding_IncomeTax");
                Double residentTax = resultSet.getDouble("Resident_Tax");
                Double totalDeductions = resultSet.getDouble("Total_Deductions");
                Double totalTaxes = resultSet.getDouble("Total_Taxes");
                Double totalDeductible = resultSet.getDouble("Total_deductible");
                String yearMonth = resultSet.getString("year_month");

                obj.setEmployeeCode(employeeCode);
                obj.setName(name);
                obj.setMonthAttendanceDays(monthAttendanceDays);
                obj.setActualAttendanceDays(actualAttendanceDays);
                obj.setMonthlyWorkingHours(monthlyWorkingHours);
                obj.setActualWorkingHours(actualWorkingHours);
                obj.setAbsentAys(absentAys);
                obj.setHolidayWorkDays(holidayWorkDays);
                obj.setHolidayWorkingHours(holidayWorkingHours);
                obj.setWeekdayOvertime(weekdayOvertime);
                obj.setLateNightOvertime(lateNightOvertime);
                obj.setTardinessAndEarlyDeparture(tardinessAndEarlyDeparture);
                obj.setRemainingPaidLeaveDays(remainingPaidLeaveDays);
                obj.setConsumedPaidLeaveDays(consumedPaidLeaveDays);
                obj.setBaseSalary(baseSalary);
                obj.setPositionAllowance(positionAllowance);
                obj.setQualificationAllowance(qualificationAllowance);
                obj.setHousingAllowance(housingAllowance);
                obj.setFamilyAllowance(familyAllowance);
                obj.setCommuteAllowance(commuteAllowance);
                obj.setExpectedMonthlyOvertimeAllowance(expectedMonthlyOvertimeAllowance);
                obj.setLateNightAllowance(lateNightAllowance);
                obj.setHolidayAllowance(holidayAllowance);
                obj.setTotalPaymentAmount(totalPaymentAmount);
                obj.setHealthInsurance(healthInsurance);
                obj.setEmploymentInsurance(employmentInsurance);
                obj.setWelfarePension(welfarePension);
                obj.setLongTermCareInsurance(longTermCareInsurance);
                obj.setTotalInsurancePremiums(totalInsurancePremiums);
                obj.setWithholdingIncomeTax(withholdingIncomeTax);
                obj.setResidentTax(residentTax);
                obj.setTotalDeductions(totalDeductions);
                obj.setTotalTaxes(totalTaxes);
                obj.setTotalDeductible(totalDeductible);
                obj.setYearMonth(yearMonth);

            }

            // 7. 关闭资源
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }

}
