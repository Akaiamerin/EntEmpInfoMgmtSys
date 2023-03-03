//添加信息子界面
package view.jdialog;
import ctrl.InsActListener;
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
public class InsJDialog extends JDialog {
    private final JTextField idJTextField = new JTextField();
    private final JTextField nameJTextField = new JTextField();
    private final JComboBox<String> genderJComboBox = new JComboBox<>(new String[]{"男", "女"});
    private final JTextField ageJTextField = new JTextField();
    private final JComboBox<String> deptJComboBox = new JComboBox<>(new String[]{"销售部", "市场部", "技术部", "财务部", "行政部"});
    private final JComboBox<String> jobJComboBox = new JComboBox<>(new String[]{"员工", "组长", "主管", "经理", "总监"});
    private final JTextField salJTextField = new JTextField();
    public InsJDialog() {
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
    public InsJDialog(MainJFrame mainJFrame) {
        super(mainJFrame, "添　加", true);
        //工号组件
        JLabel idJLabel = new JLabel("工　号：", JLabel.RIGHT);
        idJLabel.setFont(initFont());
        idJLabel.setPreferredSize(initDimension("100x30"));
        idJTextField.setFont(initFont());
        idJTextField.setPreferredSize(initDimension("200x30"));
        //姓名组件
        JLabel nameJLabel = new JLabel("姓　名：", JLabel.RIGHT);
        nameJLabel.setFont(initFont());
        nameJLabel.setPreferredSize(initDimension("100x30"));
        nameJTextField.setFont(initFont());
        nameJTextField.setPreferredSize(initDimension("200x30"));
        //性别组件
        JLabel genderJLabel = new JLabel("性　别：", JLabel.RIGHT);
        genderJLabel.setFont(initFont());
        genderJLabel.setPreferredSize(initDimension("100x30"));
        genderJComboBox.setFont(initFont());
        genderJComboBox.setPreferredSize(initDimension("200x30"));
        //年龄组件
        JLabel ageJLabel = new JLabel("年　龄：", JLabel.RIGHT);
        ageJLabel.setFont(initFont());
        ageJLabel.setPreferredSize(initDimension("100x30"));
        ageJTextField.setFont(initFont());
        ageJTextField.setPreferredSize(initDimension("200x30"));
        //部门组件
        JLabel deptJLabel = new JLabel("部　门：", JLabel.RIGHT);
        deptJLabel.setFont(initFont());
        deptJLabel.setPreferredSize(initDimension("100x30"));
        deptJComboBox.setFont(initFont());
        deptJComboBox.setPreferredSize(initDimension("200x30"));
        //组件
        JLabel jobJLabel = new JLabel("职　务：", JLabel.RIGHT);
        jobJLabel.setFont(initFont());
        jobJLabel.setPreferredSize(initDimension("100x30"));
        jobJComboBox.setFont(initFont());
        jobJComboBox.setPreferredSize(initDimension("200x30"));
        //工资组件
        JLabel salJLabel = new JLabel("工　资：", JLabel.RIGHT);
        salJLabel.setFont(initFont());
        salJLabel.setPreferredSize(initDimension("100x30"));
        salJTextField.setFont(initFont());
        salJTextField.setPreferredSize(initDimension("200x30"));
        //添加组件
        JButton insJBtn = new JButton("添　加");
        insJBtn.setFont(initFont());
        insJBtn.addActionListener(new InsActListener(mainJFrame, this));
        //JPanel设置
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        jPanel.add(idJLabel);
        jPanel.add(idJTextField);
        jPanel.add(nameJLabel);
        jPanel.add(nameJTextField);
        jPanel.add(genderJLabel);
        jPanel.add(genderJComboBox);
        jPanel.add(ageJLabel);
        jPanel.add(ageJTextField);
        jPanel.add(deptJLabel);
        jPanel.add(deptJComboBox);
        jPanel.add(jobJLabel);
        jPanel.add(jobJComboBox);
        jPanel.add(salJLabel);
        jPanel.add(salJTextField);
        jPanel.add(insJBtn);
        //添加信息子界面其他设置
        this.add(jPanel);
        this.setSize(400, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    //添加的员工信息，用于数据库
    public Emp insEmpInfo() {
        Emp emp = new Emp(Integer.valueOf(idJTextField.getText()), nameJTextField.getText(), String.valueOf(genderJComboBox.getSelectedItem()), Integer.valueOf(ageJTextField.getText()), String.valueOf(deptJComboBox.getSelectedItem()), String.valueOf(jobJComboBox.getSelectedItem()), Double.valueOf(salJTextField.getText()));
        return emp;
    }
}