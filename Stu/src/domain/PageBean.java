package domain;

import java.util.List;

/*
这是一个用于封装分页数据，包含该页学生数据、总记录数、总页数、当前页以及每页显示的记录数
 */
public class PageBean<T> {
    private int currentPage;//当前页
    private int totalPage;//总页数
    private int pageSize;//每页显示的记录数
    private int totalSize;//总记录数
    private List<T> list;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
