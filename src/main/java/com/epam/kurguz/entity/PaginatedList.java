package com.epam.kurguz.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PaginatedList<E> {
    private List<E> list;
    private int pageNumber;
    private int rowsCount;

    public PaginatedList() {
        list = new ArrayList<>();
    }

    public void forEach(Consumer<? super E> action) {
        list.forEach(action);
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getRowsCount() {
        return rowsCount;
    }

    public void setRowsCount(int rowsCount) {
        this.rowsCount = rowsCount;
    }

    public boolean add(E element) {
        return list.add(element);
    }

    @Override
    public String toString() {
        return "PaginatedList{" +
                "list=" + list +
                '}';
    }
}
