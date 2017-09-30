package phaseshift.com.demophase.Events.Interactor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import phaseshift.com.demophase.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shivam on 20-07-2017.
 */

public class ApiClient {

    public static final String url = "https://www.jasonbase.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient() {
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        if(BuildConfig.DEBUG) {
            okHttp.addInterceptor(logging);
        }
        if (retrofit == null) {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd\\'T\\'HH:mm:ssZ").create();

            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create(gson)).client(okHttp.build()).build();
        }
        return retrofit;
    }
}