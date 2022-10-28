package helper;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DataValidator {

    public static boolean ValidatorEmpty(JTextField field, StringBuffer sb, String errorMessage) {
        boolean ok = true;
        if (field.getText().equals("")) {
            sb.append(errorMessage).append("\n");
            field.requestFocus();
            ok = false;
        } else {
            field.setBackground(Color.white);
        }
        return ok;
    }

    public static boolean ValidatorEmptyJTextArea(JTextArea fileArea, StringBuffer sb, String errorMessage) {
        boolean ok = true;
        if (fileArea.getText().equals("")) {
            sb.append(errorMessage).append("\n");
            fileArea.requestFocus();
            ok = false;
        } else {
            fileArea.setBackground(Color.white);
        }
        return ok;
    }

    public static boolean ValidatorEmptyJPassword(JPasswordField field, StringBuffer sb, String errorMessage) {
        boolean ok = true;
        String passWord = new String(field.getPassword());
        if (passWord.equals("")) {
            sb.append(errorMessage).append("\n");
            field.requestFocus();
        } else {
            field.setBackground(Color.white);
        }
        return ok;
    }

    public static boolean CheckNumberPhone(JTextField field, StringBuffer sb) {
        boolean ok = true;
        if (!ValidatorEmpty(field, sb, "Bạn chưa nhập số điện thoại !!!")) {
            return false;
        }
        try {
            String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
            String sdt = field.getText();
            boolean kt = sdt.matches(reg);
            if (kt == false) {
                sb.append("Số điện thoại không hợp lệ");
                ok = false;
            }
        } catch (Exception e) {
            ok = false;
        }

        return ok;
    }

    public static boolean checkEmail(JTextField field, StringBuffer sb) {
        boolean ok = true;
        if (ValidatorEmpty(field, sb, "Chưa nhập Email !!!")) {
            return false;
        }
        String reg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String email = field.getText();
        boolean kt = email.matches(reg);
        if (kt == false) {
            sb.append("Email không hợp lệ\n");
            ok = false;
        }
        return ok;
    }

    public static boolean checkAmount(JTextField filed, StringBuffer sb) {
        boolean ok = false;
        if (!ValidatorEmpty(filed, sb, "Chưa nhập số lượng !!!")) {
            return false;
        }
        try {
            int sl = Integer.parseInt(filed.getText());
            if (sl < 0) {
                sb.append("Số lượng phải lớn hơn 0 ( sl > 0).");
                ok = false;
            }
        } catch (NumberFormatException e) {
            sb.append("Số lượng sản phẩm phải là giá trị số.\n");
            ok = false;
        }
        return ok;
    }

    public static boolean checkPrice(JTextField field, StringBuffer sb) {
        boolean ok = true;
        if (!ValidatorEmpty(field, sb, "Chưa nhập giá bán !!!")) {
            return false;
        }
        try {
            double giaban = Double.parseDouble(field.getText());
            if (giaban < 0) {
                sb.append("Giá bán không hợp lệ (Giá bán > 0)");
                ok = false;
            }
        } catch (NumberFormatException e) {
            sb.append("Giá bán không phải giá trị số.\n");
            ok = false;
        }
        return ok;
    }

    public static boolean checkImportPrice(JTextField field, StringBuffer sb) {
        boolean ok = true;

        if (!ValidatorEmpty(field, sb, "Chưa nhập giá mua !!!")) {
            return false;
        }

        try {
            double giamua = Double.parseDouble(field.getText());
            if (giamua <= 0) {
                sb.append("Giá mua không hợp lệ (Giá mua) >= 0");
                ok = false;
            }
        } catch (NumberFormatException e) {
            sb.append("Giá mua không phải là số !!!\n");
            ok = false;
        }
        return ok;
    }

}
