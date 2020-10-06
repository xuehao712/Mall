package com.shawn.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OmsOrder implements Serializable {
    @ApiModelProperty(value = "order id")
    private Long id;

    private Long memberId;

    private Long couponId;

    @ApiModelProperty(value = "order number")
    private String orderSn;

    @ApiModelProperty(value = "create time")
    private Date createTime;

    @ApiModelProperty(value = "member username")
    private String memberUsername;

    @ApiModelProperty(value = "order total amount")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "pay amount")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "shipment amount")
    private BigDecimal freightAmount;

    @ApiModelProperty(value = "promotion amount")
    private BigDecimal promotionAmount;

    @ApiModelProperty(value = "integration amount")
    private BigDecimal integrationAmount;

    @ApiModelProperty(value = "coupon amount")
    private BigDecimal couponAmount;

    @ApiModelProperty(value = "admin backend adjust discount amount")
    private BigDecimal discountAmount;

    @ApiModelProperty(value = "payment method：0->unpaid；1->card；2->paypal")
    private Integer payType;

    private String cardNumber;

    private String cardExpiration;

    private String paypalId;

    @ApiModelProperty(value = "order type：0->pc order；1->app order")
    private Integer sourceType;

    @ApiModelProperty(value = "order status：0->unpaid；1->unshipped；2->shipped；3->finished；4->closed；5->invalid order")
    private Integer status;

    @ApiModelProperty(value = "order type：0->normal order；1->spike order")
    private Integer orderType;

    @ApiModelProperty(value = "logistics company")
    private String deliveryCompany;

    @ApiModelProperty(value = "tracking number")
    private String deliverySn;

    @ApiModelProperty(value = "auto confirm day")
    private Integer autoConfirmDay;

    @ApiModelProperty(value = "integration")
    private Integer integration;

    @ApiModelProperty(value = "growth")
    private Integer growth;

    @ApiModelProperty(value = "promotion info")
    private String promotionInfo;

    @ApiModelProperty(value = "receipt type：0->no；1->electronic；2->paper")
    private Integer billType;

    @ApiModelProperty(value = "receipt header")
    private String billHeader;

    @ApiModelProperty(value = "receiptcontent")
    private String billContent;

    @ApiModelProperty(value = "recipient phone")
    private String billReceiverPhone;

    @ApiModelProperty(value = "recipient email")
    private String billReceiverEmail;

    @ApiModelProperty(value = "receiver name")
    private String receiverName;

    @ApiModelProperty(value = "receiver phone")
    private String receiverPhone;

    @ApiModelProperty(value = "receiver zip code")
    private String receiverZipCode;

    @ApiModelProperty(value = "state")
    private String receiverState;

    @ApiModelProperty(value = "city")
    private String receiverCity;

    @ApiModelProperty(value = "detail address")
    private String receiverDetailAddress;

    @ApiModelProperty(value = "order note")
    private String note;

    @ApiModelProperty(value = "confirm received status：0->no；1->yes")
    private Integer confirmStatus;

    @ApiModelProperty(value = "delete status：0->no；1->yes")
    private Integer deleteStatus;

    @ApiModelProperty(value = "used integration")
    private Integer useIntegration;

    @ApiModelProperty(value = "payment time")
    private Date paymentTime;

    @ApiModelProperty(value = "received time")
    private Date deliveryTime;

    @ApiModelProperty(value = "confirm received time")
    private Date receiveTime;

    @ApiModelProperty(value = "comment time")
    private Date commentTime;

    @ApiModelProperty(value = "modify date")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getIntegrationAmount() {
        return integrationAmount;
    }

    public void setIntegrationAmount(BigDecimal integrationAmount) {
        this.integrationAmount = integrationAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiration() {
        return cardExpiration;
    }

    public void setCardExpiration(String cardExpiration) {
        this.cardExpiration = cardExpiration;
    }

    public String getPaypalId() {
        return paypalId;
    }

    public void setPaypalId(String paypalId) {
        this.paypalId = paypalId;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public Integer getAutoConfirmDay() {
        return autoConfirmDay;
    }

    public void setAutoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
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

    public String getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public String getBillHeader() {
        return billHeader;
    }

    public void setBillHeader(String billHeader) {
        this.billHeader = billHeader;
    }

    public String getBillContent() {
        return billContent;
    }

    public void setBillContent(String billContent) {
        this.billContent = billContent;
    }

    public String getBillReceiverPhone() {
        return billReceiverPhone;
    }

    public void setBillReceiverPhone(String billReceiverPhone) {
        this.billReceiverPhone = billReceiverPhone;
    }

    public String getBillReceiverEmail() {
        return billReceiverEmail;
    }

    public void setBillReceiverEmail(String billReceiverEmail) {
        this.billReceiverEmail = billReceiverEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverZipCode() {
        return receiverZipCode;
    }

    public void setReceiverZipCode(String receiverZipCode) {
        this.receiverZipCode = receiverZipCode;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(Integer useIntegration) {
        this.useIntegration = useIntegration;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", couponId=").append(couponId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", createTime=").append(createTime);
        sb.append(", memberUsername=").append(memberUsername);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", freightAmount=").append(freightAmount);
        sb.append(", promotionAmount=").append(promotionAmount);
        sb.append(", integrationAmount=").append(integrationAmount);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", payType=").append(payType);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", cardExpiration=").append(cardExpiration);
        sb.append(", paypalId=").append(paypalId);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", status=").append(status);
        sb.append(", orderType=").append(orderType);
        sb.append(", deliveryCompany=").append(deliveryCompany);
        sb.append(", deliverySn=").append(deliverySn);
        sb.append(", autoConfirmDay=").append(autoConfirmDay);
        sb.append(", integration=").append(integration);
        sb.append(", growth=").append(growth);
        sb.append(", promotionInfo=").append(promotionInfo);
        sb.append(", billType=").append(billType);
        sb.append(", billHeader=").append(billHeader);
        sb.append(", billContent=").append(billContent);
        sb.append(", billReceiverPhone=").append(billReceiverPhone);
        sb.append(", billReceiverEmail=").append(billReceiverEmail);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverPhone=").append(receiverPhone);
        sb.append(", receiverZipCode=").append(receiverZipCode);
        sb.append(", receiverState=").append(receiverState);
        sb.append(", receiverCity=").append(receiverCity);
        sb.append(", receiverDetailAddress=").append(receiverDetailAddress);
        sb.append(", note=").append(note);
        sb.append(", confirmStatus=").append(confirmStatus);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", useIntegration=").append(useIntegration);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", deliveryTime=").append(deliveryTime);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", commentTime=").append(commentTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}