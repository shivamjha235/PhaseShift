package phaseshift.com.demophase.AboutPS.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rohan on 15-08-2017.
 */

public class TimeLineModel implements Parcelable{
    private String year;
    private String title;
    private String body;
    private int image;

    public TimeLineModel(String year, String title, String body, int image) {
        this.year = year;
        this.title = title;
        this.body = body;
        this.image = image;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.year);
        dest.writeString(this.body);
        dest.writeInt(this.image);
    }

    public TimeLineModel() {
    }

    protected TimeLineModel(Parcel in) {
        this.title = in.readString();
        this.year = in.readString();
        this.body = in.readString();
        this.image = in.readInt();
    }

    public static final Creator<TimeLineModel> CREATOR = new Creator<TimeLineModel>() {
        @Override
        public TimeLineModel createFromParcel(Parcel source) {
            return new TimeLineModel(source);
        }

        @Override
        public TimeLineModel[] newArray(int size) {
            return new TimeLineModel[size];
        }
    };
}
