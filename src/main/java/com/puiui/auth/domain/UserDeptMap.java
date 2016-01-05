package com.puiui.auth.domain;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import com.puiui.auth.domain.prop.BasicCase;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaiyinghao on 2015/12/31.
 */
@Entity
@Table(name = "auth_user_dept_map")
public class UserDeptMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @Column(nullable = false)
    private User user;
    @ManyToOne
    @Column(nullable = false)
    private Dept dept;
    @Column(nullable = false)
    private BasicCase isManager;
    @Column(nullable = false)
    private BasicCase isShow;
    @Column(nullable = false)
    private int sortCode;
    @CreatedTimestamp
    private Date createdate;
    @UpdatedTimestamp
    private Date updatedate;

    public UserDeptMap() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public BasicCase getIsManager() {
        return isManager;
    }

    public void setIsManager(BasicCase isManager) {
        this.isManager = isManager;
    }

    public BasicCase getIsShow() {
        return isShow;
    }

    public void setIsShow(BasicCase isShow) {
        this.isShow = isShow;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }
}
