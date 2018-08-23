package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
//    private Set<Cook> cooks = new HashSet<Cook>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null) instance = new StatisticManager();
        return instance;
    }

//    public Set<Cook> getCooks() {
//        return cooks;
//    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

//    public void register(Cook cook) {
//        cooks.add(cook);
//    }

    public Map<Date, Long> getAdvertisementProfit() {
        TreeMap<Date, Long> profitPerDay = new TreeMap<Date, Long>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });

        List<EventDataRow> videos = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        for (EventDataRow item : videos) {
            VideoSelectedEventDataRow selectedVideo = (VideoSelectedEventDataRow) item;
            Calendar calendar = getCurrentDate(selectedVideo.getDate());
            profitPerDay.compute(calendar.getTime(), (k, v) -> (v == null) ? selectedVideo.getAmount() : v + selectedVideo.getAmount());
        }
        return profitPerDay;
    }

    private Calendar getCurrentDate(Date date) {
        Date currentDate = date;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTime(currentDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public Map<Date, TreeMap<String, Integer>> getCookWorkload() {
        TreeMap<Date, TreeMap<String, Integer>> cookWorkloadperDay = new TreeMap<Date, TreeMap<String, Integer>>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });

        List<EventDataRow> cookOrders = statisticStorage.getStorage().get(EventType.COOKED_ORDER);
        for (EventDataRow item : cookOrders) {
            CookedOrderEventDataRow cookedOrder = (CookedOrderEventDataRow) item;

            Calendar calendar = getCurrentDate(cookedOrder.getDate());

            if (cookWorkloadperDay.containsKey(calendar.getTime())) {
                TreeMap<String, Integer> cookTimes = cookWorkloadperDay.get(calendar.getTime());
                cookTimes.compute(cookedOrder.getCookName(), (k, v) -> (v == null) ? cookedOrder.getTime() : v + cookedOrder.getTime());
                cookWorkloadperDay.put(calendar.getTime(), cookTimes);
            } else {
                TreeMap<String, Integer> cookTimes = new TreeMap<String, Integer>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                cookTimes.put(cookedOrder.getCookName(), cookedOrder.getTime());
                cookWorkloadperDay.put(calendar.getTime(), cookTimes);
            }
        }
        return cookWorkloadperDay;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}
