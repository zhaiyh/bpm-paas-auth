package com.puiui.auth.domain;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.puiui.auth.domain.prop.OperType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaiyinghao on 2015/12/17.
 */
@Entity
@Table(name = "auth_oper_log")
public class OperLog extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, updatable = false)
    private OperType operType;
    @Column(nullable = false, length = 500)
    private String operContent;
    @CreatedTimestamp
    private Date createdate;
    @ManyToOne
    private User createUser;

    public OperLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperType getOperType() {
        return operType;
    }

    public void setOperType(OperType operType) {
        this.operType = operType;
    }

    public String getOperContent() {
        return operContent;
    }

    public void setOperContent(String operContent) {
        this.operContent = operContent;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }
}
