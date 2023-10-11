/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrsys.dao;

import hrsys.obj.EmployeeObj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class EmployeeInfoDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    final String jdbcUrl = "jdbc:postgresql://localhost:5432/zhao";
    final String username = "postgres";
    final String password = "postgres";

    public void addEmployeeInfo(EmployeeObj employeeObj) {

        LocalDateTime currentTime = LocalDateTime.now();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            StringBuffer sb = new StringBuffer();
            sb.append("INSERT INTO Employee_Info (employee_code, name, katakana, gender, birth, phone_number, email, date_of_joining, date_of_resignation, postal_code, address, nationality, contract_type, salary_type, job_title, health_insurance_number, labor_insurance_number, residence_card_number, period_of_stay, residence_status, deletion_flag, creation_date, update_date) VALUES(");

            sb.append("'" + employeeObj.getEmployeeCode() + "',");
            sb.append("'" + employeeObj.getName() + "',");
            sb.append("'" + employeeObj.getKatakana() + "',");
            sb.append("'" + employeeObj.getGender() + "',");
            sb.append("'" + employeeObj.getBirth() + "',");
            sb.append("'" + employeeObj.getPhoneNumber() + "',");
            sb.append("'" + employeeObj.getEmail() + "',");
            sb.append("'" + employeeObj.getDateOfJoining() + "',");
            sb.append("'" + employeeObj.getDateOfResignation() + "',");
            sb.append("'" + employeeObj.getPostalCode() + "',");
            sb.append("'" + employeeObj.getAddress() + "',");
            sb.append("'" + employeeObj.getNationality() + "',");
            sb.append("'" + employeeObj.getContractType() + "',");
            sb.append("'" + employeeObj.getSalaryType() + "',");
            sb.append("'" + employeeObj.getJobTitle() + "',");
            sb.append("'" + employeeObj.getHealthInsuranceNumber() + "',");
            sb.append("'" + employeeObj.getLaborInsuranceNumber() + "',");
            sb.append("'" + employeeObj.getResidenceCardNumber() + "',");
            sb.append("'" + employeeObj.getPeriodOfStay() + "',");
            sb.append("'" + employeeObj.getResidenceStatus() + "',");
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

    /**
     * 従業員情報編集
     *
     * @return
     */
    public void updateEmployeeInfo(EmployeeObj employeeObj) {

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            StringBuffer sb = new StringBuffer();

            sb.append("UPDATE Employee_Info SET ");
            sb.append("name = '" + employeeObj.getName() + "', ");
            sb.append("katakana = '" + employeeObj.getKatakana() + "', ");
            sb.append("gender = '" + employeeObj.getGender() + "', ");
            sb.append("birth = '" + employeeObj.getBirth() + "', ");
            sb.append("phone_number = '" + employeeObj.getPhoneNumber() + "', ");
            sb.append("email = '" + employeeObj.getEmail() + "', ");
            sb.append("date_of_joining = '" + employeeObj.getDateOfJoining() + "', ");
            sb.append("date_of_resignation = '" + employeeObj.getDateOfResignation() + "', ");
            sb.append("postal_code = '" + employeeObj.getPostalCode() + "', ");
            sb.append("address = '" + employeeObj.getAddress() + "', ");
            sb.append("nationality = '" + employeeObj.getNationality() + "', ");
            sb.append("contract_type = '" + employeeObj.getContractType() + "', ");
            sb.append("salary_type = '" + employeeObj.getSalaryType() + "', ");
            sb.append("job_title = '" + employeeObj.getJobTitle() + "', ");
            sb.append("health_insurance_number = '" + employeeObj.getHealthInsuranceNumber() + "', ");
            sb.append("labor_insurance_number = '" + employeeObj.getLaborInsuranceNumber() + "', ");
            sb.append("residence_card_number = '" + employeeObj.getResidenceCardNumber() + "', ");
            sb.append("period_of_stay = '" + employeeObj.getPeriodOfStay() + "', ");
            sb.append("residence_status = '" + employeeObj.getResidenceStatus() + "' ");
            sb.append("WHERE employee_code = '" + employeeObj.getEmployeeCode() + "'");

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

    public List<EmployeeObj> getEmployeeInfoList() {

        List<EmployeeObj> list = new ArrayList<EmployeeObj>();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String sql = "select * from Employee_Info WHERE Deletion_Flag = '0';";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // 6. 处理结果集
            while (resultSet.next()) {
                String employeeCode = resultSet.getString("employee_code");
                String name = resultSet.getString("name");
                String katakana = resultSet.getString("katakana");
                String birth = resultSet.getString("birth");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String dateOfJoining = resultSet.getString("date_of_joining");
                String dateOfResignation = resultSet.getString("date_of_resignation");
                String postalCode = resultSet.getString("postal_code");
                String address = resultSet.getString("address");
                String nationality = resultSet.getString("nationality");
                String contractType = resultSet.getString("contract_type");
                String salaryType = resultSet.getString("salary_type");
                String jobTitle = resultSet.getString("job_title");
                String healthInsuranceNumber = resultSet.getString("health_insurance_number");
                String laborInsuranceNumber = resultSet.getString("labor_insurance_number");
                String residenceCardNumber = resultSet.getString("residence_card_number");
                String periodOfStay = resultSet.getString("period_of_stay");
                String residenceStatus = resultSet.getString("residence_status");

                EmployeeObj obj = new EmployeeObj();
                obj.setEmployeeCode(employeeCode);
                obj.setName(name);
                obj.setKatakana(katakana);
                obj.setBirth(birth);
                obj.setPhoneNumber(phoneNumber);
                obj.setEmail(email);
                obj.setDateOfJoining(dateOfJoining);
                obj.setDateOfResignation(dateOfResignation);
                obj.setPostalCode(postalCode);
                obj.setAddress(address);
                obj.setNationality(nationality);
                obj.setContractType(contractType);
                obj.setSalaryType(salaryType);
                obj.setJobTitle(jobTitle);
                obj.setHealthInsuranceNumber(healthInsuranceNumber);
                obj.setLaborInsuranceNumber(laborInsuranceNumber);
                obj.setResidenceCardNumber(residenceCardNumber);
                obj.setPeriodOfStay(periodOfStay);
                obj.setResidenceStatus(residenceStatus);

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

    public List<EmployeeObj> setEmployeeList() throws SQLException {

        System.out.println("aaaaa");

        List<EmployeeObj> list = new ArrayList<EmployeeObj>();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String sql = "SELECT * FROM Employee_Info WHERE Deletion_Flag = '0'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // 6. 处理结果集
            while (resultSet.next()) {
                String employeeCode = resultSet.getString("employee_code");
                String name = resultSet.getString("name");

                EmployeeObj obj = new EmployeeObj();
                obj.setEmployeeCode(employeeCode);
                obj.setName(name);
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

    public List<EmployeeObj> searchEmployeeList() {

        List<EmployeeObj> list = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String sql = "SELECT * FROM Employee_Info WHERE employee_code = ? AND Deletion_Flag = '0'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // 6. 处理结果集
            while (resultSet.next()) {
                String employeeCode = resultSet.getString("employee_code");
                String name = resultSet.getString("name");

                EmployeeObj obj = new EmployeeObj();
                obj.setEmployeeCode(employeeCode);
                obj.setName(name);
                list.add(obj);

            }

            // 7. 关闭资源
            resultSet.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteEmployeeInfo(String employeeCode) {

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            List<String> list = new ArrayList<String>();
            String sqlx = "UPDATE Employee_Info SET Deletion_Flag = '1' WHERE employee_code = ?";
            String sqly = "UPDATE Employee_Info SET Deletion_Flag = '1' WHERE employee_code = ?";
            list.add(sqlx);
            list.add(sqly);

            for (String str : list) {

                // 4. 创建 PreparedStatement 对象
                PreparedStatement preparedStatement = connection.prepareStatement(str);
                preparedStatement.setString(1, employeeCode);

                // 5. 执行删除操作
                int rowCount = preparedStatement.executeUpdate();
                // 6. 关闭资源
                preparedStatement.close();
            }

            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public EmployeeObj getEmployeeInfo(String emCode) {

        EmployeeObj obj = new EmployeeObj();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String sql = "select * from Employee_Info where employee_code = '" + emCode + "' AND Deletion_Flag = '0';";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // 6. 处理结果集
            while (resultSet.next()) {
                String employeeCode = resultSet.getString("employee_code");
                String name = resultSet.getString("name");
                String katakana = resultSet.getString("katakana");
                String birth = resultSet.getString("birth");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String dateOfJoining = resultSet.getString("date_of_joining");
                String dateOfResignation = resultSet.getString("date_of_resignation");
                String postalCode = resultSet.getString("postal_code");
                String address = resultSet.getString("address");
                String nationality = resultSet.getString("nationality");
                String contractType = resultSet.getString("contract_type");
                String salaryType = resultSet.getString("salary_type");
                String jobTitle = resultSet.getString("job_title");
                String healthInsuranceNumber = resultSet.getString("health_insurance_number");
                String laborInsuranceNumber = resultSet.getString("labor_insurance_number");
                String residenceCardNumber = resultSet.getString("residence_card_number");
                String periodOfStay = resultSet.getString("period_of_stay");
                String residenceStatus = resultSet.getString("residence_status");

                obj.setEmployeeCode(employeeCode);
                obj.setName(name);
                obj.setKatakana(katakana);
                obj.setBirth(birth);
                obj.setPhoneNumber(phoneNumber);
                obj.setEmail(email);
                obj.setDateOfJoining(dateOfJoining);
                obj.setDateOfResignation(dateOfResignation);
                obj.setPostalCode(postalCode);
                obj.setAddress(address);
                obj.setNationality(nationality);
                obj.setContractType(contractType);
                obj.setSalaryType(salaryType);
                obj.setJobTitle(jobTitle);
                obj.setHealthInsuranceNumber(healthInsuranceNumber);
                obj.setLaborInsuranceNumber(laborInsuranceNumber);
                obj.setResidenceCardNumber(residenceCardNumber);
                obj.setPeriodOfStay(periodOfStay);
                obj.setResidenceStatus(residenceStatus);

            }

            // 7. 关闭资源
            resultSet.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConnJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }

}
