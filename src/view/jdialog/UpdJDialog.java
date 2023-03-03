//修改信息子界面
package view.jdialog;
import ctrl.UpdActListener;
import dao.impl.EmpDAOImpl;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Emp;
import view.jframe.MainJFrame;
public class UpdJDialog extends JDialog {
    private final JTextField idJTextField = new JTextField();
    private final JTextField nameJTextField = new JTextField();
    private final JComboBox<String> genderJComboBox = new JComboBox<>(new String[]{"男", "女"});
    private final JTextField ageJTextField = new JTextField();
    private final JComboBox<String> deptJComboBox = new JComboBox<>(new String[]{"销售部", "市场部", "技术部", "财务部", "行政部"});
    private final JComboBox<String> jobJComboBox = new JComboBox<>(new String[]{"员工", "组长", "主管", "经理", "总监"});
    private final JTextField salJTextField = new JTextField();
    public UpdJDialog() {
    }
    //组件字体设置
    private Font initFont() {
        return new Font("微软雅黑", Font.PLAIN, 20);
    }
    //组件尺寸设置
    private Dimension initDimension(String opt) {
        String[] str = opt.split("x");
        return new Dimension(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
    }
    public UpdJDialog(MainJFrame mainJFrame, int updEmpId) {
        super(mainJFrame, "修　改", true);
        Emp emp = new EmpDAOImpl().SelEmpIdBySQL(updEmpId);
        assert emp != null;
        //工号组件
        JLabel idLabel = new JLabel("工　号：", JLabel.RIGHT);
        idLabel.setFont(initFont());
        idLabel.setPreferredSize(initDimension("100x30"));
        idJTextField.setFont(initFont());
        idJTextField.setPreferredSize(initDimension("200x30"));
        idJTextField.setText(String.valueOf(emp.getId()));
        //姓名组件
        JLabel nameLabel = new JLabel("姓　名：", JLabel.RIGHT);
        nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        nameLabel.setPreferredSize(initDimension("100x30"));
        nameJTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        nameJTextField.setPreferredSize(initDimension("200x30"));
        nameJTextField.setText(emp.getName());
        //性别组件
        JLabel genderLabel = new JLabel("性　别：", JLabel.RIGHT);
        genderLabel.setFont(initFont());
        genderLabel.setPreferredSize(initDimension("100x30"));
        genderJComboBox.setFont(initFont());
        genderJComboBox.setPreferredSize(initDimension("200x30"));
        genderJComboBox.setSelectedItem(emp.getGender());
        //年龄组件
        JLabel ageLabel = new JLabel("年　龄：", JLabel.RIGHT);
        ageLabel.setFont(initFont());
        ageLabel.setPreferredSize(initDimension("100x30"));
        ageJTextField.setFont(initFont());
        ageJTextField.setPreferredSize(initDimension("200x30"));
        ageJTextField.setText(String.valueOf(emp.getAge()));
        //部门组件
        JLabel deptLabel = new JLabel("部　门：", JLabel.RIGHT);
        deptLabel.setFont(initFont());
        deptLabel.setPreferredSize(initDimension("100x30"));
        deptJComboBox.setFont(initFont());
        deptJComboBox.setPreferredSize(initDimension("200x30"));
        deptJComboBox.setSelectedItem(emp.getDept());
        //职务组件
        JLabel jobLabel = new JLabel("职　务：", JLabel.RIGHT);
        jobLabel.setFont(initFont());
        jobLabel.setPreferredSize(initDimension("100x30"));
        jobJComboBox.setFont(initFont());
        jobJComboBox.setPreferredSize(initDimension("200x30"));
        jobJComboBox.setSelectedItem(emp.getJob());
        //工资组件
        JLabel salLabel = new JLabel("工　资：", JLabel.RIGHT);
        salLabel.setFont(initFont());
        salLabel.setPreferredSize(initDimension("100x30"));
        salJTextField.setFont(initFont());
        salJTextField.setPreferredSize(initDimension("200x30"));
        salJTextField.setText(String.valueOf(emp.getSal()));
        //修改组件
        JButton updJBtn = new JButton("修　改");
        updJBtn.setFont(initFont());
        updJBtn.addActionListener(new UpdActListener(mainJFrame, this));
        //JPanel设置
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        jPanel.add(idLabel);
        jPanel.add(idJTextField);
        jPanel.add(nameLabel);
        jPanel.add(nameJTextField);
        jPanel.add(genderLabel);
        jPanel.add(genderJComboBox);
        jPanel.add(ageLabel);
        jPanel.add(ageJTextField);
        jPanel.add(deptLabel);
        jPanel.add(deptJComboBox);
        jPanel.add(jobLabel);
        jPanel.add(jobJComboBox);
        jPanel.add(salLabel);
        jPanel.add(salJTextField);
        jPanel.add(updJBtn);
        //修改信息子界面其他设置
        this.add(jPanel);
        this.setSize(400, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    //更新的员工信息，用于数据库
    public Emp updEmpInfo() {
        Emp emp = new Emp(Integer.valueOf(idJTextField.getText()), nameJTextField.getText(), String.valueOf(genderJComboBox.getSelectedItem()), Integer.valueOf(ageJTextField.getText()), String.valueOf(deptJComboBox.getSelectedItem()), String.valueOf(jobJComboBox.getSelectedItem()), Double.valueOf(salJTextField.getText()));
        return emp;
    }
}