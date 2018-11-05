package com.y.r.x.tool.string.hump;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by r.x on 2018/10/31.
 */
public class HumpHelperTest {

    @Test
    public void standard() {
        String underline = "underlineHelper";
        String result = HumpHelper.convertHumpToUnderline(underline);
        Assert.assertEquals("underline_helper", result);
    }

    @Test
    public void prefixError() {
        String underline = "_underlineHelper";
        String result = HumpHelper.convertHumpToUnderline(underline);
        Assert.assertEquals("_underline_helper", result);
    }

    @Test
    public void suffixError() {
        String underline = "underlineHelper_";
        String result = HumpHelper.convertHumpToUnderline(underline);
        Assert.assertEquals("underline_helper_", result);
    }
}