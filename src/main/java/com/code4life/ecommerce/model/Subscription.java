package com.code4life.ecommerce.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User userId;

    private Date subStartDate;

    private Date subEndDate;

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Date getSubStartDate() {
        return subStartDate;
    }

    public void setSubStartDate(Date subStartDate) {
        this.subStartDate = subStartDate;
    }

    public Date getSubEndDate() {
        return subEndDate;
    }

    public void setSubEndDate(Date subEndDate) {
        this.subEndDate = subEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        if (!getSubId().equals(that.getSubId())) return false;
        if (!getUserId().equals(that.getUserId())) return false;
        if (!getSubStartDate().equals(that.getSubStartDate())) return false;
        return getSubEndDate().equals(that.getSubEndDate());
    }

    @Override
    public int hashCode() {
        int result = getSubId().hashCode();
        result = 31 * result + getUserId().hashCode();
        result = 31 * result + getSubStartDate().hashCode();
        result = 31 * result + getSubEndDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subId=" + subId +
                ", userId=" + userId +
                ", subStartDate=" + subStartDate +
                ", subEndDate=" + subEndDate +
                '}';
    }
}
