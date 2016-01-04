package com.puiui.auth.domain;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import com.puiui.auth.domain.prop.BasicCase;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by zhaiyinghao on 2015/12/28.
 */
@Entity
@Table(name="auth_job_role")
public class JobRole extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Id
    @Column(length = 100, nullable = false, unique = true)
    private String jobRoleName; // 岗位角色名称
    @Column(length = 500)
    private String jobRoleDesc; // 岗位角色描述
    @CreatedTimestamp
    private Date createdate; // 创建时间
    @UpdatedTimestamp
    private Date updatedate; // 修改时间
    @OneToMany(mappedBy = "jobRole")
    private Set<UserJobRoleMap> userJobRoleMaps; // 用户岗位角色映射
    @ManyToOne
    @Column(nullable = false)
    private JobRoleGroup jobRoleGroup; // 所属岗位角色组

    public JobRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobRoleName() {
        return jobRoleName;
    }

    public void setJobRoleName(String jobRoleName) {
        this.jobRoleName = jobRoleName;
    }

    public String getJobRoleDesc() {
        return jobRoleDesc;
    }

    public void setJobRoleDesc(String jobRoleDesc) {
        this.jobRoleDesc = jobRoleDesc;
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

    public Set<UserJobRoleMap> getUserJobRoleMaps() {
        return userJobRoleMaps;
    }

    public void setUserJobRoleMaps(Set<UserJobRoleMap> userJobRoleMaps) {
        this.userJobRoleMaps = userJobRoleMaps;
    }

    public JobRoleGroup getJobRoleGroup() {
        return jobRoleGroup;
    }

    public void setJobRoleGroup(JobRoleGroup jobRoleGroup) {
        this.jobRoleGroup = jobRoleGroup;
    }
}
