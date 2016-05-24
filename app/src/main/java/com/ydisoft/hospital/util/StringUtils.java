package com.ydisoft.hospital.util;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by franke2009 on 2016/05/11.
 */
public class StringUtils {

    /**
     * 提示输入内容超过规定长度
     * @param context
     * @param editText
     * @param max_length
     * @param err_msg
     */
    public static void lengthFilter( final Context context, EditText editText,
                                     final int max_length, final String err_msg){

        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(max_length){

            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                //获取字符个数(一个中文算2个字符)
                int destLen = StringUtils.getCharacterNum(dest.toString());
                int sourceLen = StringUtils.getCharacterNum(source.toString());
                if(destLen + sourceLen > max_length){
                    Toast.makeText(context, err_msg,Toast.LENGTH_SHORT).show();
                    return "";
                }
                return source;

            }

        };
        editText.setFilters(filters);
    }

    /**
     *
     * @param content
     * @return
     */
    public static int getCharacterNum(String content){
        if(content.equals("")||null == content){
            return 0;
        }else {
            return content.length()+getChineseNum(content);
        }

    }

    /**
     * 计算字符串的中文长度
     * @param s
     * @return
     */
    public static int getChineseNum(String s){
        int num = 0;
        char[] myChar = s.toCharArray();
        for(int i=0;i<myChar.length;i++){
            if((char)(byte)myChar[i] != myChar[i]){
                num++;
            }
        }
        return num;
    }
}