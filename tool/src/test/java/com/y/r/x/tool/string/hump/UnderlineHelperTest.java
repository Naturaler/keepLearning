package com.y.r.x.tool.string.hump;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by r.x on 2018/10/31.
 */
public class UnderlineHelperTest {

    @Test
    public void standard() {
        String underline = "underline_helper";
        String result = UnderlineHelper.convertHumpToUnderline(underline);
        Assert.assertEquals("underlineHelper", result);
    }

    @Test
    public void prefixError() {
        String underline = "_underline_helper";
        String result = UnderlineHelper.convertHumpToUnderline(underline);
        Assert.assertEquals("_underlineHelper", result);
    }

    @Test
    public void suffixError() {
        String underline = "underline_helper_";
        String result = UnderlineHelper.convertHumpToUnderline(underline);
        Assert.assertEquals("underlineHelper_", result);
    }

}