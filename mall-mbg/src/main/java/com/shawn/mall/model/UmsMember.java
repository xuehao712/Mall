package com.shawn.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UmsMember implements Serializable {
    private Long id;

    private Long memberLevelId;

    @ApiModelProperty(value = "username")
    private String username;

    @ApiModelProperty(value = "password")
    private String password;

    @ApiModelProperty(value = "nickname")
    private String nickname;

    @ApiModelProperty(value = "phone")
    private String phone;

    @ApiModelProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "account status:0->no；1->yes")
    private Integer status;

    @ApiModelProperty(value = "register time")
    private Date createTime;

    @ApiModelProperty(value = "icon")
    private String icon;

    @ApiModelProperty(value = "gender：0->unknow；1->male；2->female")
    private Integer gender;

    @ApiModelProperty(value = "birthday")
    private Date birthday;

    @ApiModelProperty(value = "city")
    private String city;

    @ApiModelProperty(value = "job")
    private String job;

    @ApiModelProperty(value = "personlized description")
    private String personalizedSignature;

    @ApiModelProperty(value = "source type")
    private Integer sourceType;

    @ApiModelProperty(value = "integration")
    private Integer integration;

    @ApiModelProperty(value = "growth")
    private Integer growth;

    @ApiModelProperty(value = "lucky draw")
    private Integer luckyCount;

    @ApiModelProperty(value = "history integration count")
    private Integer historyIntegration;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getLuckyCount() {
        return luckyCount;
    }

    public void setLuckyCount(Integer luckyCount) {
        this.luckyCount = luckyCount;
    }

    public Integer getHistoryIntegration() {
        return historyIntegration;
    }

    public void setHistoryIntegration(Integer historyIntegration) {
        this.historyIntegration = historyIntegration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberLevelId=").append(memberLevelId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", icon=").append(icon);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", city=").append(city);
        sb.append(", job=").append(job);
        sb.append(", personalizedSignature=").append(personalizedSignature);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", integration=").append(integration);
        sb.append(", growth=").append(growth);
        sb.append(", luckyCount=").append(luckyCount);
        sb.append(", historyIntegration=").append(historyIntegration);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}