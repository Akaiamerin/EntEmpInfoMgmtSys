package dao.intf;
import model.Admin;
import model.Emp;
import view.jframe.MainJFrame;
import view.jtable.EmpInfoJTable;
public interface EmpDAO {
    boolean verifyAcctBySQL(Admin admin); //验证管理员账号密码
    boolean insBySQL(Emp emp); //SQL 添加语句
    boolean updBySQL(Emp emp); //SQL 更新语句
    boolean delBySQL(int[] delEmpIndexArr); //SQL 删除语句
    Emp SelEmpIdBySQL(int EmpId); //根据 id 选择员工
    EmpInfoJTable selEmpBySQL(MainJFrame mainJFrame); //SQL 选择语句，用于实时更新数据
}