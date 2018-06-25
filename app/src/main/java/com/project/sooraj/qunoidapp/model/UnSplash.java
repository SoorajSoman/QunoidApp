
package com.project.sooraj.qunoidapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UnSplash {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("links")
    @Expose
    private Links links;
//    @SerializedName("categories")
//    @Expose
//    private List<Object> categories = null;
//    @SerializedName("sponsored")
    @Expose
    private Boolean sponsored;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;
//    @SerializedName("current_user_collections")
//    @Expose
//    private List<Object> currentUserCollections = null;
//    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("user")
    @Expose
    private User user;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UnSplash() {
    }

    /**
     * 
     * @param currentUserCollections
     * @param urls
     * @param width
     * @param links
     * @param id
     * @param updatedAt
     * @param height
     * @param color
     * @param createdAt
     * @param description
     * @param likes
     * @param slug
     * @param categories
     * @param likedByUser
     * @param sponsored
     * @param user
     */
    public UnSplash(String id, String createdAt, String updatedAt, Integer width, Integer height, String color, String description, Urls urls, Links links, List<Object> categories, Boolean sponsored, Integer likes, Boolean likedByUser, List<Object> currentUserCollections, Object slug, User user) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.description = description;
        this.urls = urls;
        this.links = links;
        //this.categories = categories;
        this.sponsored = sponsored;
        this.likes = likes;
        this.likedByUser = likedByUser;
       // this.currentUserCollections = currentUserCollections;
        //this.slug = slug;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

//    public List<Object> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(List<Object> categories) {
//        this.categories = categories;
//    }

    public Boolean getSponsored() {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

//    public List<Object> getCurrentUserCollections() {
//        return currentUserCollections;
//    }
//
//    public void setCurrentUserCollections(List<Object> currentUserCollections) {
//        this.currentUserCollections = currentUserCollections;
//    }

    public Object getSlug() {
        return slug;
    }

//    public void setSlug(Object slug) {
//        this.slug = slug;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
