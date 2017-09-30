package phaseshift.com.demophase.Events.Model;

/**
 * Created by Shivam on 20-07-2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rohan on 18-07-2017.
 */

public class Data implements Parcelable{
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("name_of_event")
    @Expose
    private String name_of_event;
    @SerializedName("registration_amt")
    @Expose
    private String registration_amt;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("winner")
    @Expose
    private String winner;
    @SerializedName("runner_up")
    @Expose
    private String runner_up;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("coordinator_one")
    @Expose
    private String coordinator_one;
    @SerializedName("phone_one")
    @Expose
    private String phone_one;
    @SerializedName("coordinator_two")
    @Expose
    private String coodinator_two;
    @SerializedName("phone_two")
    @Expose
    private String phone_two;
    @SerializedName("participation")
    @Expose
    private String participation;

    public String getParticipation() {
        return participation;
    }

    public void setParticipation(String participation) {
        this.participation = participation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName_of_event() {
        return name_of_event;
    }

    public void setName_of_event(String name_of_event) {
        this.name_of_event = name_of_event;
    }

    public String getRegistration_amt() {
        return registration_amt;
    }

    public void setRegistration_amt(String registration_amt) {
        this.registration_amt = registration_amt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getRunner_up() {
        return runner_up;
    }

    public void setRunner_up(String runner_up) {
        this.runner_up = runner_up;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCoordinator_one() {
        return coordinator_one;
    }

    public void setCoordinator_one(String coordinator_one) {
        this.coordinator_one = coordinator_one;
    }

    public String getPhone_one() {
        return phone_one;
    }

    public void setPhone_one(String phone_one) {
        this.phone_one = phone_one;
    }

    public String getCoodinator_two() {
        return coodinator_two;
    }

    public void setCoodinator_two(String coodinator_two) {
        this.coodinator_two = coodinator_two;
    }

    public String getPhone_two() {
        return phone_two;
    }

    public void setPhone_two(String phone_two) {
        this.phone_two = phone_two;
    }


    public Data() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.category);
        dest.writeString(this.name_of_event);
        dest.writeString(this.registration_amt);
        dest.writeString(this.description);
        dest.writeString(this.winner);
        dest.writeString(this.runner_up);
        dest.writeString(this.time);
        dest.writeString(this.day);
        dest.writeString(this.department);
        dest.writeString(this.venue);
        dest.writeString(this.coordinator_one);
        dest.writeString(this.phone_one);
        dest.writeString(this.coodinator_two);
        dest.writeString(this.phone_two);
        dest.writeString(this.participation);
    }

    protected Data(Parcel in) {
        this.category = in.readString();
        this.name_of_event = in.readString();
        this.registration_amt = in.readString();
        this.description = in.readString();
        this.winner = in.readString();
        this.runner_up = in.readString();
        this.time = in.readString();
        this.day = in.readString();
        this.department = in.readString();
        this.venue = in.readString();
        this.coordinator_one = in.readString();
        this.phone_one = in.readString();
        this.coodinator_two = in.readString();
        this.phone_two = in.readString();
        this.participation = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
