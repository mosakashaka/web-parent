package org.mosakashaka.web.base.model;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseModel
        implements Serializable
{
    protected Long id;
    public Integer deleted;
    public Long createUser;
    public Date createTime;
    public Long updateUser;
    public Date updateTime;

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Long getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true; if (!(o instanceof BaseModel)) return false; BaseModel other = (BaseModel)o; if (!other.canEqual(this)) return false; Object this$id = getId(); Object other$id = other.getId(); if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false; Object this$deleted = getDeleted(); Object other$deleted = other.getDeleted(); if (this$deleted == null ? other$deleted != null : !this$deleted.equals(other$deleted)) return false; Object this$createUser = getCreateUser(); Object other$createUser = other.getCreateUser(); if (this$createUser == null ? other$createUser != null : !this$createUser.equals(other$createUser)) return false; Object this$createTime = getCreateTime(); Object other$createTime = other.getCreateTime(); if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime)) return false; Object this$updateUser = getUpdateUser(); Object other$updateUser = other.getUpdateUser(); if (this$updateUser == null ? other$updateUser != null : !this$updateUser.equals(other$updateUser)) return false; Object this$updateTime = getUpdateTime(); Object other$updateTime = other.getUpdateTime(); return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime); }
    protected boolean canEqual(Object other) { return other instanceof BaseModel; }
    public int hashCode() { int PRIME = 59; int result = 1; Object $id = getId(); result = result * 59 + ($id == null ? 43 : $id.hashCode()); Object $deleted = getDeleted(); result = result * 59 + ($deleted == null ? 43 : $deleted.hashCode()); Object $createUser = getCreateUser(); result = result * 59 + ($createUser == null ? 43 : $createUser.hashCode()); Object $createTime = getCreateTime(); result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode()); Object $updateUser = getUpdateUser(); result = result * 59 + ($updateUser == null ? 43 : $updateUser.hashCode()); Object $updateTime = getUpdateTime(); return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
    }
}
