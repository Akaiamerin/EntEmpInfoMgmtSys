//初始化员工信息对话框
package view.joptionpane;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import utils.RandEmpInfo;
public class InitJOptionPane extends JOptionPane {
    private static final String FILE_PATH = ".\\src\\resrc\\emp.sql";
    //选择是否初始化员工信息操作
    public static void initEmpInfo() {
        int opt = JOptionPane.showOptionDialog(null, "  是 否 初 始 化 员 工 信 息？", "初　始　化", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"是", "否"}, JOptionPane.CLOSED_OPTION);
        if (opt == 0) {
            while (true) {
                String EmpInfoNum = JOptionPane.showInputDialog(null, "请 输 入 初 始 化 员 工 信 息 的 数 量", "初　始　化", JOptionPane.PLAIN_MESSAGE);
                if (Objects.equals(EmpInfoNum, "") == true) {
                    continue;
                }
                if (EmpInfoNum == null) {
                    break;
                }
                else if (Pattern.compile("\\d*").matcher(EmpInfoNum).matches() == true) {
                    RandEmpInfo.crtRandEmpInfo(FILE_PATH, Integer.parseInt(EmpInfoNum));
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(null, "输 入 错 误", "错　误", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}