package com.knsg.entity;

import java.util.Date;

public class ChangePostMessage {

    private String handlersId;//处理人id
    private String changeId;//改变职位的员工id
    private String comment;//变化原因
    private Date changeDate;//改变时间
    private Integer changeTent;//改变类型，升1或者降0

    public String getHandlersId() {
        return handlersId;
    }

    public void setHandlersId(String handlersId) {
        this.handlersId = handlersId;
    }

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public Integer getChangeTent() {
        return changeTent;
    }

    public void setChangeTent(Integer changeTent) {
        this.changeTent = changeTent;
    }
}
