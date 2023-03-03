//监听添加
package ctrl;
import dao.impl.EmpDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.jdialog.InsJDialog;
import view.jframe.MainJFrame;
public class InsActListener implements ActionListener {
    private MainJFrame mainJFrame;
    private InsJDialog insJDialog;
    public InsActListener() {
    }
    public InsActListener(MainJFrame mainJFrame, InsJDialog insJDialog) {
        this.insJDialog = insJDialog;
        this.mainJFrame = mainJFrame;
    }
    //监听添加按键
    @Override
    public void actionPerformed(ActionEvent event) {
        if (new EmpDAOImpl().insBySQL(insJDialog.insEmpInfo()) == true) {
            mainJFrame.refreshEmpInfoTable();
            insJDialog.dispose();
        }
        else {
            JOptionPane.showMessageDialog(insJDialog, "添 加 失 败", "错　误", JOptionPane.ERROR_MESSAGE);
        }
    }
}