//表格模型
package model;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
public class EmpInfoDefaultTableModel extends DefaultTableModel {
    private static final Vector<String> COL_HEADER_TITLE = new Vector<>(Arrays.asList("工　号", "姓　名", "性　别", "年　龄", "部　门", "职　务", "工　资"));
    private static final EmpInfoDefaultTableModel EMP_DEFAULT_TABLE_MODEL = new EmpInfoDefaultTableModel();
    public EmpInfoDefaultTableModel() {
        super(null, COL_HEADER_TITLE);
    }
    //初始化表格模型
    public static EmpInfoDefaultTableModel initEmpDefTableModel(Vector<Vector<Object>> empInfoJTable) {
        EMP_DEFAULT_TABLE_MODEL.setDataVector(empInfoJTable, COL_HEADER_TITLE);
        return EMP_DEFAULT_TABLE_MODEL;
    }
    //刷新表格模型
    public static void refreshEmpDefTableModel(Vector<Vector<Object>> empInfoJTable) {
        EMP_DEFAULT_TABLE_MODEL.setDataVector(empInfoJTable, COL_HEADER_TITLE);
    }
    //表格不可编辑
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}