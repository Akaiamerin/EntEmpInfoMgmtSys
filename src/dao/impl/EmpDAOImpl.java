//SQL语句
package dao.impl;
import dao.intf.EmpDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;
import model.Admin;
import model.Emp;
import utils.Database;
import view.jframe.MainJFrame;
import view.jtable.EmpInfoJTable;
public class EmpDAOImpl implements EmpDAO {
    //验证管理员账号密码
    public boolean verifyAcctBySQL(Admin admin) {
        boolean ret = false;
        StringBuilder sql = new StringBuilder("SELECT pwd FROM admin WHERE acct = ?");
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        try {
            conn = Database.getConn();
            assert conn != null;
            prepStmt = conn.prepareStatement(String.valueOf(sql));
            prepStmt.setString(1, admin.getAcct());
            retSet = prepStmt.executeQuery();
            while (retSet.next() == true) {
                if (Objects.equals(admin.getPwd(), retSet.getString(1)) == true) {
                    ret = true;
                }
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            Database.closeRetSet(retSet);
            Database.closePrepStmt(prepStmt);
            Database.closeConn(conn);
        }
        return ret;
    }
    //SQL 添加语句
    public boolean insBySQL(Emp emp) {
        boolean ret = false;
        StringBuilder sql = new StringBuilder("INSERT INTO emp (id, name, gender, age, dept, job, sal) VALUES (?, ?, ?, ?, ?, ?, ?)");
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = Database.getConn();
            assert conn != null;
            prepStmt = conn.prepareStatement(String.valueOf(sql));
            prepStmt.setInt(1, emp.getId());
            prepStmt.setString(2, emp.getName());
            prepStmt.setString(3, emp.getGender());
            prepStmt.setInt(4, emp.getAge());
            prepStmt.setString(5, emp.getDept());
            prepStmt.setString(6, emp.getJob());
            prepStmt.setDouble(7, emp.getSal());
            if (prepStmt.executeUpdate() > 0) {
                ret = true;
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            Database.closePrepStmt(prepStmt);
            Database.closeConn(conn);
        }
        return ret;
    }
    //SQL 更新语句
    public boolean updBySQL(Emp emp) {
        boolean ret = false;
        StringBuilder sql = new StringBuilder("UPDATE emp SET id = ?, name = ?, gender = ?, age = ?, dept = ?, job = ?, sal = ? WHERE id = ?");
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = Database.getConn();
            assert conn != null;
            prepStmt = conn.prepareStatement(String.valueOf(sql));
            prepStmt.setInt(1, emp.getId());
            prepStmt.setString(2, emp.getName());
            prepStmt.setString(3, emp.getGender());
            prepStmt.setInt(4, emp.getAge());
            prepStmt.setString(5, emp.getDept());
            prepStmt.setString(6, emp.getJob());
            prepStmt.setDouble(7, emp.getSal());
            prepStmt.setInt(8, emp.getId());
            if (prepStmt.executeUpdate() > 0) {
                ret = true;
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            Database.closePrepStmt(prepStmt);
            Database.closeConn(conn);
        }
        return ret;
    }
    //SQL 删除语句
    public boolean delBySQL(int[] delEmpIndexArr) {
        boolean ret = false;
        StringBuilder sql = new StringBuilder("DELETE FROM emp WHERE id IN (");
        for (int i = 0; i < delEmpIndexArr.length; i++) {
            if (i == (delEmpIndexArr.length - 1)) {
                sql.append("?)");
            }
            else {
                sql.append("?, ");
            }
        }
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = Database.getConn();
            assert conn != null;
            prepStmt = conn.prepareStatement(String.valueOf(sql));
            for (int i = 0; i < delEmpIndexArr.length; i++) {
                prepStmt.setInt(1 + i, delEmpIndexArr[i]);
            }
            if (prepStmt.executeUpdate() > 0) {
                ret = true;
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            Database.closePrepStmt(prepStmt);
            Database.closeConn(conn);
        }
        return ret;
    }
    //根据 id 选择员工
    public Emp SelEmpIdBySQL(int EmpId) {
        Emp emp = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM emp WHERE id = ?");
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        try {
            conn = Database.getConn();
            assert conn != null;
            prepStmt = conn.prepareStatement(String.valueOf(sql));
            prepStmt.setInt(1, EmpId);
            retSet = prepStmt.executeQuery();
            emp = new Emp();
            while (retSet.next() == true) {
                emp.setId(retSet.getInt("id"));
                emp.setName(retSet.getString("name"));
                emp.setGender(retSet.getString("gender"));
                emp.setAge(retSet.getInt("age"));
                emp.setDept(retSet.getString("dept"));
                emp.setJob(retSet.getString("job"));
                emp.setSal(retSet.getDouble("sal"));
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            Database.closeRetSet(retSet);
            Database.closePrepStmt(prepStmt);
            Database.closeConn(conn);
        }
        return emp;
    }
    //SQL 选择语句，用于实时更新数据
    public EmpInfoJTable selEmpBySQL(MainJFrame mainJFrame) {
        EmpInfoJTable empJTable = null;
        StringBuilder sql = new StringBuilder("SELECT * FROM emp WHERE CONCAT (id, name, gender, age, dept, job, sal) LIKE '%").append(mainJFrame.getQueryKey().trim()).append("%'");
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet retSet = null;
        try {
            conn = Database.getConn();
            assert conn != null;
            prepStmt = conn.prepareStatement(String.valueOf(sql));
            retSet = prepStmt.executeQuery();
            Vector<Vector<Object>> empInfoJTable = new Vector<>();
            try {
                while (retSet.next() == true) {
                    Vector<Object> oneEmpInfo = new Vector<>(Arrays.asList(retSet.getInt("id"), retSet.getString("name"), retSet.getString("gender"), retSet.getInt("age"), retSet.getString("dept"), retSet.getString("job"), retSet.getDouble("sal")));
                    empInfoJTable.add(oneEmpInfo);
                }
            }
            catch (SQLException exc) {
                exc.printStackTrace();
            }
            empJTable = new EmpInfoJTable();
            empJTable.setEmpInfoJTable(empInfoJTable);
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        finally {
            Database.closeRetSet(retSet);
            Database.closePrepStmt(prepStmt);
            Database.closeConn(conn);
        }
        return empJTable;
    }
}