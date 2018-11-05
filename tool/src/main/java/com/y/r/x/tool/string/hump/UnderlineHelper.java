package com.y.r.x.tool.string.hump;

/**
 * Created by r.x on 2018/10/31.
 * 下划线转驼峰
 */
public final class UnderlineHelper {
    private UnderlineHelper() {
    }

    /**
     * 将下划线转为驼峰
     * @param underlineStr 下划线字符串
     * @return 驼峰字符串
     */
    public static String convertHumpToUnderline(String underlineStr) {
        char[] letters = underlineStr.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            if (letter == 95) {
                if (i > 0 && i < letters.length - 2) {
                    letter = (char) (letters[i + 1] - 32);
                    i++;
                }
            }
            result.append(letter);
        }
        return result.toString();
    }
}
