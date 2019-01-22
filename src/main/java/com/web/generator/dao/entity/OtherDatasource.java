package com.web.generator.dao.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hsm
 * @since 2019-01-08
 */
@TableName("other_datasource")
public class OtherDatasource extends Model<OtherDatasource> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("datasource_name")
    private String datasourceName;
    @TableField("database_ip")
    private String databaseIp;
    @TableField("database_port")
    private String databasePort;
    @TableField("database_name")
    private String databaseName;
    @TableField("database_username")
    private String databaseUsername;
    @TableField("database_password")
    private String databasePassword;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    public String getDatabaseIp() {
        return databaseIp;
    }

    public void setDatabaseIp(String databaseIp) {
        this.databaseIp = databaseIp;
    }

    public String getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(String databasePort) {
        this.databasePort = databasePort;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "OtherDatasource{" +
        "id=" + id +
        ", datasourceName=" + datasourceName +
        ", databaseIp=" + databaseIp +
        ", databasePort=" + databasePort +
        ", databaseName=" + databaseName +
        ", databaseUsername=" + databaseUsername +
        ", databasePassword=" + databasePassword +
        "}";
    }
}
