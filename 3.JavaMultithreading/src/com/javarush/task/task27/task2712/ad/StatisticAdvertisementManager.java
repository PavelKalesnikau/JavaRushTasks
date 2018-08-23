package com.javarush.task.task27.task2712.ad;


import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance;
    private final AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) instance = new StatisticAdvertisementManager();
        return instance;
    }

    private StatisticAdvertisementManager() {
    }

    public List<Advertisement> getActiveVideoSet(){
        List<Advertisement> activeVideos = new ArrayList<Advertisement>();
        List<Advertisement> allVideos = advertisementStorage.list();
        for (Advertisement video: allVideos ) {
            if ( video.getHits() > 0) activeVideos.add(video);
        }
        return activeVideos;
    };
    public List<Advertisement> getArchivedVideoSet(){
        List<Advertisement> archivedVideos = new ArrayList<Advertisement>() {};
        List<Advertisement> allVideos = advertisementStorage.list();
        for (Advertisement video: allVideos ) {
            if ( video.getHits() <= 0) archivedVideos.add(video);
        }
        return archivedVideos;
    };
}
