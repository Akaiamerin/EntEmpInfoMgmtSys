//监听修改
package ctrl;
import dao.impl.EmpDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.jdialog.UpdJDialog;
import view.jframe.MainJFrame;
public class UpdActListener implements ActionListener {
    private MainJFrame mainJFrame;
    private UpdJDialog updJDialog;
    public UpdActListener() {
    }
    public UpdActListener(MainJFrame mainJFrame, UpdJDialog updJDialog) {
        this.mainJFrame = mainJFrame;
        this.updJDialog = updJDialog;
    }
    //监听修改按键
    @Override
    public void actionPerformed(ActionEvent event) {
        if (new EmpDAOImpl().updBySQL(updJDialog.updEmpInfo()) == true) {
            mainJFrame.refreshEmpInfoTable();
            updJDialog.dispose();
        }
        else {
            JOptionPane.showMessageDialog(updJDialog, "修 改 失 败", "错 误", JOptionPane.ERROR_MESSAGE);
        }
    }
}