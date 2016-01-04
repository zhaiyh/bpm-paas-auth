package com.puiui.auth.domain;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import com.puiui.auth.domain.prop.BasicCase;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by zhaiyinghao on 2015/12/17.
 */
@Entity
@Table(name = "auth_dept")
public class Dept extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id
    @ManyToOne
    @Column(nullable = false)
    private Dept parent; // 父部门
    @OneToMany(mappedBy = "parent")
    private Set<Dept> children; // 子部门
    @Column(length = 100)
    private String deptName; // 部门名称
    @Column(length = 500)
    private String deptDesc; // 部门描述
    @Column(length = 1, nullable = false)
    private Short deptLevel; // 部门层级
    @Column(nullable = false)
    private Integer sortCode; // 排序编码
    @CreatedTimestamp
    private Date createdate; // 创建日期
    @UpdatedTimestamp
    private Date updatedate; // 更新日期
    @OneToMany(mappedBy = "dept")
    private Set<UserDeptMap> userDeptMaps; // 用户部门映射

    public Dept() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dept getParent() {
        return parent;
    }

    public void setParent(Dept parent) {
        this.parent = parent;
    }

    public Set<Dept> getChildren() {
        return children;
    }

    public void setChildren(Set<Dept> children) {
        this.children = children;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    public Short getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(Short deptLevel) {
        this.deptLevel = deptLevel;
    }

    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
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

    public Set<UserDeptMap> getUserDeptMaps() {
        return userDeptMaps;
    }

    public void setUserDeptMaps(Set<UserDeptMap> userDeptMaps) {
        this.userDeptMaps = userDeptMaps;
    }
}
