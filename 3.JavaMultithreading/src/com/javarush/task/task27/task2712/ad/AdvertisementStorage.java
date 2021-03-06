package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Хранилище рекламных роликов
 */
public class AdvertisementStorage {
    private static AdvertisementStorage advertisementStorage;
    private final List<Advertisement> videos = new ArrayList();

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 10, 10 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Fourth Video", 5000, 200, 12 * 60)); // 2 min
        videos.add(new Advertisement(someContent, "Second Video", 5000, 30, 15 * 60)); // 1 min
        videos.add(new Advertisement(someContent, "Third Video", 5000, 25, 5 * 60)); // 1 min
        videos.add(new Advertisement(someContent, "Fifth Video", 5000, 0, 5 * 60)); // 1 min
//        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
//        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
    }

    public static AdvertisementStorage getInstance() {
        if (advertisementStorage == null) {
            advertisementStorage = new AdvertisementStorage();
        }
        return advertisementStorage;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
