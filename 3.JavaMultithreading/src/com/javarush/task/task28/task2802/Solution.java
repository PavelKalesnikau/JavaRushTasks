package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

   /* public static class AmigoThreadFactory implements ThreadFactory {
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;
        AtomicInteger poolNumber = new AtomicInteger(1);

        public AmigoThreadFactory() {
            SecurityManager sm = System.getSecurityManager();
            this.group = (sm != null) ? sm.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = group.getName() + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
                thread.setDaemon(false);
                thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        }
    }*/
   public static class AmigoThreadFactory implements ThreadFactory{
       AtomicInteger integer=new AtomicInteger(0);
       AtomicInteger factoryNum=new AtomicInteger(0);
       static AtomicInteger factoryCount=new AtomicInteger(0);
       public AmigoThreadFactory() {
           factoryNum.set(factoryCount.incrementAndGet());
       }
       @Override
       public Thread newThread(Runnable r)
       {
           Thread thread = new Thread(r);
           thread.setDaemon(false);
           thread.setPriority(Thread.NORM_PRIORITY);
           thread.setName(thread.getThreadGroup().getName()+"-pool-"+factoryNum+"-thread-"+integer.incrementAndGet());
           return thread;
       }
   }
}
