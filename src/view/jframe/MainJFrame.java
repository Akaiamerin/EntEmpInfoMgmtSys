//主界面
package view.jframe;
import ctrl.MainActListener;
import dao.impl.EmpDAOImpl;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.EmpInfoDefaultTableModel;
import view.jtable.EmpInfoJTable;
public class MainJFrame extends JFrame {
    private String queryKey; //查询关键词
    private final JTextField queryJTextField = new JTextField(15);
    private final EmpInfoJTable empInfoJTable = new EmpInfoJTable();
    private Font initFont() {
        return new Font("微软雅黑", Font.PLAIN, 16);
    }
    public MainJFrame() {
        super("企 业 员 工 信 息 管 理 系 统");
        MainActListener mainActListener = new MainActListener(this);
        //添加组件
        JButton insJBtn = new JButton("添　加");
        insJBtn.setFont(initFont());
        insJBtn.addActionListener(mainActListener);
        //修改组件
        JButton updJBtn = new JButton("修　改");
        updJBtn.setFont(initFont());
        updJBtn.addActionListener(mainActListener);
        //删除组件
        JButton delJBtn = new JButton("删　除");
        delJBtn.setFont(initFont());
        delJBtn.addActionListener(mainActListener);
        //查询组件
        queryJTextField.setFont(initFont());
        JButton queryJBtn = new JButton("查　询");
        queryJBtn.setFont(initFont());
        queryJBtn.addActionListener(mainActListener);
        //返回登录界面组件
        JButton reLoginJBtn = new JButton("返回登录界面");
        reLoginJBtn.setFont(initFont());
        reLoginJBtn.addActionListener(mainActListener);
        EmpInfoJTable empInfoJTableObj = getEmpJTableObj();
        empInfoJTable.setModel(EmpInfoDefaultTableModel.initEmpDefTableModel(empInfoJTableObj.getEmpInfoJTable())); //初始化
        //JPanel设置
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jPanel.add(insJBtn);
        jPanel.add(updJBtn);
        jPanel.add(delJBtn);
        jPanel.add(queryJTextField);
        jPanel.add(queryJBtn);
        jPanel.add(reLoginJBtn);
        //主界面其他设置
        this.add(new JScrollPane(empInfoJTable), BorderLayout.CENTER); //可滑动
        this.add(jPanel, BorderLayout.NORTH);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public String getQueryKey() {
        return queryKey;
    }
    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }
    //获取主界面的表格信息初始化表格模型
    public EmpInfoJTable getEmpJTableObj() {
        this.setQueryKey(queryJTextField.getText().trim());
        return new EmpDAOImpl().selEmpBySQL(this);
    }
    //刷新表格模型
    public void refreshEmpInfoTable() {
        EmpInfoDefaultTableModel.refreshEmpDefTableModel(getEmpJTableObj().getEmpInfoJTable());
    }
    //选择员工信息的行数
    public int[] getSelIndexArr() {
        int[] SelIndexArr = new int[empInfoJTable.getSelectedRows().length];
        for (int i = 0; i < empInfoJTable.getSelectedRows().length; i++) {
            int rowIndex = empInfoJTable.getSelectedRows()[i];
            SelIndexArr[i] = Integer.parseInt(String.valueOf(empInfoJTable.getValueAt(rowIndex, 0)));
        }
        return SelIndexArr;
    }
}