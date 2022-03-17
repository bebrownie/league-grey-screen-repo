package org.example.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.example.practice.models.Summoner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@RestController
public class TestController {

   final static String SUMMONER_ENDPOINT = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
   final static String RIOT_TOKEN = "X-Riot-Token";
   private static String riotApi = "RGAPI-375bd9a5-e96d-4bf9-b938-4c16a0fe153b";

   static final OkHttpClient client = new OkHttpClient();

   public static String get(String url) {
       Request request = new Request.Builder()
               .url(url)
               .addHeader(RIOT_TOKEN, riotApi)
               .get()
               .build();

       try (Response response = client.newCall(request).execute()) {
           return response.body().string();
       } catch (IOException e) {
           System.out.println("Unable to get from endpoint" + e);
       }
       return null;
   }

   @RequestMapping("/summoner")
   String endpoint(@RequestParam(name="name", required=true) String summonerName) {
       String response = TestController.get(SUMMONER_ENDPOINT + summonerName);
       Gson gson = new GsonBuilder().create();
       Summoner summoner = gson.fromJson(response, Summoner.class);
       System.out.println(summoner.toString());
       return summoner.getAccountId();
   }

}
