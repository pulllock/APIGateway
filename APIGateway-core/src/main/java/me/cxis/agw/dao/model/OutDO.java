package me.cxis.agw.dao.model;

import java.util.Date;

public class OutDO {

    private Long id;

    private Date createdTime;

    private Date modifiedTime;

    private Short version;

    private String name;

    private String desc;

    private String code;

    private Boolean ipControl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getIpControl() {
        return ipControl;
    }

    public void setIpControl(Boolean ipControl) {
        this.ipControl = ipControl;
    }
}