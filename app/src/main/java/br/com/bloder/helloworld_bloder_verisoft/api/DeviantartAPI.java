package br.com.bloder.helloworld_bloder_verisoft.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.bloder.helloworld_bloder_verisoft.BuildConfig;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by denis on 23/11/15.
 */
public class DeviantartAPI {

  public static DeviantartServices getServices() {
      Gson gson = new GsonBuilder()
              .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
              .create();

      RestAdapter retrofit = new RestAdapter.Builder()
              .setEndpoint(BuildConfig.API_URL)
              .setLogLevel(RestAdapter.LogLevel.FULL)
              .setConverter(new GsonConverter(gson))
              .build();

      return retrofit.create(DeviantartServices.class);
  }

    public static DeviantartServices getAccessTokenServices(){
        Gson gson = new GsonBuilder().create();

        RestAdapter retrofit = new RestAdapter.Builder()
                .setEndpoint(BuildConfig.ACCESS_TOKEN_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();

        return retrofit.create(DeviantartServices.class);
    }
}
