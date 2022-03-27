package com.study.ssm.bean;

public class Department {
    private Integer dId;

    private String deptName;

    public Department() {
    }

    public Department(Integer dId, String deptName) {
        this.dId = dId;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}