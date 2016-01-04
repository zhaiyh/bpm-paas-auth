package com.puiui.auth.web.dto;

/**
 * Created by zhaiyinghao on 2016/1/3.
 */
public class DeptDto {
    /**
     * {
     *      "id": 1,
     *      "text": "北京总公司",
     *      "sortCode": 1,
     *      "url": "#test",
     *      "target": "#home"
     * }
     */
    private Long id;
    private String deptName;
    private String url;
    private String target;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
}
