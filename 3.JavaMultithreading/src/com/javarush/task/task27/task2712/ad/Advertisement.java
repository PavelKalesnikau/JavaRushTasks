package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content; // видео
    private String name; // имя, название
    private long initialAmount; // начальная сумма, стоимость рекламы в копейках
    private int hits; // количество оплаченных показов
    private int duration; // продолжительность в секундах

    private long amountPerOneDisplaying;
    private long amountPerOneSecond;

    public int getHits() {
        return hits;
    }

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;

        this.initialAmount = initialAmount;
        if(hits == 0) this.hits = -1;
        else this.hits = hits;
        this.duration = duration;

        this.amountPerOneDisplaying = initialAmount / this.hits;
        this.amountPerOneSecond = amountPerOneDisplaying * 1000 / duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() throws UnsupportedOperationException {
        if (hits < 1) throw new UnsupportedOperationException();
        hits--;
    }

    public long getAmountPerOneSecond() {
        return amountPerOneSecond;
    }

    @Override
    public String toString() {
        return String.format("%s is displaying... %d, %d", name, amountPerOneDisplaying, amountPerOneSecond);
    }
}
