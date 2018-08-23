package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

   public void printAdvertisementProfit(){
       Map<Date, Long> profitPerDays = StatisticManager.getInstance().getAdvertisementProfit();
       double total = 0;
       for ( Map.Entry profitPerDay : profitPerDays.entrySet() ) {
           DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
           Date date = (Date) profitPerDay.getKey();
           double amount = (long) profitPerDay.getValue() / 100.00;

           ConsoleHelper.writeMessage(String.format("%s - %.2f", dateFormat.format(date), amount ));
           total += amount;
       }
       ConsoleHelper.writeMessage(String.format("Total - %.2f ", total));
   };
   public void printCookWorkloading(){
       Map<Date, TreeMap<String, Integer>> cookWorkloads = StatisticManager.getInstance().getCookWorkload();

       DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

       for (Map.Entry<Date, TreeMap<String, Integer>> cookWorkload : cookWorkloads.entrySet()){
           Date date = (Date) cookWorkload.getKey();
           ConsoleHelper.writeMessage(dateFormat.format(date));
           TreeMap<String, Integer> cooks = cookWorkload.getValue();
           for (Map.Entry<String, Integer> cook: cooks.entrySet()) {
               String name = cook.getKey();
               int min = cook.getValue();
//               int min = (int) Math.ceil(cook.getValue() / 60.0d);
               ConsoleHelper.writeMessage(String.format("%s - %d min", name, min));
           }
       }
   };
   public void printActiveVideoSet(){
       StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
       List<Advertisement> activeVideos = statisticAdvertisementManager.getActiveVideoSet();
       Collections.sort(activeVideos, new Comparator<Advertisement>() {
           @Override
           public int compare(Advertisement o1, Advertisement o2) {
               return o1.getName().compareToIgnoreCase(o2.getName());
           }
       });
       for ( Advertisement video: activeVideos ) {
           ConsoleHelper.writeMessage(video.getName() + " - " + video.getHits());
       }
   };
   public void printArchivedVideoSet(){
       StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
       List<Advertisement> archivedVideos = statisticAdvertisementManager.getArchivedVideoSet();
       Collections.sort(archivedVideos, new Comparator<Advertisement>() {
           @Override
           public int compare(Advertisement o1, Advertisement o2) {
               return o1.getName().compareToIgnoreCase(o2.getName());
           }
       });
       for ( Advertisement video: archivedVideos ) {
           ConsoleHelper.writeMessage(video.getName());
       }
   };

}
