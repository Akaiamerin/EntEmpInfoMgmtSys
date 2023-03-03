//监听登录
package ctrl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.jframe.LoginJFrame;
public class LoginActListener implements ActionListener {
    private LoginJFrame loginJFrame;
    public LoginActListener() {
    }
    public LoginActListener(LoginJFrame loginJFrame) {
        this.loginJFrame = loginJFrame;
    }
    //监听登录和退出按键
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton jBtn = (JButton) (event.getSource());
        if (Objects.equals(jBtn.getText(), "登　录") == true) {
            loginJFrame.login();
        }
        else if (Objects.equals(jBtn.getText(), "退　出") == true) {
            int exitOpt = JOptionPane.showConfirmDialog(loginJFrame, "              确 认 退 出？", "退　出", JOptionPane.YES_NO_OPTION);
            if (exitOpt == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}