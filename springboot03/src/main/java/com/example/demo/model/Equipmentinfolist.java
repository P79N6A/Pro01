package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

/*
 created by zhoujun on 2018/6/19
 */
public class Equipmentinfolist {


    private Long id;

    private String equipmentNo;

    private String equipmentLocation;

    private BigDecimal pressure;

    private String status00;

    private String status01;

    private String status02;

    private String status03;

    private String status04;

    private String status05;

    private String status06;

    private String status07;

    private BigDecimal hrTemp;

    private BigDecimal pressTraTemp;

    private BigDecimal pressTraVoltage;

    private BigDecimal nbiotVoltage;

    private String status10;

    private String status11;

    private String status12;

    private String status13;

    private String status14;

    private String status15;

    private String status16;

    private BigDecimal angleOfInclination;

    private Date createdate;

    private Integer flag;

    private Long equipmentid;

    public Equipmentinfolist(Long id, String equipmentNo, String equipmentLocation, BigDecimal pressure, String status00, String status01, String status02, String status03, String status04, String status05, String status06, String status07, BigDecimal hrTemp, BigDecimal pressTraTemp, BigDecimal pressTraVoltage, BigDecimal nbiotVoltage, String status10, String status11, String status12, String status13, String status14, String status15, String status16, BigDecimal angleOfInclination, Date createdate, Integer flag, Long equipmentid) {
        this.id = id;
        this.equipmentNo = equipmentNo;
        this.equipmentLocation = equipmentLocation;
        this.pressure = pressure;
        this.status00 = status00;
        this.status01 = status01;
        this.status02 = status02;
        this.status03 = status03;
        this.status04 = status04;
        this.status05 = status05;
        this.status06 = status06;
        this.status07 = status07;
        this.hrTemp = hrTemp;
        this.pressTraTemp = pressTraTemp;
        this.pressTraVoltage = pressTraVoltage;
        this.nbiotVoltage = nbiotVoltage;
        this.status10 = status10;
        this.status11 = status11;
        this.status12 = status12;
        this.status13 = status13;
        this.status14 = status14;
        this.status15 = status15;
        this.status16 = status16;
        this.angleOfInclination = angleOfInclination;
        this.createdate = createdate;
        this.flag = flag;
        this.equipmentid = equipmentid;
    }

    public Equipmentinfolist() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo == null ? null : equipmentNo.trim();
    }

    public String getEquipmentLocation() {
        return equipmentLocation;
    }

    public void setEquipmentLocation(String equipmentLocation) {
        this.equipmentLocation = equipmentLocation == null ? null : equipmentLocation.trim();
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public String getStatus00() {
        return status00;
    }

    public void setStatus00(String status00) {
        this.status00 = status00 == null ? null : status00.trim();
    }

    public String getStatus01() {
        return status01;
    }

    public void setStatus01(String status01) {
        this.status01 = status01 == null ? null : status01.trim();
    }

    public String getStatus02() {
        return status02;
    }

    public void setStatus02(String status02) {
        this.status02 = status02 == null ? null : status02.trim();
    }

    public String getStatus03() {
        return status03;
    }

    public void setStatus03(String status03) {
        this.status03 = status03 == null ? null : status03.trim();
    }

    public String getStatus04() {
        return status04;
    }

    public void setStatus04(String status04) {
        this.status04 = status04 == null ? null : status04.trim();
    }

    public String getStatus05() {
        return status05;
    }

    public void setStatus05(String status05) {
        this.status05 = status05 == null ? null : status05.trim();
    }

    public String getStatus06() {
        return status06;
    }

    public void setStatus06(String status06) {
        this.status06 = status06 == null ? null : status06.trim();
    }

    public String getStatus07() {
        return status07;
    }

    public void setStatus07(String status07) {
        this.status07 = status07 == null ? null : status07.trim();
    }

    public BigDecimal getHrTemp() {
        return hrTemp;
    }

    public void setHrTemp(BigDecimal hrTemp) {
        this.hrTemp = hrTemp;
    }

    public BigDecimal getPressTraTemp() {
        return pressTraTemp;
    }

    public void setPressTraTemp(BigDecimal pressTraTemp) {
        this.pressTraTemp = pressTraTemp;
    }

    public BigDecimal getPressTraVoltage() {
        return pressTraVoltage;
    }

    public void setPressTraVoltage(BigDecimal pressTraVoltage) {
        this.pressTraVoltage = pressTraVoltage;
    }

    public BigDecimal getNbiotVoltage() {
        return nbiotVoltage;
    }

    public void setNbiotVoltage(BigDecimal nbiotVoltage) {
        this.nbiotVoltage = nbiotVoltage;
    }

    public String getStatus10() {
        return status10;
    }

    public void setStatus10(String status10) {
        this.status10 = status10 == null ? null : status10.trim();
    }

    public String getStatus11() {
        return status11;
    }

    public void setStatus11(String status11) {
        this.status11 = status11 == null ? null : status11.trim();
    }

    public String getStatus12() {
        return status12;
    }

    public void setStatus12(String status12) {
        this.status12 = status12 == null ? null : status12.trim();
    }

    public String getStatus13() {
        return status13;
    }

    public void setStatus13(String status13) {
        this.status13 = status13 == null ? null : status13.trim();
    }

    public String getStatus14() {
        return status14;
    }

    public void setStatus14(String status14) {
        this.status14 = status14 == null ? null : status14.trim();
    }

    public String getStatus15() {
        return status15;
    }

    public void setStatus15(String status15) {
        this.status15 = status15 == null ? null : status15.trim();
    }

    public String getStatus16() {
        return status16;
    }

    public void setStatus16(String status16) {
        this.status16 = status16 == null ? null : status16.trim();
    }

    public BigDecimal getAngleOfInclination() {
        return angleOfInclination;
    }

    public void setAngleOfInclination(BigDecimal angleOfInclination) {
        this.angleOfInclination = angleOfInclination;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Long getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(Long equipmentid) {
        this.equipmentid = equipmentid;
    }
    @Override
    public String toString() {
        return "Equipmentinfolist{" +
                "id=" + id +
                ", equipmentNo='" + equipmentNo + '\'' +
                ", equipmentLocation='" + equipmentLocation + '\'' +
                ", pressure=" + pressure +
                ", status00='" + status00 + '\'' +
                ", status01='" + status01 + '\'' +
                ", status02='" + status02 + '\'' +
                ", status03='" + status03 + '\'' +
                ", status04='" + status04 + '\'' +
                ", status05='" + status05 + '\'' +
                ", status06='" + status06 + '\'' +
                ", status07='" + status07 + '\'' +
                ", hrTemp=" + hrTemp +
                ", pressTraTemp=" + pressTraTemp +
                ", pressTraVoltage=" + pressTraVoltage +
                ", nbiotVoltage=" + nbiotVoltage +
                ", status10='" + status10 + '\'' +
                ", status11='" + status11 + '\'' +
                ", status12='" + status12 + '\'' +
                ", status13='" + status13 + '\'' +
                ", status14='" + status14 + '\'' +
                ", status15='" + status15 + '\'' +
                ", status16='" + status16 + '\'' +
                ", angleOfInclination=" + angleOfInclination +
                ", createdate=" + createdate +
                ", flag=" + flag +
                ", equipmentid=" + equipmentid +
                '}';
    }
}