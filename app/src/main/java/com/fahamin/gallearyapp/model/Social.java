
package com.fahamin.gallearyapp.model;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Social implements Serializable, Parcelable
{

    @SerializedName("instagram_username")
    @Expose
    private String instagramUsername;
    @SerializedName("portfolio_url")
    @Expose
    private Object portfolioUrl;
    @SerializedName("twitter_username")
    @Expose
    private String twitterUsername;
    @SerializedName("paypal_email")
    @Expose
    private Object paypalEmail;
    public final static Creator<Social> CREATOR = new Creator<Social>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Social createFromParcel(android.os.Parcel in) {
            return new Social(in);
        }

        public Social[] newArray(int size) {
            return (new Social[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4781356815086913720L;

    protected Social(android.os.Parcel in) {
        this.instagramUsername = ((String) in.readValue((String.class.getClassLoader())));
        this.portfolioUrl = ((Object) in.readValue((Object.class.getClassLoader())));
        this.twitterUsername = ((String) in.readValue((String.class.getClassLoader())));
        this.paypalEmail = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Social() {
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public void setInstagramUsername(String instagramUsername) {
        this.instagramUsername = instagramUsername;
    }

    public Object getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(Object portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public Object getPaypalEmail() {
        return paypalEmail;
    }

    public void setPaypalEmail(Object paypalEmail) {
        this.paypalEmail = paypalEmail;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(instagramUsername);
        dest.writeValue(portfolioUrl);
        dest.writeValue(twitterUsername);
        dest.writeValue(paypalEmail);
    }

    public int describeContents() {
        return  0;
    }

}
