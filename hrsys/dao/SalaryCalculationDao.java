/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrsys.dao;

import hrsys.obj.SalaryCalculationObj;
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
public class SalaryCalculationDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    final String jdbcUrl = "jdbc:postgresql://localhost:5432/zhao";
    final String username = "postgres";
    final String password = "postgres";

    public void addSalaryCalculation(SalaryCalculationObj salaryCalculationObj) throws SQLException {

        LocalDateTime currentTime = LocalDateTime.now();

        try {
            // 2. 建立数据库连接
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            StringBuffer sb = new StringBuffer();
            sb.append("INSERT INTO Salary_Calculation (employee_code, year_month, base_salary, position_allowance, qualification_allowance, housing_allowance, family_allowance, commute_allowance, expected_monthly_overtime_allowance, late_night_allowance, holiday_allowance, total_payment_amount, health_insurance, employment_insurance,welfare_pension, Long_Term_Care_Insurance, total_insurance_premiums, withholding_incometax, resident_tax, total_deductions, total_taxes, total_deductible, deletion_flag, creation_date, update_date) VALUES(");

            sb.append("'" + salaryCalculationObj.getEmployeeCode() + "',");
            sb.append("'" + salaryCalculationObj.getYearMonth() + "',");
            sb.append("'" + salaryCalculationObj.getBaseSalary() + "',");
            sb.append("'" + salaryCalculationObj.getPositionAllowance() + "',");
            sb.append("'" + salaryCalculationObj.getQualificationAllowance() + "',");
            sb.append("'" + salaryCalculationObj.getHousingAllowance() + "',");
            sb.append("'" + salaryCalculationObj.getFamilyAllowance() + "',");
            sb.append("'" + salaryCalculationObj.getCommuteAllowance() + "',");
            sb.append("'" + salaryCalculationObj.getExpectedMonthlyOvertimeAllowance() + "',");
            sb.append("'" + salaryCalculationObj.getLateNightAllowance() + "',");
            sb.append("'" + salaryCalculationObj.getHolidayAllowance() + "',");
            sb.append("'" + salaryCalculationObj.getTotalPaymentAmount() + "',");
            sb.append("'" + salaryCalculationObj.getHealthInsurance() + "',");
            sb.append("'" + salaryCalculationObj.getEmploymentInsurance() + "',");
            sb.append("'" + salaryCalculationObj.getWelfarePension() + "',");
            sb.append("'" + salaryCalculationObj.getLongTermCareInsurance() + "',");
            sb.append("'" + salaryCalculationObj.getTotalInsurancePremiums() + "',");
            sb.append("'" + salaryCalculationObj.getWithholdingIncomeTax() + "',");
            sb.append("'" + salaryCalculationObj.getResidentTax() + "',");
            sb.append("'" + salaryCalculationObj.getTotalDeductions() + "',");
            sb.append("'" + salaryCalculationObj.getTotalTaxes() + "',");
            sb.append("'" + salaryCalculationObj.getTotalDeductible() + "',");
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

        } catch (SQLException ex) {
            Logger.getLogger(ConnJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<SalaryCalculationObj> setSalaryCalculationList() throws SQLException {

        System.out.println("dddd");

        List<SalaryCalculationObj> list = new ArrayList<SalaryCalculationObj>();

        try {
            // 2. 建立数据库连接
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 3. 创建 SQL 语句
            String sql = "SELECT * FROM Salary_Calculation WHERE Deletion_Flag = '0'";

            // 4. 创建 Statement 对象
            Statement statement = connection.createStatement();

            // 5. 执行查询并获取结果集
            ResultSet resultSet = statement.executeQuery(sql);

            // 6. 处理结果集
            while (resultSet.next()) {
                String employeeCode = resultSet.getString("employee_code");

                SalaryCalculationObj obj = new SalaryCalculationObj();
                obj.setEmployeeCode(employeeCode);
                list.add(obj);

            }

            // 7. 关闭资源
            resultSet.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public SalaryCalculationObj getSalaryCalculation(String emCode, String yMonth) {

        System.out.println("6666?");
        SalaryCalculationObj obj = new SalaryCalculationObj();

        try {
            // 2. 建立数据库连接
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String sql = "SELECT "
                    + "e.employee_code, "
                    + "e.name, "
                    + "s.year_month, "
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
                    + "INNER JOIN salary_calculation s ON e.employee_code = s.employee_code "
                    + "WHERE "
                    + "e.employee_code = '"
                    + emCode
                    + "'"
                    + "AND s.year_month = '"
                    + yMonth
                    + "'"
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

        } catch (SQLException ex) {
            Logger.getLogger(ConnJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }

    public void updateSalaryCalculation(SalaryCalculationObj salaryCalculationObj) {

        System.out.println("5555?");

        LocalDateTime currentTime = LocalDateTime.now();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            StringBuffer sb = new StringBuffer();
            sb.append("UPDATE Salary_Calculation SET ");

            sb.append("base_salary = '" + salaryCalculationObj.getBaseSalary() + "',");
            sb.append("position_allowance = '" + salaryCalculationObj.getPositionAllowance() + "',");
            sb.append("qualification_allowance = '" + salaryCalculationObj.getQualificationAllowance() + "',");
            sb.append("housing_allowance = '" + salaryCalculationObj.getHousingAllowance() + "',");
            sb.append("family_allowance = '" + salaryCalculationObj.getFamilyAllowance() + "',");
            sb.append("commute_allowance = '" + salaryCalculationObj.getCommuteAllowance() + "',");
            sb.append("expected_monthly_overtime_allowance = '" + salaryCalculationObj.getExpectedMonthlyOvertimeAllowance() + "',");
            sb.append("late_night_allowance = '" + salaryCalculationObj.getLateNightAllowance() + "',");
            sb.append("holiday_allowance = '" + salaryCalculationObj.getHolidayAllowance() + "',");
            sb.append("total_payment_amount = '" + salaryCalculationObj.getTotalPaymentAmount() + "',");
            sb.append("health_insurance = '" + salaryCalculationObj.getHealthInsurance() + "',");
            sb.append("employment_insurance = '" + salaryCalculationObj.getEmploymentInsurance() + "',");
            sb.append("welfare_pension = '" + salaryCalculationObj.getWelfarePension() + "',");
            sb.append("long_term_care_insurance = '" + salaryCalculationObj.getLongTermCareInsurance() + "',");
            sb.append("total_insurance_premiums = '" + salaryCalculationObj.getTotalInsurancePremiums() + "',");
            sb.append("withholding_incometax = '" + salaryCalculationObj.getWithholdingIncomeTax() + "',");
            sb.append("resident_tax = '" + salaryCalculationObj.getResidentTax() + "',");
            sb.append("total_deductions = '" + salaryCalculationObj.getTotalDeductions() + "',");
            sb.append("total_taxes = '" + salaryCalculationObj.getTotalTaxes() + "',");
            sb.append("total_deductible = '" + salaryCalculationObj.getTotalDeductible() + "'");
            sb.append("WHERE employee_code = '" + salaryCalculationObj.getEmployeeCode() + "'");
            sb.append("AND year_month = '" + salaryCalculationObj.getYearMonth() + "'");

            System.out.println(sb.toString());

            // 4. 创建 Statement 对象
            Statement statement = connection.createStatement();

            // 5. 执行查询并获取结果集
            statement.executeUpdate(sb.toString());

            // 7. 关闭资源
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
