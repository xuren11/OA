package com.xuren.oa.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("ExpenseAccount")
public class ExpenseAccount {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expense_account.id
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expense_account.cause
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private String cause;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expense_account.create_sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private String createSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expense_account.create_time
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expense_account.next_deal_sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private String nextDealSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expense_account.total_amount
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private Double totalAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expense_account.STATUS
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expense_account.id
     *
     * @return the value of expense_account.id
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expense_account.id
     *
     * @param id the value for expense_account.id
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expense_account.cause
     *
     * @return the value of expense_account.cause
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public String getCause() {
        return cause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expense_account.cause
     *
     * @param cause the value for expense_account.cause
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expense_account.create_sn
     *
     * @return the value of expense_account.create_sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public String getCreateSn() {
        return createSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expense_account.create_sn
     *
     * @param createSn the value for expense_account.create_sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setCreateSn(String createSn) {
        this.createSn = createSn == null ? null : createSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expense_account.create_time
     *
     * @return the value of expense_account.create_time
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expense_account.create_time
     *
     * @param createTime the value for expense_account.create_time
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expense_account.next_deal_sn
     *
     * @return the value of expense_account.next_deal_sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public String getNextDealSn() {
        return nextDealSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expense_account.next_deal_sn
     *
     * @param nextDealSn the value for expense_account.next_deal_sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setNextDealSn(String nextDealSn) {
        this.nextDealSn = nextDealSn == null ? null : nextDealSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expense_account.total_amount
     *
     * @return the value of expense_account.total_amount
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expense_account.total_amount
     *
     * @param totalAmount the value for expense_account.total_amount
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expense_account.STATUS
     *
     * @return the value of expense_account.STATUS
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expense_account.STATUS
     *
     * @param status the value for expense_account.STATUS
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}