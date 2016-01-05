package com.puiui.auth.web.dto;

/**
 * Created by Administrator on 2016/1/5.
 */
public class TreeDto {
    private String name; // 显示的名称
    private Long id; // 节点id
    private Long pId; // 父节点id
    private String url; // 节点的链接
    private String target; // 链接的目标
    private String icon; // 节点显示的图标

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }
}
