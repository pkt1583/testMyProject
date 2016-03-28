package com.mypract;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;

interface ProducerFactory {
    <T> T produce();
}

public class ProducerConsumer {
    public static void main(String[] args) {
        List<Double> integers = new ArrayList<>();

        Thread producer = new Producer<>(integers, new ProducerFactory() {
            @Override
            public Double produce() {
                return  random();
            }
        });

        producer.start();

        Thread consumer = new Consumer<>(integers);
        consumer.start();
    }

}

class Consumer<T> extends Thread {
    private List<T> resourceHolder = null;

    public Consumer(List<T> resourceHolder) {
        super();
        this.resourceHolder = resourceHolder;
    }

    public void run() {
        try {
            while (true) {
                List<T> consumedValues=consume();
                if(consumedValues==null || consumedValues.size()==0){
                    System.out.println("Consumed zero value it is bug");
                    System.exit(0);
                }else {
                    System.out.println("Consuming value " + consume());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<T> consume() throws InterruptedException {
        synchronized (resourceHolder) {
            if (resourceHolder.size() != 0) {
                List<T> returnList=new ArrayList<>();
                for(T ele:resourceHolder){
                    returnList.add(ele);
                }
                resourceHolder.clear();
                resourceHolder.notifyAll();
                return returnList;
            } else {
                System.out.println("Nothing to consume. Waiting for 10 sec");
                resourceHolder.wait(TimeUnit.SECONDS.toMillis(15));
            }
        }
        return null;
    }

}

class Producer<T> extends Thread {
    int Size = 5;
    private List<T> resourceHolder = null;
    private ProducerFactory factory;

    public Producer(List<T> resourceHolder, ProducerFactory producerFactory) {
        super();
        this.resourceHolder = resourceHolder;
        this.factory = producerFactory;
    }

    public void run() {
        while (true) {
            try {
                produce((T) factory.produce());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void produce(T element) throws InterruptedException {
        synchronized (resourceHolder) {
            if (resourceHolder.size() == 5) {
                try {
                    System.out.println("Produce queue full. Wating for 5 Sec");
                    resourceHolder.wait(TimeUnit.SECONDS.toMillis(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                resourceHolder.add(element);
                System.out.println("Producing resouce");
                resourceHolder.notifyAll();
                //return;
            }
        }
    }
}