package com.czhand.ocms.search.api.dto;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author HuangZeDong
 * @date 2018/7/3 @time：15:24
 **/


public class OcmsDemandDTO {
    /**
     * 主键
     */
    private Long id;
    /**
     *外协申请号
     */
    @Field
    private String demandNo;
    /**
     *申请状态
     */
    @Field
    private Integer status;
    /**
     *需求描述
     */
    @Field
    private String requirementDescription;
    /**
     *需求顾问角色
     */
    @Field
    private Long demandConsultantRole;
    /**
     *系统
     */
    @Field
    private String type;
    /**
     *模块
     */
    @Field
    private String modular;
    /**
     *从业年限
     */
    @Field
    private Long employmentTime;
    /**
     *工作地点
     */
    @Field
    private String workAddress;
    /**
     *是否包住宿
     */
    @Field
    private Integer isBoard;
    /**
     *需求开始日
     */
    @DateTimeFormat
    @Field
    private Date remandStartDate;
    /**
     *需求周期
     */
    @Field
    private String remandCycle;
    /**
     *价格
     */
    @Field
    private Double price;
    /**
     *价格单位
     */
    @Field
    private Long priceUnit;
    /**
     *审批人id
     */
    @Field
    private Long examineId;
    /**
     *审批状态
     */
    @Field
    private Integer examineStatus;
    /**
     *流程节点id
     */
    @Field
    private Long processNodeId;
    /**
     *创建人
     */
    @Field
    private Long createdBy;
    /**
     *创建时间
     */
    @DateTimeFormat
    @Field
    private Date creationDate;
    /**
     *修改人
     */
    @Field
    private Long lastUpdatedBy;
    /**
     *修改时间
     */
    @DateTimeFormat
    @Field
    private Date lastUpdateDate;
    /**
     *版本号
     */
    @Field
    private Long objectVersionNumber;

    @Field
    private Long ocmsObjectId;
    @Field
    private Long ocmsCompanyId;

    @Field
    private String corporateName;

    @Field
    private String objectName;

    @Field
    private Date applicationDate;

    @Field
    private Long tel;


//    审批人登录姓名
    private String examineName;

//     审批人真实姓名
    private String examineRealName;

//      需求报名人数
    private Integer participantNumber;

    public Integer getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(Integer participantNumber) {
        this.participantNumber = participantNumber;
    }

    public Date getApplicationDate()
    {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate)
    {
        this.applicationDate = applicationDate;
    }

    public Long getTel()
    {
        return tel;
    }

    public void setTel(Long tel)
    {
        this.tel = tel;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    /**
     * 封装
     *
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDemandNo() {
        return demandNo;
    }

    public void setDemandNo(String demandNo) {
        this.demandNo = demandNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRequirementDescription() {
        return requirementDescription;
    }

    public void setRequirementDescription(String requirementDescription) {
        this.requirementDescription = requirementDescription;
    }

    public Long getDemandConsultantRole() {
        return demandConsultantRole;
    }

    public void setDemandConsultantRole(Long demandConsultantRole) {
        this.demandConsultantRole = demandConsultantRole;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModular() {
        return modular;
    }

    public void setModular(String modular) {
        this.modular = modular;
    }

    public Long getEmploymentTime() {
        return employmentTime;
    }

    public void setEmploymentTime(Long employmentTime) {
        this.employmentTime = employmentTime;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public Integer getIsBoard() {
        return isBoard;
    }

    public void setIsBoard(Integer isBoard) {
        this.isBoard = isBoard;
    }

    public Date getRemandStartDate() { return remandStartDate; }

    public void setRemandStartDate(Date remandStartDate) { this.remandStartDate = remandStartDate; }

    public String getRemandCycle() {
        return remandCycle;
    }

    public void setRemandCycle(String remandCycle) {
        this.remandCycle = remandCycle;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Long priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Long getExamineId() {
        return examineId;
    }

    public void setExamineId(Long examineId) {
        this.examineId = examineId;
    }

    public Integer getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(Integer examineStatus) {
        this.examineStatus = examineStatus;
    }

    public Long getProcessNodeId() {
        return processNodeId;
    }

    public void setProcessNodeId(Long processNodeId) {
        this.processNodeId = processNodeId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Long getOcmsObjectId() {
        return ocmsObjectId;
    }

    public void setOcmsObjectId(Long ocmsObjectId) {
        this.ocmsObjectId = ocmsObjectId;
    }

    public Long getOcmsCompanyId() {
        return ocmsCompanyId;
    }

    public void setOcmsCompanyId(Long ocmsCompanyId) {
        this.ocmsCompanyId = ocmsCompanyId;
    }

    public String getExamineName() {
        return examineName;
    }

    public void setExamineName(String examineName) {
        this.examineName = examineName;
    }

    public String getExamineRealName() {
        return examineRealName;
    }

    public void setExamineRealName(String examineRealName) {
        this.examineRealName = examineRealName;
    }

    @Override
    public String toString()
    {
        return "OcmsDemandE{" +
                "id=" + id +
                ", demandNo='" + demandNo + '\'' +
                ", status=" + status +
                ", requirementDescription='" + requirementDescription + '\'' +
                ", demandConsultantRole=" + demandConsultantRole +
                ", type='" + type + '\'' +
                ", modular='" + modular + '\'' +
                ", employmentTime=" + employmentTime +
                ", workAddress='" + workAddress + '\'' +
                ", isBoard=" + isBoard +
                ", remandStartDate=" + remandStartDate +
                ", remandCycle='" + remandCycle + '\'' +
                ", price=" + price +
                ", priceUnit=" + priceUnit +
                ", examineId=" + examineId +
                ", examineStatus=" + examineStatus +
                ", processNodeId=" + processNodeId +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", objectVersionNumber=" + objectVersionNumber +
                ", ocmsObjectId=" + ocmsObjectId +
                ", ocmsCompanyId=" + ocmsCompanyId +
                ", corporateName='" + corporateName + '\'' +
                ", objectName='" + objectName + '\'' +
                ", applicationDate=" + applicationDate +
                ", tel=" + tel +
                '}';
    }
}
