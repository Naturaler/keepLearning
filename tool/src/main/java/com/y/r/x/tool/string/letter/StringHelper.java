package com.y.r.x.tool.string.letter;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by r.x on 2018/10/31.
 */
public final class StringHelper {
    private StringHelper() {
    }

    /**
     * 将首字母转换为大写
     *
     * @param source 原始字符串
     * @return 首字母大写的字符串
     */
    public static String uppercaseFirstLetter(String source) {
        if (StringUtils.isEmpty(source)) {
            return source;
        }
        char firstLetter = source.charAt(0);
        if (firstLetter >= 97 && firstLetter <= 122) {
            firstLetter = (char) (firstLetter - 32);
        }
        source = source.substring(1);
        source = firstLetter + source;
        return source;
    }

    /**
     * 检查字符串是否仅包含字母（大小写）、数字和下划线
     *
     * @param source 原始字符串
     * @return true：字符串仅包含字母、数字和下划线
     * <br>
     * false：含有中文或其它非下划线字符
     */
    public static boolean checkLetter(String source) {
        final String regex = "^[_0-9a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        return matcher.find();
    }
}
