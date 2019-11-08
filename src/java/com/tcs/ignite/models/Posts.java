/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "posts", catalog = "login2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posts.findAll", query = "SELECT p FROM Posts p")
    , @NamedQuery(name = "Posts.findByIdPosts", query = "SELECT p FROM Posts p WHERE p.idPosts = :idPosts")
    , @NamedQuery(name = "Posts.findByContent", query = "SELECT p FROM Posts p WHERE p.content = :content")
    , @NamedQuery(name = "Posts.findByPostedAt", query = "SELECT p FROM Posts p WHERE p.postedAt = :postedAt")
    , @NamedQuery(name = "Posts.findByPostscol", query = "SELECT p FROM Posts p WHERE p.postscol = :postscol")})
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_posts", nullable = false)
    private Integer idPosts;
    @Basic(optional = false)
    @Column(name = "content", nullable = false, length = 130)
    private String content;
    @Basic(optional = false)
    @Column(name = "postedAt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedAt;
    @Column(name = "postscol", length = 45)
    private String postscol;
    @JoinColumn(name = "user", referencedColumnName = "user")
    @ManyToOne
    private Register user;

    public Posts() {
    }

    public Posts(Integer idPosts) {
        this.idPosts = idPosts;
    }

    public Posts(Integer idPosts, String content, Date postedAt) {
        this.idPosts = idPosts;
        this.content = content;
        this.postedAt = postedAt;
    }

    public Integer getIdPosts() {
        return idPosts;
    }

    public void setIdPosts(Integer idPosts) {
        this.idPosts = idPosts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public String getPostscol() {
        return postscol;
    }

    public void setPostscol(String postscol) {
        this.postscol = postscol;
    }

    public Register getUser() {
        return user;
    }

    public void setUser(Register user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPosts != null ? idPosts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posts)) {
            return false;
        }
        Posts other = (Posts) object;
        if ((this.idPosts == null && other.idPosts != null) || (this.idPosts != null && !this.idPosts.equals(other.idPosts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.models.Posts[ idPosts=" + idPosts + " ]";
    }
    
}
