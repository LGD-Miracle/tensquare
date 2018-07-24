package entity;

import java.util.List;

/**
 * @Author: Shaoyuan Du
 * @Description:
 * @Date: Created in 11:12 2018/7/23
 * @Version:
 */
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageResult(Long total, List<T> rows) {

        this.total = total;
        this.rows = rows;
    }
}
