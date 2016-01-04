package com.puiui.auth.domain;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import com.puiui.auth.domain.prop.BasicCase;
import com.puiui.auth.domain.prop.UserStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by zhaiyinghao on 2015/12/16.
 */
@Entity
@Table(name = "auth_user")
public class User extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id
    @Column(length = 50, unique = true, nullable = false)
    private String username; // 用户名
    @Column(length = 50, nullable = false)
    private String password; // 密码
    @Column(length = 50)
    private String email; // 邮箱
    @Column(length = 50)
    private String nickname; // 昵称
    @Column(length = 50)
    private String mobileNum; // 手机号
    @Column(length = 5)
    private Short gender; // 性别
    @Column(nullable = false)
    private UserStatus status; // 用户状态
    @CreatedTimestamp
    private Date createdate; // 创建日期
    @UpdatedTimestamp
    private Date updatedate; // 更新日期
    @OneToMany(mappedBy = "user")
    private Set<UserRoleMap> userRoleMaps; // 用户角色映射信息
    @OneToMany(mappedBy = "user")
    private Set<UserDeptMap> userDeptMaps; // 用户部门映射信息
    @OneToMany(mappedBy = "user")
    private Set<UserJobRoleMap> userJobRoleMaps; // 用户岗位角色映射信息
    @OneToMany(mappedBy = "user")
    private Set<UserExt> userExts; // 用户扩展信息表
    @OneToMany(mappedBy = "createUser")
    private Set<OperLog> operLog; // 操作日志信息
    @Column(nullable = false, columnDefinition = "varchar(1) default 'N'")
    private BasicCase isAdmin; // 是否为管理员

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
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

    public Set<UserRoleMap> getUserRoleMaps() {
        return userRoleMaps;
    }

    public void setUserRoleMaps(Set<UserRoleMap> userRoleMaps) {
        this.userRoleMaps = userRoleMaps;
    }

    public Set<UserDeptMap> getUserDeptMaps() {
        return userDeptMaps;
    }

    public void setUserDeptMaps(Set<UserDeptMap> userDeptMaps) {
        this.userDeptMaps = userDeptMaps;
    }

    public Set<UserJobRoleMap> getUserJobRoleMaps() {
        return userJobRoleMaps;
    }

    public void setUserJobRoleMaps(Set<UserJobRoleMap> userJobRoleMaps) {
        this.userJobRoleMaps = userJobRoleMaps;
    }

    public Set<UserExt> getUserExts() {
        return userExts;
    }

    public void setUserExts(Set<UserExt> userExts) {
        this.userExts = userExts;
    }

    public Set<OperLog> getOperLog() {
        return operLog;
    }

    public void setOperLog(Set<OperLog> operLog) {
        this.operLog = operLog;
    }

    public BasicCase getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(BasicCase isAdmin) {
        this.isAdmin = isAdmin;
    }

}
