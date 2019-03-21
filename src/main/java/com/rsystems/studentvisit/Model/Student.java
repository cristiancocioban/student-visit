package com.rsystems.studentvisit.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="\"Contact\"")
public class Student {
    @Id
    @Column(name = "\"Id\"")
    private String id;
    @Column(name = "\"FirstName\"")
    private String firstName;
    @Column(name = "\"LastName\"")
    private String lastName;
    @Column(name = "\"Type__c\"")
    private String contactType;
    @Column(name = "\"Visit_Date__c\"")
    private Date visitDate;

    @Column(name = "\"AccountId\"")
    private String schoolId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
}
