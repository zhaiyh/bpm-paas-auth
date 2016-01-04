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
@Table(name = "auth_role")
public class Role extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id
    @Column(length = 100, unique = true, nullable = false)
    private String roleName; // 角色名称
    @Column(length = 500)
    private String roleDesc; // 角色描述
    @CreatedTimestamp
    private Date createdate; // 创建时间
    @UpdatedTimestamp
    private Date updatedate; // 修改时间
    @OneToMany(mappedBy = "role")
    private Set<UserRoleMap> userRoleMaps; // 用户角色映射
    @OneToMany(mappedBy = "role")
    private Set<RoleMenuMap> roleMenuMaps; // 角色菜单映射
    @OneToMany(mappedBy = "role")
    private Set<RoleSecurityMap> roleSecurityMaps; // 角色菜单映射
    @ManyToOne
    @Column(nullable = false)
    private RoleGroup roleGroup; // 所属角色组
    @Column(nullable = false)
    private BasicCase isDefault; // 是否为默认角色
    @OneToMany(mappedBy = "role")
    private Set<RoleResourceMap> roleResourceMaps;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
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

    public Set<RoleMenuMap> getRoleMenuMaps() {
        return roleMenuMaps;
    }

    public void setRoleMenuMaps(Set<RoleMenuMap> roleMenuMaps) {
        this.roleMenuMaps = roleMenuMaps;
    }

    public Set<RoleSecurityMap> getRoleSecurityMaps() {
        return roleSecurityMaps;
    }

    public void setRoleSecurityMaps(Set<RoleSecurityMap> roleSecurityMaps) {
        this.roleSecurityMaps = roleSecurityMaps;
    }

    public RoleGroup getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(RoleGroup roleGroup) {
        this.roleGroup = roleGroup;
    }

    public BasicCase getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(BasicCase isDefault) {
        this.isDefault = isDefault;
    }

    public Set<RoleResourceMap> getRoleResourceMaps() {
        return roleResourceMaps;
    }

    public void setRoleResourceMaps(Set<RoleResourceMap> roleResourceMaps) {
        this.roleResourceMaps = roleResourceMaps;
    }
}
