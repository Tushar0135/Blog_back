package com.example.Blog_back.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Blogs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;
    private String name;
    private String details;
    private String image;
    private String category;
    @Column(nullable = false, columnDefinition = "Integer default '1'")
    private Integer active;
    private String comments;
    @Column(nullable = false, columnDefinition = "Integer default '1'")
    private Integer privacy;


    public Blogs() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getBlogId() {
        return blogId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Integer getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Integer privacy) {
        this.privacy = privacy;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return blogId + " " + name;
    }
}
