package com.puiui.auth.domain;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.DbJson;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import com.puiui.auth.domain.prop.BasicCase;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhaiyinghao on 2015/12/17.
 */
@Entity
@Table(name = "auth_security")
public class Security extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id
    @Column(length = 100, nullable = false, unique = true)
    private String securityName; // 权限名称
    @Column(length = 200, nullable = false, unique = true)
    private String securityConfig; // 权限配置信息
    @Column(length = 500)
    private String securityDesc; // 权限描述
    @CreatedTimestamp
    private Date createdate; // 创建日期
    @UpdatedTimestamp
    private Date updatedate; // 修改日期
    @OneToMany(mappedBy = "security")
    private Set<RoleSecurityMap> roleSecurityMaps; // 角色权限映射
    @ManyToOne
    @Column(nullable = false)
    private SecurityGroup securityGroup;  // 所属组

    public Security() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getSecurityConfig() {
        return securityConfig;
    }

    public void setSecurityConfig(String securityConfig) {
        this.securityConfig = securityConfig;
    }

    public String getSecurityDesc() {
        return securityDesc;
    }

    public void setSecurityDesc(String securityDesc) {
        this.securityDesc = securityDesc;
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

    public Set<RoleSecurityMap> getRoleSecurityMaps() {
        return roleSecurityMaps;
    }

    public void setRoleSecurityMaps(Set<RoleSecurityMap> roleSecurityMaps) {
        this.roleSecurityMaps = roleSecurityMaps;
    }

    public SecurityGroup getSecurityGroup() {
        return securityGroup;
    }

    public void setSecurityGroup(SecurityGroup securityGroup) {
        this.securityGroup = securityGroup;
    }
}
