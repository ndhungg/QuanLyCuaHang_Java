package helper;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MessageDialogHelper {

    public static void ShowMessageDialog(Component parent, String content, String title) {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ShowErrorDialog(Component parent, String title, String content) {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.ERROR_MESSAGE);
    }

    public static int ShowConfirmDialog(Component parent, String title, String content) {
        int choose = JOptionPane.showConfirmDialog(parent, content, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose;
    }

}
