package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String postUrl;
    @Transient
    private String userName;
    @Transient
    private int voteCount;
    private Integer userId;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "posted_at")
    private Date postedAt = new Date();
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt = new Date();
    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;




    public Post () {
    }
    public Post (int id, String title, String postUrl, String userName, int voteCount, Integer userId, Date postedAt, Date updatedAt, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.postUrl = postUrl;
        this.userName = userName;
        this.voteCount = voteCount;
        this.userId = userId;
        this.postedAt = postedAt;
        this.updatedAt = updatedAt;
        this.comments = comments;
    }
    //id int
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    //title string
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }
    //postUrl string
    public String getPostUrl(){
        return postUrl;
    }

    public void setPostUrl(String postUrl){
        this.postUrl = postUrl;
    }
    //userName string

    public String getUserName() {
        return userName;
    }
     public void setUserName(String username) {
        this.userName = username;
     }
    //voteCount int
    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
    //userId integer
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }
    //postedAt date
    public Date getPostedAt(){
        return postedAt;
    }

    public void setPostedAt(Date postedAt){
        this.postedAt = postedAt;
    }
    //updatedAt date
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    //comments List<Comment>
    public List<Comment> getComments(){
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Post)) return false;
        Post post = (Post) o;
        return getVoteCount() == post.getVoteCount() &&
                Objects.equals(getId(), post.getId()) &&
                Objects.equals(getTitle(), post.getTitle()) &&
                Objects.equals(getPostUrl(), post.getPostUrl()) &&
                Objects.equals(getUserName(), post.getUserName()) &&
                Objects.equals(getUserId(), post.getUserId()) &&
                Objects.equals(getPostedAt(), post.getPostedAt()) &&
                Objects.equals(getUpdatedAt(), post.getUpdatedAt()) &&
                Objects.equals(getComments(), post.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPostUrl(), getUserName(), getVoteCount(), getUserId(), getPostedAt(), getUpdatedAt(), getComments());
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", voteCount=" + voteCount +
                ", userId=" + userId +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                '}';
    }
}