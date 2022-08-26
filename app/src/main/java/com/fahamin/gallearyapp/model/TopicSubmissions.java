
package com.fahamin.gallearyapp.model;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopicSubmissions implements Serializable, Parcelable
{

    @SerializedName("fashion")
    @Expose
    private Fashion fashion;
    public final static Creator<TopicSubmissions> CREATOR = new Creator<TopicSubmissions>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TopicSubmissions createFromParcel(android.os.Parcel in) {
            return new TopicSubmissions(in);
        }

        public TopicSubmissions[] newArray(int size) {
            return (new TopicSubmissions[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4861160377179617303L;

    protected TopicSubmissions(android.os.Parcel in) {
        this.fashion = ((Fashion) in.readValue((Fashion.class.getClassLoader())));
    }

    public TopicSubmissions() {
    }

    public Fashion getFashion() {
        return fashion;
    }

    public void setFashion(Fashion fashion) {
        this.fashion = fashion;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(fashion);
    }

    public int describeContents() {
        return  0;
    }

}
