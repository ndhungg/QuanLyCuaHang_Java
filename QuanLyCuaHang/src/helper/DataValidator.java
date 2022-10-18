package helper;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DataValidator {
    public static void ValidatorEmpty(JTextField field,StringBuffer sb,String errorMessage){
        if(field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    
    public static void ValidatorEmpty(JPasswordField field,StringBuffer sb,String errorMessage){
        String passWord = new String(field.getPassword());
        if(passWord.equals("")){
            sb.append(errorMessage).append("\n");
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    
    public static void ValidatorNumberPhone(JTextField field,StringBuffer sb,String errorMessage){
        if(field.getText().length() < 10 || field.getText().length() >12){
            sb.append(errorMessage).append("\n");
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
}
