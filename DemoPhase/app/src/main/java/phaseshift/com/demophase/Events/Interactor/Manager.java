package phaseshift.com.demophase.Events.Interactor;

/**
 * Created by Shivam on 20-07-2017.
 */
import phaseshift.com.demophase.Events.Model.DataWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rohan on 18-07-2017.
 */

public class Manager {

    private  static  Manager instance;
    public DataWrapper DataWrapper;
    private ApiInterface apiInterface;
    private CallBack Call;

    public void CallBack(CallBack Call){
        this.Call = Call;
    }

    public static Manager getInstance()
    {
        if(instance == null)
        {
            instance = new Manager();
        }
        return instance;
    }

    public void apiCall()
    {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<DataWrapper> call = apiInterface.getInfo();

        call.enqueue(new Callback<DataWrapper>() {
            @Override
            public void onResponse(Call<DataWrapper> call, Response<DataWrapper> response) {
                DataWrapper  = response.body();
                System.out.println(DataWrapper.getData().get(0).getName_of_event());

                if(Call !=null)
                {
                    Call.success();
                }
            }

            @Override
            public void onFailure(Call<DataWrapper> call, Throwable t) {
                if(Call!=null)
                {
                    Call.noNet();
                }
            }
        });
    }
}
