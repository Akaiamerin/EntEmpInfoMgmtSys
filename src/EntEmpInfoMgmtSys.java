//程序入口
import view.jframe.LoginJFrame;
import view.joptionpane.InitJOptionPane;
public class EntEmpInfoMgmtSys {
    public static void main(String[] args) {
        InitJOptionPane.initEmpInfo();
        new LoginJFrame();
    }
}