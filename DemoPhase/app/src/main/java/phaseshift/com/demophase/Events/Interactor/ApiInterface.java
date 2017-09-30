package phaseshift.com.demophase.Events.Interactor;

/**
 * Created by Shivam on 20-07-2017.
 */

import phaseshift.com.demophase.Events.Model.DataWrapper;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rohan on 18-07-2017.
 */

public interface ApiInterface {
    @GET("things/A80L.json")
    Call<DataWrapper> getInfo();
}
