package com.czhand.ocms.search.api.dto;

import java.util.Date;

/*
*@author by knight
 */
public class OcmsObjectDTO {
    // '主键',
    private Long id;
    // '项目名称',
    private String objectName;
    // '项目编号',
    private String objectNo;
    // '项目经理',
    private String objectManager;
    //'联系电话'
    private String telephone;
    // 项目开始日期',
    private Date objectStartDate;
    //'项目结束日期',
    private Date objectEndDate;
    //'项目状态',
    private int status;
    // '客户编号',
    private String companyNo;
    // 客户id',
    private Long companyId;
    // '创建人',
    private Long createdBy;
    //创建时间',
    private Date creationDate;
    // '修改人',
    private Long LastUpdatedBy;
    // '修改时间',
    private Date LastUpdateDate;
    // '版本号',
    private Long objectVersionNumber;
    //最后一次沟通时间'
    private Date lastCommunicateDate;
    //逻辑删除
    private int isDel;

    private String companyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectNo() {
        return objectNo;
    }

    public void setObjectNo(String objectNo) {
        this.objectNo = objectNo;
    }

    public String getObjectManager() {
        return objectManager;
    }

    public void setObjectManager(String objectManager) {
        this.objectManager = objectManager;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getObjectStartDate() {
        return objectStartDate;
    }

    public void setObjectStartDate(Date objectStartDate) {
        this.objectStartDate = objectStartDate;
    }

    public Date getObjectEndDate() {
        return objectEndDate;
    }

    public void setObjectEndDate(Date objectEndDate) {
        this.objectEndDate = objectEndDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long  createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastUpdatedBy() {
        return LastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        LastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return LastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        LastUpdateDate = lastUpdateDate;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Date getLastCommunicateDate() {
        return lastCommunicateDate;
    }

    public void setLastCommunicateDate(Date lastCommunicateDate) {
        this.lastCommunicateDate = lastCommunicateDate;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString()
    {
        return "OcmsObjectDTO{" +
                "id=" + id +
                ", objectName='" + objectName + '\'' +
                ", objectNo='" + objectNo + '\'' +
                ", objectManager='" + objectManager + '\'' +
                ", telephone='" + telephone + '\'' +
                ", objectStartDate=" + objectStartDate +
                ", objectEndDate=" + objectEndDate +
                ", status=" + status +
                ", companyNo='" + companyNo + '\'' +
                ", companyId=" + companyId +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", LastUpdatedBy=" + LastUpdatedBy +
                ", LastUpdateDate=" + LastUpdateDate +
                ", objectVersionNumber=" + objectVersionNumber +
                ", lastCommunicateDate=" + lastCommunicateDate +
                ", isDel=" + isDel +
                ",companyName="+companyName+
                '}';
    }
}