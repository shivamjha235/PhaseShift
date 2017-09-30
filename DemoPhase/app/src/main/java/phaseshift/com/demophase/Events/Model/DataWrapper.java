package phaseshift.com.demophase.Events.Model;

/**
 * Created by Shivam on 20-07-2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Rohan on 18-07-2017.
 */

public class DataWrapper {
    @SerializedName("data")
    @Expose
    public ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }
}
