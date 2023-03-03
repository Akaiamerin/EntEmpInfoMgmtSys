//监听主界面
package ctrl;
import dao.impl.EmpDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.jdialog.InsJDialog;
import view.jdialog.UpdJDialog;
import view.jframe.LoginJFrame;
import view.jframe.MainJFrame;
public class MainActListener implements ActionListener {
    private MainJFrame mainJFrame;
    public MainActListener() {
    }
    public MainActListener(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
    }
    //监听主界面操作按键
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton jBtn = (JButton) (event.getSource());
        if (Objects.equals(jBtn.getText(), "添　加") == true) {
            new InsJDialog(mainJFrame);
        }
        else if (Objects.equals(jBtn.getText(), "修　改") == true) {
            int[] updEmpIndexArr = mainJFrame.getSelIndexArr(); //获取选择的员工信息数量
            if (updEmpIndexArr.length == 0) {
                JOptionPane.showMessageDialog(mainJFrame, "请 选 择 要 修 改 的 信 息", "错　误", JOptionPane.ERROR_MESSAGE);
            }
            else if (updEmpIndexArr.length > 1) {
                JOptionPane.showMessageDialog(mainJFrame, "一 次 只 能 修 改 一 条 信 息", "错　误", JOptionPane.ERROR_MESSAGE);
            }
            else {
                new UpdJDialog(mainJFrame, updEmpIndexArr[0]);
            }
        }
        else if (Objects.equals(jBtn.getText(), "删　除") == true) {
            int[] delEmpIndexArr = mainJFrame.getSelIndexArr(); //获取选择的员工信息数量
            if (delEmpIndexArr.length == 0) {
                JOptionPane.showMessageDialog(mainJFrame, "请 选 择 要 删 除 的 信 息", "错　误", JOptionPane.ERROR_MESSAGE);
            }
            else {
                int delOpt = JOptionPane.showConfirmDialog(mainJFrame, "确 定 要 删 除 选 择 的 " + delEmpIndexArr.length + " 条 信 息 吗？", "删　除", JOptionPane.YES_NO_OPTION);
                if (delOpt == JOptionPane.YES_OPTION) {
                    if (new EmpDAOImpl().delBySQL(delEmpIndexArr) == true) {
                        mainJFrame.refreshEmpInfoTable(); //删除成功，刷新表格模型
                    }
                    else {
                        JOptionPane.showMessageDialog(mainJFrame, "删 除 失 败", "错　误", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        else if (Objects.equals(jBtn.getText(), "查　询") == true) {
            mainJFrame.refreshEmpInfoTable(); //刷新表格模型得到查询结果
        }
        else if (Objects.equals(jBtn.getText(), "返回登录界面") == true) {
            mainJFrame.dispose();
            new LoginJFrame();
        }
    }
}