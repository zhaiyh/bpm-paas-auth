package com.puiui.auth.domain;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaiyinghao on 2015/12/17.
 */
@Entity
@Table(name = "auth_user_role_map")
public class UserRoleMap extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id
    @ManyToOne
    @Column(nullable = false)
    private User user; // 用户信息
    @ManyToOne
    @Column(nullable = false)
    private Role role; // 权限信息
    @CreatedTimestamp
    private Date createdate; // 创建日期
    @UpdatedTimestamp
    private Date updatedate; // 修改日期

    public UserRoleMap() {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
}
