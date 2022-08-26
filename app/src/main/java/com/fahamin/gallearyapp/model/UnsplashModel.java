
package com.fahamin.gallearyapp.model;

import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.fahamin.gallearyapp.roomdb.TypeConverters.LinkTypeConverters;
import com.fahamin.gallearyapp.roomdb.TypeConverters.ModelTypeConverters;
import com.fahamin.gallearyapp.roomdb.TypeConverters.ObjetTypeConverters;
import com.fahamin.gallearyapp.roomdb.TypeConverters.TopicSubmissionypeConverters;
import com.fahamin.gallearyapp.roomdb.TypeConverters.UrlTypeConverters;
import com.fahamin.gallearyapp.roomdb.TypeConverters.UserTypeConverters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity
public class UnsplashModel implements Serializable, Parcelable {

    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private String id;

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @ColumnInfo(name = "promoted_at")
    @SerializedName("promoted_at")
    @Expose
    private String promotedAt;

    @ColumnInfo(name = "width")
    @SerializedName("width")
    @Expose
    private Integer width;

    @ColumnInfo(name = "height")
    @SerializedName("height")
    @Expose
    private Integer height;

    @ColumnInfo(name = "color")
    @SerializedName("color")
    @Expose
    private String color;

    @ColumnInfo(name = "blur_hash")
    @SerializedName("blur_hash")
    @Expose
    private String blurHash;

    @TypeConverters(ObjetTypeConverters.class)
    @ColumnInfo(name = "description")
    @SerializedName("description")
    @Expose
    private Object description;

    @TypeConverters(ObjetTypeConverters.class)
    @ColumnInfo(name = "alt_description")
    @SerializedName("alt_description")
    @Expose
    private Object altDescription;

    @TypeConverters(UrlTypeConverters.class)
    @ColumnInfo(name = "urls")
    @SerializedName("urls")
    @Expose
    private Urls urls;

    @TypeConverters(LinkTypeConverters.class)
    @ColumnInfo(name = "links")
    @SerializedName("links")
    @Expose
    private Links links;

    @TypeConverters(ModelTypeConverters.class)
    @ColumnInfo(name = "categories")
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;

    @PrimaryKey
    @SerializedName("likes")
    @Expose
    private Integer likes;

    @ColumnInfo(name = "liked_by_user")
    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;

    @TypeConverters(ModelTypeConverters.class)
    @ColumnInfo(name = "current_user_collections")
    @SerializedName("current_user_collections")
    @Expose
    private List<Object> currentUserCollections = null;

    @TypeConverters(ObjetTypeConverters.class)
    @ColumnInfo(name = "sponsorship")
    @SerializedName("sponsorship")
    @Expose
    private Object sponsorship;

    @TypeConverters(TopicSubmissionypeConverters.class)
    @ColumnInfo(name = "topic_submissions")
    @SerializedName("topic_submissions")
    @Expose
    private TopicSubmissions topicSubmissions;

    @TypeConverters(UserTypeConverters.class)
    @ColumnInfo(name = "user")
    @SerializedName("user")
    @Expose
    private User user;
    public final static Creator<UnsplashModel> CREATOR = new Creator<UnsplashModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UnsplashModel createFromParcel(android.os.Parcel in) {
            return new UnsplashModel(in);
        }

        public UnsplashModel[] newArray(int size) {
            return (new UnsplashModel[size]);
        }

    };
    private final static long serialVersionUID = -721925357435258723L;

    protected UnsplashModel(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.promotedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.color = ((String) in.readValue((String.class.getClassLoader())));
        this.blurHash = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((Object) in.readValue((Object.class.getClassLoader())));
        this.altDescription = ((Object) in.readValue((Object.class.getClassLoader())));
        this.urls = ((Urls) in.readValue((Urls.class.getClassLoader())));
        this.links = ((Links) in.readValue((Links.class.getClassLoader())));
        in.readList(this.categories, (Object.class.getClassLoader()));
        this.likes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.likedByUser = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.currentUserCollections, (Object.class.getClassLoader()));
        this.sponsorship = ((Object) in.readValue((Object.class.getClassLoader())));
        this.topicSubmissions = ((TopicSubmissions) in.readValue((TopicSubmissions.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
    }

    public UnsplashModel() {
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

    public String getPromotedAt() {
        return promotedAt;
    }

    public void setPromotedAt(String promotedAt) {
        this.promotedAt = promotedAt;
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

    public String getBlurHash() {
        return blurHash;
    }

    public void setBlurHash(String blurHash) {
        this.blurHash = blurHash;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getAltDescription() {
        return altDescription;
    }

    public void setAltDescription(Object altDescription) {
        this.altDescription = altDescription;
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

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
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

    public List<Object> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Object> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public Object getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(Object sponsorship) {
        this.sponsorship = sponsorship;
    }

    public TopicSubmissions getTopicSubmissions() {
        return topicSubmissions;
    }

    public void setTopicSubmissions(TopicSubmissions topicSubmissions) {
        this.topicSubmissions = topicSubmissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(promotedAt);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(color);
        dest.writeValue(blurHash);
        dest.writeValue(description);
        dest.writeValue(altDescription);
        dest.writeValue(urls);
        dest.writeValue(links);
        dest.writeList(categories);
        dest.writeValue(likes);
        dest.writeValue(likedByUser);
        dest.writeList(currentUserCollections);
        dest.writeValue(sponsorship);
        dest.writeValue(topicSubmissions);
        dest.writeValue(user);
    }

    public int describeContents() {
        return 0;
    }

}
