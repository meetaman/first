/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "register", catalog = "login2", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Register.findAll", query = "SELECT r FROM Register r")
    , @NamedQuery(name = "Register.findByUserId", query = "SELECT r FROM Register r WHERE r.userId = :userId")
    , @NamedQuery(name = "Register.findByName", query = "SELECT r FROM Register r WHERE r.name = :name")
    , @NamedQuery(name = "Register.findByEmail", query = "SELECT r FROM Register r WHERE r.email = :email")
    , @NamedQuery(name = "Register.findByPhone", query = "SELECT r FROM Register r WHERE r.phone = :phone")
    , @NamedQuery(name = "Register.findByPassword", query = "SELECT r FROM Register r WHERE r.password = :password")
    , @NamedQuery(name = "Register.findByUser", query = "SELECT r FROM Register r WHERE r.user = :user")
    , @NamedQuery(name = "Register.findByAge", query = "SELECT r FROM Register r WHERE r.age = :age")
    , @NamedQuery(name = "Register.findByCity", query = "SELECT r FROM Register r WHERE r.city = :city")
    , @NamedQuery(name = "Register.findByCollege", query = "SELECT r FROM Register r WHERE r.college = :college")})
public class Register implements Serializable {

    @OneToMany(mappedBy = "user")
    private List<Posts> postsList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userId", nullable = false)
    private Integer userId;
    @Column(name = "name", length = 45)
    private String name;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "phone", length = 45)
    private String phone;
    @Column(name = "password", length = 45)
    private String password;
    @Column(name = "user", length = 45)
    private String user;
    @Column(name = "age")
    private Integer age;
    @Column(name = "city", length = 45)
    private String city;
    @Column(name = "college", length = 45)
    private String college;

    public Register() {
    }

    public Register(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Register)) {
            return false;
        }
        Register other = (Register) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.models.Register[ userId=" + userId + " ]";
    }

    @XmlTransient
    public List<Posts> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Posts> postsList) {
        this.postsList = postsList;
    }
    
}
