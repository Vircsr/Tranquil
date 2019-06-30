package util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;

/**
 * ============================
 * 作者： 陈帆
 * 日期：  2019/6/30 - 15:39
 * 描述：验证用户输入合法性
 * ============================
 */
public class UserUtils {
    public static boolean validateLogin(Context context, String name, String password){
        if(RegexUtils.isUsername(name)){
            Toast.makeText(context,"无效用户名",Toast.LENGTH_SHORT);
            return false;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(context,"请输入密码",Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }
    public static boolean validateLogin(Context context, String name, String password,String passwordagain){
        if(RegexUtils.isUsername(name)){
            Toast.makeText(context,"无效用户名",Toast.LENGTH_SHORT);
            return false;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(context,"请输入密码",Toast.LENGTH_SHORT);
            return false;
        }
        if(passwordagain!=password){
            Toast.makeText(context,"两次密码输入不一致",Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }
}
