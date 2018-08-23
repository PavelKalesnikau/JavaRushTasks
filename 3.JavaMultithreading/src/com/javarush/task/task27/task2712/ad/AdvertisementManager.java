package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.*;

/**
 * У каждого планшета будет свой объект менеджера, который будет подбирать
 * оптимальный набор роликов и их последовательность для каждого заказа.
 * Он также будет взаимодействовать с плеером и отображать ролики.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    private List<Advertisement> selectedVideos;
    private long amountSelectedVideos;
    private int selectedTotalTime;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public long getAmountSelectedVideos() {
        return amountSelectedVideos;
    }

    public int getSelectedTotalTime() {
        return selectedTotalTime;
    }

    public void processVideos() throws NoVideoAvailableException {

        List<Advertisement> list = storage.list();
        if (list.isEmpty()) throw new NoVideoAvailableException();
        else {
            List<List<Advertisement>> powerSetAdverts = powerSet(getAdverts(list));

            long maxAmount = getMaxAmount(powerSetAdverts);
            List<Advertisement> bestList = new ArrayList<Advertisement>();
            List<List<Advertisement>> bestLists = new ArrayList<>();

            for (List<Advertisement> adverts : powerSetAdverts) {
                long sumAmount = getAmountSumm(adverts);
                int sumTime = getTime(adverts);
                if (sumAmount == maxAmount && sumTime <= timeSeconds) {
                    bestList = adverts;
                    bestLists.add(bestList);
                }
            }

            if (bestLists.size() > 1) {
                int maxTime = 0;
                int minNumberAdverts = 0;
                for (List<Advertisement> adverts : bestLists) {
                    int sumTime = getTime(adverts);
                    int numberAdverts = adverts.size();
                    if (maxTime < sumTime) {
                        bestList = adverts;
                        maxTime = sumTime;
                    } else if (maxTime == sumTime) {
                        if (numberAdverts > minNumberAdverts) {
                            minNumberAdverts = numberAdverts;
                            bestList = adverts;
                        }
                    }
                }
            }

            Collections.sort(bestList, new Comparator<Advertisement>() {
                @Override
                public int compare(Advertisement o1, Advertisement o2) {
                    long amountPerOneDispl1 = o1.getAmountPerOneDisplaying();
                    long amountPerOneDispl2 = o2.getAmountPerOneDisplaying();
                    long amountPerOneSec1 = o1.getAmountPerOneSecond();
                    long amountPerOneSec2 = o2.getAmountPerOneSecond();

                    if (amountPerOneDispl1 < amountPerOneDispl2) return 1;
                    else if (amountPerOneDispl1 > amountPerOneDispl2) return -1;
                    else {
                        if (amountPerOneSec1 > amountPerOneSec2) return 1;
                        else if (amountPerOneSec1 < amountPerOneSec2) return -1;
                        else return 0;
                    }
                }
            });

            for (Advertisement advert : bestList) {
                advert.revalidate();
                ConsoleHelper.writeMessage(advert.toString());
            }
            selectedVideos = bestList;
            amountSelectedVideos = getAmountSumm(bestList);
            selectedTotalTime = getTime(bestList);

        }
    }

    public List<Advertisement> getSelectedVideos() {
        return selectedVideos;
    }

    private List<Advertisement> getAdverts(List<Advertisement> originalList) {
        List<Advertisement> list = new ArrayList<Advertisement>();
        for (Advertisement advertisement : originalList) {
            if (advertisement.getHits() >= 1) list.add(advertisement);
        }
        return list;
    }

    private long getMaxAmount(List<List<Advertisement>> powerSetAdverts) {
        long maxAmount = 0;
        for (List<Advertisement> adverts : powerSetAdverts) {
            long sumAmount = getAmountSumm(adverts);
            int sumTime = getTime(adverts);
            if (sumAmount > maxAmount && sumTime <= timeSeconds)
                maxAmount = sumAmount;
        }
        return maxAmount;
    }


    private int getTime(List<Advertisement> adverts) {
        int sumTime = 0;
        for (Advertisement advrt : adverts) {
            sumTime += advrt.getDuration();
        }
        return sumTime;
    }

    private long getAmountSumm(List<Advertisement> adverts) {
        int sum = 0;
        for (Advertisement advrt : adverts) {
            sum += advrt.getAmountPerOneDisplaying();
        }
        return sum;
    }

    private List<List<Advertisement>> powerSet(List<Advertisement> originalList) {
        List<List<Advertisement>> lists = new ArrayList<List<Advertisement>>();
        if (originalList.isEmpty()) {
            lists.add(new ArrayList<Advertisement>());
            return lists;
        }

        List<Advertisement> list = new ArrayList<Advertisement>(originalList);
        Advertisement head = list.get(0);
        List<Advertisement> rest = new ArrayList<Advertisement>(list.subList(1, list.size()));
        for (List<Advertisement> list1 : powerSet(rest)) {
            List<Advertisement> newList = new ArrayList<Advertisement>();
            newList.add(head);
            newList.addAll(list1);
            lists.add(newList);
            lists.add(list1);
        }
        return lists;
    }
/*
    public static <T> List<List<T>> powerSet(List<T> originalList) {
        List<List<T>> lists = new ArrayList<List<T>>();
        if (originalList.isEmpty()) {
            lists.add(new ArrayList<T>());
            return lists;
        }
        List<T> list = new ArrayList<T>(originalList);
        T head = list.get(0);
        List<T> rest = new ArrayList<T>(list.subList(1, list.size()));
        for (List<T> list1 : powerSet(rest)) {
            List<T> newList = new ArrayList<T>();
            newList.add(head);
            newList.addAll(list1);
            lists.add(newList);
            lists.add(list1);
        }
        return lists;
    }
*/
}
