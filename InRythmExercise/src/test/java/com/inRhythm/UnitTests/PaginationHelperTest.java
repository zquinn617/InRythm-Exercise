package com.inRhythm.unitTests;

import com.InRhythm.PaginationHelper;
import com.InRhythm.invalidItemsPerPageException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaginationHelperTest {

    @Test
    public void testPageCount() throws invalidItemsPerPageException {
        Object[] pageContents = new Object[]{'a','b','c','d','e','f','g','h'};
        PaginationHelper helper = new PaginationHelper(pageContents,4);
        Assert.assertEquals(helper.pageCount(),2);
    }

    @Test(expectedExceptions = {invalidItemsPerPageException.class})
    public void testNegativePageSize() throws invalidItemsPerPageException {
        Object[] pageContents = new Object[]{'a','b','c','d','e','f'};
        PaginationHelper helper = new PaginationHelper(pageContents,-4);
    }

    @Test
    public void testPageItemCountPositive() throws invalidItemsPerPageException {
        Object[] pageContents = new Object[]{'a','b','c','d','e','f'};
        PaginationHelper helper = new PaginationHelper(pageContents,4);
        Assert.assertEquals(helper.pageItemCount(0),4);
        Assert.assertEquals(helper.pageItemCount(1),2);
    }

    @Test
    public void testPageItemCountNegative() throws invalidItemsPerPageException {
        Object[] pageContents = new Object[]{'a','b','c','d','e','f'};
        PaginationHelper helper = new PaginationHelper(pageContents,4);
        Assert.assertEquals(helper.pageItemCount(-1),-1);
        Assert.assertEquals(helper.pageItemCount(2),-1);
    }

    @Test
    public void testItemCountPositive() throws invalidItemsPerPageException {
        Object[] pageContents = new Object[]{'a','b','c','d','e','f'};
        PaginationHelper helper = new PaginationHelper(pageContents,4);
        Assert.assertEquals(helper.pageIndex(5),1);
        Assert.assertEquals(helper.pageIndex(2),0);
    }

    @Test
    public void testItemCountNegative() throws invalidItemsPerPageException {
        Object[] pageContents = new Object[]{'a','b','c','d','e','f'};
        PaginationHelper helper = new PaginationHelper(pageContents,4);
        Assert.assertEquals(helper.pageIndex(5),1);
        Assert.assertEquals(helper.pageIndex(2),0);
    }
}