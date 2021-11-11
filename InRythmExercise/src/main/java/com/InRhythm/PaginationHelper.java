package com.InRhythm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaginationHelper {

    private final List<Object[]> pages;
    private final int itemCount;
    private final int pageSize;

    public PaginationHelper(Object[] objects, int itemsPerPage) throws invalidItemsPerPageException, invalidItemsException {
        if (itemsPerPage <= 0)
            throw new invalidItemsPerPageException("Items per page must be a positive Integer");
        if (objects == null)
            throw new invalidItemsException("Input array must not be null");
        pageSize = itemsPerPage;
        itemCount = objects.length;
        int upperLimit = itemsPerPage;

        pages = new ArrayList<Object[]>();
        for (int lowerLimit = 0; lowerLimit < itemCount; lowerLimit += itemsPerPage) {
            Object[] page;
            if (upperLimit > itemCount) {
                page = Arrays.copyOfRange(objects, lowerLimit, itemCount);
            } else
                page = Arrays.copyOfRange(objects, lowerLimit, upperLimit);
            pages.add(page);
            upperLimit += itemsPerPage;
        }
    }

    /**
     * @return Number of pages for instance of PaginationHelper
     */
    public int pageCount() {
        return pages.size();
    }

    /**
     * Returns the number of items stored on the page given
     *
     * @param pageNumber index of page
     * @return item count for page
     */
    public int pageItemCount(int pageNumber) {
        if (pageNumber >= 0 && pageNumber < pages.size())
            return pages.get(pageNumber).length;
        else return -1;
    }

    /**
     * Returns the page where the object being given can be found
     *
     * @param index index for object of interest (index can be determined from input array)
     * @return page where object is stored
     */
    public int pageIndex(int index) {
        if (index >= 0 && index < itemCount)
            return (index / pageSize);
        else return -1;
    }

    /**
     * @return total number of Items for instance of PaginationHelper across all pages
     */
    public int itemCount() {
        return itemCount;
    }
}