package com.web.generator.dao.entity;

import java.math.BigDecimal;
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
public class Book extends Model<Book> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String bookname;
    private BigDecimal price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Book{" +
        "id=" + id +
        ", bookname=" + bookname +
        ", price=" + price +
        "}";
    }
}
