
package com.fahamin.gallearyapp.model;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fashion implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    public final static Creator<Fashion> CREATOR = new Creator<Fashion>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Fashion createFromParcel(android.os.Parcel in) {
            return new Fashion(in);
        }

        public Fashion[] newArray(int size) {
            return (new Fashion[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1962874946732368788L;

    protected Fashion(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Fashion() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
