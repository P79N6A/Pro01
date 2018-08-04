package com.czhand.ocms.search.api.dto;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

/**
 * 外协顾问基本信息领域模型
 * @author zxs
 */
public class OcmsResumeDTO {
    /**
     * 主键(外协工号)
     */

//    @Field
    private Long id;
    /**
     * 移动电话
     */
    @Field
    private String mobile;
    /**
     * 证件号码
     */
    @Field
    private String idCard;
    /**
     * 证件类型
     */
    @Field
    private Long idCardType;
    /**
     * 姓名
     */
    @Field
    private String name;
    /**
     * 性别
     */
    @Field
    private Long sex;

    /**
     * 出生日期
     */
    @Field
    private Date birthday;

    /**
     * 是否有效
     */
    @Field
    private Integer isEffective;
    /**
     * 期望薪资
     */
    @Field
    private double expectationSalary;
    /**
     * 邮箱
     */
    @Field
    private String email;
    /**
     * 最高学历
     */
    @Field
    private Long education;
    /**
     * 毕业院校
     */
    @Field
    private String university;
    /**
     * 常居地
     */
    @Field
    private String residence;
    /**
     * 从业年限
     */
    @Field
    private Long workYear;
    /**
     * 评估级别
     */
    @Field
    private String evaluationLevel;
    /**
     * 擅长模块
     */
    @Field
    private String skills;
    /**
     * 照片
     */
    @Field
    private String photo;
    /**
     * 计划出项目日期
     */
    @Field
    private Date endWorkDate;

    /**
     * 其他备注
     */
    @Field
    private String otherRemarks;

    /**
     * 是否删除
     */
    @Field
    private Integer isDel;
    /**
     * 登录名
     */
    @Field
    private String loginName;
    /**
     * 密码
     */
    @Field
    private String password;

    /**
     * 创建人
     */
    @Field
    private Long createdBy;
    /**
     * 创建时间
     */
    @Field
    private Date creationDate;
    /**
     * 修改人
     */
    @Field
    private Long lastUpdatedBy;
    /**
     * 修改时间
     */
    @Field
    private Date lastUpdateDate;
    /**
     * 版本号
     */
    @Field
    private Long objectVersionNumber;

    /**
     * 最后一次沟通时间
     */
    @Field
    private Date lastCommunicateDate2;

    @Field
    private String qqNum;

    /**
     * 主键(外协工号)
     */
    public Long getId(){
        return this.id;
    }

    /**
     * 主键(外协工号)
     */
    public void setId(Long id){
        this.id = id;
    }
    /**
     * 移动电话
     */
    public String getMobile(){
        return this.mobile;
    }

    /**
     * 移动电话
     */
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    /**
     * 证件号码
     */
    public String getIdCard(){
        return this.idCard;
    }

    /**
     * 证件号码
     */
    public void setIdCard(String idCard){
        this.idCard = idCard;
    }
    /**
     * 证件类型
     */
    public Long getIdCardType(){
        return this.idCardType;
    }

    /**
     * 证件类型
     */
    public void setIdCardType(Long idCardType){
        this.idCardType = idCardType;
    }
    /**
     * 姓名
     */
    public String getName(){
        return this.name;
    }

    /**
     * 姓名
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * 性别
     */
    public Long getSex(){
        return this.sex;
    }

    /**
     * 性别
     */
    public void setSex(Long sex){
        this.sex = sex;
    }
    /**
     * 是否有效
     */
    public Integer getIsEffective(){
        return this.isEffective;
    }

    /**
     * 是否有效
     */
    public void setIsEffective(Integer isEffective){
        this.isEffective = isEffective;
    }
    /**
     * 期望薪资
     */
    public double getExpectationSalary(){
        return this.expectationSalary;
    }

    /**
     * 期望薪资
     */
    public void setExpectationSalary(double expectationSalary){
        this.expectationSalary = expectationSalary;
    }
    /**
     * 邮箱
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * 邮箱
     */
    public void setEmail(String email){
        this.email = email;
    }
    /**
     * 最高学历
     */
    public Long getEducation(){
        return this.education;
    }

    /**
     * 最高学历
     */
    public void setEducation(Long education){
        this.education = education;
    }
    /**
     * 毕业院校
     */
    public String getUniversity(){
        return this.university;
    }

    /**
     * 毕业院校
     */
    public void setUniversity(String university){
        this.university = university;
    }
    /**
     * 常居地
     */
    public String getResidence(){
        return this.residence;
    }

    /**
     * 常居地
     */
    public void setResidence(String residence){
        this.residence = residence;
    }
    /**
     * 从业年限
     */
    public Long getWorkYear(){
        return this.workYear;
    }

    /**
     * 从业年限
     */
    public void setWorkYear(Long workYear){
        this.workYear = workYear;
    }
    /**
     * 评估级别
     */
    public String getEvaluationLevel(){
        return this.evaluationLevel;
    }

    /**
     * 评估级别
     */
    public void setEvaluationLevel(String evaluationLevel){
        this.evaluationLevel = evaluationLevel;
    }
    /**
     * 擅长模块
     */
    public String getSkills(){
        return this.skills;
    }

    /**
     * 擅长模块
     */
    public void setSkills(String skills){
        this.skills = skills;
    }
    /**
     * 照片
     */
    public String getPhoto(){
        return this.photo;
    }

    /**
     * 照片
     */
    public void setPhoto(String photo){
        this.photo = photo;
    }
    /**
     * 计划出项目日期
     */
    public Date getEndWorkDate(){
        return this.endWorkDate;
    }

    /**
     * 计划出项目日期
     */
    public void setEndWorkDate(Date endWorkDate){
        this.endWorkDate = endWorkDate;
    }
    /**
     * 是否删除
     */
    public Integer getIsDel(){
        return this.isDel;
    }

    /**
     * 是否删除
     */
    public void setIsDel(Integer isDel){
        this.isDel = isDel;
    }
    /**
     * 登录名
     */
    public String getLoginName(){
        return this.loginName;
    }

    /**
     * 登录名
     */
    public void setLoginName(String loginName){
        this.loginName = loginName;
    }
    /**
     * 密码
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * 密码
     */
    public void setPassword(String password){
        this.password = password;
    }
    /**
     * 创建人
     */
    public Long getCreatedBy(){
        return this.createdBy;
    }

    /**
     * 创建人
     */
    public void setCreatedBy(Long createdBy){
        this.createdBy = createdBy;
    }
    /**
     * 创建时间
     */
    public Date getCreationDate(){
        return this.creationDate;
    }

    /**
     * 创建时间
     */
    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }
    /**
     * 修改人
     */
    public Long getLastUpdatedBy(){
        return this.lastUpdatedBy;
    }

    /**
     * 修改人
     */
    public void setLastUpdatedBy(Long lastUpdatedBy){
        this.lastUpdatedBy = lastUpdatedBy;
    }
    /**
     * 修改时间
     */
    public Date getLastUpdateDate(){
        return this.lastUpdateDate;
    }

    /**
     * 修改时间
     */
    public void setLastUpdateDate(Date lastUpdateDate){
        this.lastUpdateDate = lastUpdateDate;
    }
    /**
     * 版本号
     */
    public Long getObjectVersionNumber(){
        return this.objectVersionNumber;
    }

    /**
     * 版本号
     */
    public void setObjectVersionNumber(Long objectVersionNumber){
        this.objectVersionNumber = objectVersionNumber;
    }
    /**
     * 最后一次沟通时间
     */
    public Date getLastCommunicateDate2(){
        return this.lastCommunicateDate2;
    }

    /**
     * 最后一次沟通时间
     */
    public void setLastCommunicateDate2(Date lastCommunicateDate2){
        this.lastCommunicateDate2 = lastCommunicateDate2;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOtherRemarks() {
        return otherRemarks;
    }

    public void setOtherRemarks(String otherRemarks) {
        this.otherRemarks = otherRemarks;
    }

    @Override
    public String toString() {
        return "OcmsResumeE{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", idCard='" + idCard + '\'' +
                ", idCardType=" + idCardType +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", isEffective=" + isEffective +
                ", expectationSalary=" + expectationSalary +
                ", email='" + email + '\'' +
                ", education=" + education +
                ", university='" + university + '\'' +
                ", residence='" + residence + '\'' +
                ", workYear=" + workYear +
                ", evaluationLevel=" + evaluationLevel +
                ", skills='" + skills + '\'' +
                ", photo='" + photo + '\'' +
                ", endWorkDate=" + endWorkDate +
                ", otherRemarks=" + otherRemarks +
                ", isDel=" + isDel +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", objectVersionNumber=" + objectVersionNumber +
                ", lastCommunicateDate2=" + lastCommunicateDate2 +
                ", qqNum='" + qqNum + '\'' +
                '}';
    }
}