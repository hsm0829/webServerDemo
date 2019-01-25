package com.web.generator.dao.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hsm
 * @since 2019-01-25
 */
public class Bookstock extends Model<Bookstock> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer bookid;
    /**
     * 库存
     */
    private Integer num;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Bookstock{" +
        "id=" + id +
        ", bookid=" + bookid +
        ", num=" + num +
        "}";
    }
}
