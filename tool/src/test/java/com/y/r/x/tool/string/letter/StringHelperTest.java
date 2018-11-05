package com.y.r.x.tool.string.letter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by r.x on 2018/10/31.
 */
public class StringHelperTest {

    @Test
    public void standard() {
        String source = "helper";
        String expected = "Helper";
        Assert.assertEquals(expected, StringHelper.uppercaseFirstLetter(source));

        source = "helperTest";
        expected = "HelperTest";
        Assert.assertEquals(expected, StringHelper.uppercaseFirstLetter(source));
    }

    @Test
    public void prefixError() {
        String source = "_helper";
        String expected = "_helper";
        Assert.assertEquals(expected, StringHelper.uppercaseFirstLetter(source));
    }

    @Test
    public void verifyTest() {
        String source = "verify1";
        Assert.assertTrue(StringHelper.checkLetter(source));
        source = "verify1_";
        Assert.assertTrue(StringHelper.checkLetter(source));
        source = "verify1@++--";
        Assert.assertFalse(StringHelper.checkLetter(source));
    }
}