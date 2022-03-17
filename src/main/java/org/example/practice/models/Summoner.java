package org.example.practice.models;


/* Example
    "id": "Oq-lUSrXQ09RsJekjILzdTvo_9V8z3yUx32e9LkE8kQ3eiU",
    "accountId": "MObI83G3SnWBwA685ROAaGP_F7Sd2rSrSHcv4iT0-Dr6pw",
    "puuid": "6y7bkYAKbGWB9ufAlKXFoK6NhkneANQlEUqVKj6jVLEqkqMOH2jnZLFHs_ygWT9ogpzUyw4yQzZ0bA",
    "name": "ImAHornyHippo",
    "profileIconId": 539,
    "revisionDate": 1647383013000,
    "summonerLevel": 208
*/
public class Summoner {

    private String id;
    private String accountId;
    private String puuid;
    private String name;
    private int profileIconId;
    private int summonerLevel;

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPuuid() {
        return puuid;
    }

    public String getName() {
        return name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }
}
