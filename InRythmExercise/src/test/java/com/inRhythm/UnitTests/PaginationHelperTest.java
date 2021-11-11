package com.inRhythm.UnitTests;

import com.InRhythm.PaginationHelper;
import com.InRhythm.invalidItemsException;
import com.InRhythm.invalidItemsPerPageException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaginationHelperTest {
    Object[] pageContents = new Object[]{'a', 'b', 'c', 'd', 'e', 'f'};
    PaginationHelper helper = new PaginationHelper(pageContents, 4);

    public PaginationHelperTest() throws invalidItemsPerPageException, invalidItemsException {
    }

    @Test(expectedExceptions = {invalidItemsPerPageException.class})
    public void testNegativePageSize() throws invalidItemsPerPageException, invalidItemsException {
        helper = new PaginationHelper(pageContents, -4);
    }

    @Test(expectedExceptions = {invalidItemsPerPageException.class})
    public void testZeroPageSize() throws invalidItemsPerPageException, invalidItemsException {
        helper = new PaginationHelper(pageContents, 0);
    }

    @Test(expectedExceptions = {invalidItemsException.class})
    public void testNullItems() throws invalidItemsPerPageException, invalidItemsException {
        helper = new PaginationHelper(null, 10);
    }

    @Test
    public void testZeroItems() throws invalidItemsPerPageException, invalidItemsException {
        helper = new PaginationHelper(new Object[]{}, 10);
        Assert.assertEquals(helper.itemCount(),0);
        Assert.assertEquals(helper.pageCount(), 0);
    }

    @Test
    public void testPageCount() {
        Assert.assertEquals(helper.pageCount(), 2);
    }

    @Test
    public void testItemCount() {
        Assert.assertEquals(helper.itemCount(),6);
    }

    @Test
    public void testPageItemCountPositive() {
        Assert.assertEquals(helper.pageItemCount(0), 4);
        Assert.assertEquals(helper.pageItemCount(1), 2);
    }

    @Test
    public void testPageItemCountNegative() {
        Assert.assertEquals(helper.pageItemCount(-1), -1);
        Assert.assertEquals(helper.pageItemCount(2), -1);
    }

    @Test
    public void testItemCountPositive() {
        Assert.assertEquals(helper.pageIndex(5), 1);
        Assert.assertEquals(helper.pageIndex(2), 0);
    }

    @Test
    public void testItemCountNegative() {
        Assert.assertEquals(helper.pageIndex(20), -1);
        Assert.assertEquals(helper.pageIndex(-10), -1);
    }
}
