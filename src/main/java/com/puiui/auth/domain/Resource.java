package com.puiui.auth.domain;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by zhaiyinghao on 2016/1/2.
 */
@Entity
@Table(name = "auth_resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String resourceName;
    @Column(length = 200, nullable = false, unique = true)
    private String resourceConfig;
    @Column(length = 500)
    private String resourceDesc;
    @CreatedTimestamp
    private Date createdate;
    @UpdatedTimestamp
    private Date updatedate;
    @ManyToOne
    @Column(nullable = false)
    private ResourceGroup resourceGroup;
    @OneToMany(mappedBy = "resource")
    private Set<RoleResourceMap> roleResourceMaps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceConfig() {
        return resourceConfig;
    }

    public void setResourceConfig(String resourceConfig) {
        this.resourceConfig = resourceConfig;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
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

    public ResourceGroup getResourceGroup() {
        return resourceGroup;
    }

    public void setResourceGroup(ResourceGroup resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    public Set<RoleResourceMap> getRoleResourceMaps() {
        return roleResourceMaps;
    }

    public void setRoleResourceMaps(Set<RoleResourceMap> roleResourceMaps) {
        this.roleResourceMaps = roleResourceMaps;
    }
}
