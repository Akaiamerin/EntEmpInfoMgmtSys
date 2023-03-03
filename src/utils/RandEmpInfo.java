//生成随机员工信息
package utils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import model.Emp;
public class RandEmpInfo {
    private static final ArrayList<String> GENDER_ARR_LIST = new ArrayList<>(Arrays.asList("男", "女"));
    private static final ArrayList<String> DEPT_ARR_LIST = new ArrayList<>(Arrays.asList("销售部", "市场部", "技术部", "财务部", "行政部"));
    private static final ArrayList<String> JOB_ARR_LIST = new ArrayList<>(Arrays.asList("员工", "组长", "主管", "经理", "总监"));
    //生成一条员工信息
    private static String crtOneRandEmpInfo() {
        SecureRandom secRand = new SecureRandom();
        Emp emp = new Emp();
        emp.setId(20220000 + secRand.nextInt(9999));
        emp.setName(String.valueOf(new StringBuilder().append((char) ('A' + secRand.nextInt('Z' - 'A'))).append((char) ('a' + secRand.nextInt('z' - 'a'))).append((char) ('a' + secRand.nextInt('z' - 'a')))));
        emp.setGender(GENDER_ARR_LIST.get(secRand.nextInt(2)));
        emp.setAge(18 + secRand.nextInt(42));
        emp.setDept(DEPT_ARR_LIST.get(secRand.nextInt(DEPT_ARR_LIST.size())));
        emp.setJob(JOB_ARR_LIST.get(secRand.nextInt(JOB_ARR_LIST.size())));
        for (int i = 0; i < JOB_ARR_LIST.size(); i++) {
            if (Objects.equals(JOB_ARR_LIST.get(i), emp.getJob()) == true) {
                emp.setSal(Double.valueOf(String.format("%.2f", 3000 + (200 * i) + secRand.nextDouble(200))));
            }
        }
        StringBuilder ret = new StringBuilder("INSERT INTO ent_emp_info_mgmt_sys.emp (id, name, gender, age, dept, job, sal) VALUES (").append(emp.getId()).append(", '").append(emp.getName()).append("', '").append(emp.getGender()).append("', ").append(emp.getAge()).append(", '").append(emp.getDept()).append("', '").append(emp.getJob()).append("', ").append(emp.getSal()).append(");");
        return String.valueOf(ret);
    }
    //生成指定数量员工信息并保存到文件
    public static void crtRandEmpInfo(String filePath, int randEmpInfoNum) {
        BufferedWriter fw = null;
        try {
            fw = new BufferedWriter(new FileWriter(filePath));
            for (int i = 0; i < randEmpInfoNum; i++) {
                String oneRandEmpInfo = crtOneRandEmpInfo();
                Connection conn = null;
                PreparedStatement prepStmt = null;
                try {
                    conn = Database.getConn();
                    if (conn == null) {
                        return;
                    }
                    prepStmt = conn.prepareStatement(oneRandEmpInfo);
                    prepStmt.executeUpdate();
                }
                catch (SQLException exc) {
                    exc.printStackTrace();
                }
                finally {
                    Database.closePrepStmt(prepStmt);
                    Database.closeConn(conn);
                }
                fw.write(oneRandEmpInfo);
                fw.newLine();
                fw.flush();
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            if (fw != null) {
                try {
                    fw.close();
                }
                catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
}