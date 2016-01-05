package com.puiui.auth.domain;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import com.puiui.auth.domain.prop.BasicCase;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by zhaiyinghao on 2015/12/16.
 */
@Entity
@Table(name = "auth_menu")
public class Menu extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // id
    @ManyToOne
    @Column(nullable = false)
    private Menu parent; // 父菜单
    @OneToMany(mappedBy = "parent")
    private Set<Menu> children; // 子菜单
    @Column(length = 100, nullable = false)
    private String menuName; // 菜单名称
    @Column(length = 100, nullable = false)
    private String menuUrl; // 菜单url
    @Column(length = 20, nullable = false)
    private String target; // 显示目标
    @Column(length = 500)
    private String menuDesc; // 菜单描述
    @Column(length = 1, nullable = false)
    private Short menuLevel; // 菜单层级
    @Column(nullable = false)
    private Integer sortCode; // 排序码
    @Column(nullable = false)
    private BasicCase isEnabled; // 是否启用
    @CreatedTimestamp
    private Date createdate; // 创建时间
    @UpdatedTimestamp
    private Date updatedate; // 修改时间
    @OneToMany(mappedBy = "menu")
    private Set<RoleMenuMap> roleMenuMaps;
    @Column(length = 50)
    private String iconPath; // 图标路径

    public Menu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public Set<Menu> getChildren() {
        return children;
    }

    public void setChildren(Set<Menu> children) {
        this.children = children;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Short getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Short menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    public BasicCase getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(BasicCase isEnabled) {
        this.isEnabled = isEnabled;
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

    public Set<RoleMenuMap> getRoleMenuMaps() {
        return roleMenuMaps;
    }

    public void setRoleMenuMaps(Set<RoleMenuMap> roleMenuMaps) {
        this.roleMenuMaps = roleMenuMaps;
    }

    public String getTarget() {
        return target;
    }


    public void setTarget(String target) {
        this.target = target;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
