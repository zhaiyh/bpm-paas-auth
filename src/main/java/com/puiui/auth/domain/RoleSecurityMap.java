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
@Table(name = "auth_role_security_map")
public class RoleSecurityMap extends Model{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id
    @ManyToOne
    @Column(nullable = false)
    private Role role; // 角色
    @ManyToOne
    @Column(nullable = false)
    private Security security; // 资源
    @CreatedTimestamp
    private Date createdate; // 创建日期
    @UpdatedTimestamp
    private Date updatedate; // 修改日期

    public RoleSecurityMap() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
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
