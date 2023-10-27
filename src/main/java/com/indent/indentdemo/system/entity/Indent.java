package com.indent.indentdemo.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author dlx
 * @since 2023-10-23
 */
public class Indent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId//手动标记主键
    private String indentId;

    /**
     * 购买者的openid
     */
    private String openId;

    /**
     * 购买者的昵称
     */
    private String nickName;

    /**
     * 订单标题
     */
    private String indentTitle;

    private String inviteCode;

    /**
     * 订单编号
     */
    private String indentNo;

    /**
     * 产品类型
     */
    private Byte productType;

    /**
     * 订单价格
     */
    private Integer price;

    /**
     * 订单状态
     */
    private Byte indentStatus;

    /**
     * 订单创建时间
     */
    private String createTime;

    /**
     * 订单修改时间
     */
    private String updateTime;

    public String getIndentId() {
        return indentId;
    }

    public void setIndentId(String indentId) {
        this.indentId = indentId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIndentTitle() {
        return indentTitle;
    }

    public void setIndentTitle(String indentTitle) {
        this.indentTitle = indentTitle;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getIndentNo() {
        return indentNo;
    }

    public void setIndentNo(String indentNo) {
        this.indentNo = indentNo;
    }

    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Byte getIndentStatus() {
        return indentStatus;
    }

    public void setIndentStatus(Byte indentStatus) {
        this.indentStatus = indentStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Indent{" +
            "indentId = " + indentId +
            ", openId = " + openId +
            ", nickName = " + nickName +
            ", indentTitle = " + indentTitle +
            ", inviteCode = " + inviteCode +
            ", indentNo = " + indentNo +
            ", productType = " + productType +
            ", price = " + price +
            ", indentStatus = " + indentStatus +
            ", createTime = " + createTime +
            ", updateTime = " + updateTime +
        "}";
    }
}
