package com.puiui.auth.domain;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaiyinghao on 2015/12/31.
 */
@Entity
@Table(name = "auth_user_ext")
public class UserExt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @Column(unique = true, nullable = false)
    private User user;
    @CreatedTimestamp
    private Date createdate;
    @UpdatedTimestamp
    private Date updatedate;

    public UserExt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
