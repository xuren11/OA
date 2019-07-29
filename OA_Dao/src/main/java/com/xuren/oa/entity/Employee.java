package com.xuren.oa.entity;

import org.apache.ibatis.type.Alias;

@Alias("Employee")
public class Employee {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private String sn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.NAME
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.PASSWORD
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.department_sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private String departmentSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.post
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    private String post;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.sn
     *
     * @return the value of employee.sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public String getSn() {
        return sn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.sn
     *
     * @param sn the value for employee.sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.NAME
     *
     * @return the value of employee.NAME
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.NAME
     *
     * @param name the value for employee.NAME
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.PASSWORD
     *
     * @return the value of employee.PASSWORD
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.PASSWORD
     *
     * @param password the value for employee.PASSWORD
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.department_sn
     *
     * @return the value of employee.department_sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public String getDepartmentSn() {
        return departmentSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.department_sn
     *
     * @param departmentSn the value for employee.department_sn
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setDepartmentSn(String departmentSn) {
        this.departmentSn = departmentSn == null ? null : departmentSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.post
     *
     * @return the value of employee.post
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public String getPost() {
        return post;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.post
     *
     * @param post the value for employee.post
     *
     * @mbg.generated Mon Jul 29 13:53:03 CST 2019
     */
    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }
}