package com.puiui.auth.domain;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by zhaiyinghao on 2015/12/17.
 */
@Entity
@Table(name = "auth_job_role_group")
public class JobRoleGroup extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id
    @ManyToOne
    private JobRoleGroup parent; // 父组
    @OneToMany(mappedBy = "parent")
    private Set<JobRoleGroup> children; // 子组
    @Column(length = 100, nullable = false, unique = true)
    private String groupName; // 组名称
    @Column(length = 500)
    private String groupDesc; // 组描述
    @Column(length = 1, nullable = false)
    private Short groupLevel; // 组层级
    @Column(nullable = false)
    private Integer sortCode; // 排序编码
    @CreatedTimestamp
    private Date createdate; // 创建日期
    @UpdatedTimestamp
    private Date updatedate; // 修改日期
    @OneToMany(mappedBy = "jobRoleGroup")
    private Set<JobRole> jobRoles; // 角色

    public JobRoleGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobRoleGroup getParent() {
        return parent;
    }

    public void setParent(JobRoleGroup parent) {
        this.parent = parent;
    }

    public Set<JobRoleGroup> getChildren() {
        return children;
    }

    public void setChildren(Set<JobRoleGroup> children) {
        this.children = children;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public Short getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(Short groupLevel) {
        this.groupLevel = groupLevel;
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

    public Set<JobRole> getJobRoles() {
        return jobRoles;
    }

    public void setJobRoles(Set<JobRole> jobRoles) {
        this.jobRoles = jobRoles;
    }
}
