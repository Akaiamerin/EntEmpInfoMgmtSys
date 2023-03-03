//数据库连接、关闭
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Database {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ent_emp_info_mgmt_sys";
    private static final String ACCT = "root";
    private static final String PWD = "111111";
    //加载数据库
    static {
        try {
            Class.forName(DRIVER);
        }
        catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }
    //连接数据库
    public static Connection getConn() {
        try {
            return DriverManager.getConnection(URL, ACCT, PWD);
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
        return null;
    }
    //关闭 Connection
    public static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
    //关闭 PreparedStatement
    public static void closePrepStmt(PreparedStatement prepStmt) {
        try {
            if (prepStmt != null) {
                prepStmt.close();
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
    //关闭 ResultSet
    public static void closeRetSet(ResultSet retSet) {
        try {
            if (retSet != null) {
                retSet.close();
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}