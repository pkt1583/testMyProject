package tower;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrainStation {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(new BufferedInputStream(System.in));
        int numberOfInput=scanner.nextInt();
        Interval interval[]=new Interval[numberOfInput];
        for(int i=0;i<numberOfInput;i++){
            interval[i]=new Interval(Integer.parseInt(scanner.next()),Integer.parseInt(scanner.next()));
        }
        System.out.println( process(interval));

    }

    public static int process(Interval ...trains){
        Map<Integer, Interval> platforms = new HashMap<>();
        Interval timeSortedTrains[]=sortTrainsBasedOnArrivalTime(trains);
        return numberOfPlatformOccupied(platforms,timeSortedTrains);
    }


    private static Interval[] sortTrainsBasedOnArrivalTime(Interval... trains) {
        Arrays.sort(trains);
        return trains;
    }

    private static int numberOfPlatformOccupied(Map<Integer, Interval> platforms, Interval... trains) {
        int platformIndex = 1;
        platforms.put(platformIndex, trains[0]);
        if (trains.length == 1) {
            return 1;
        } else {
            for (int i = 1; i < trains.length; i++) {
                int freePlatform=getFreePlatform(trains[i],platforms);
                if(freePlatform==0){
                    platforms.put(++platformIndex,trains[i]);
                }else {
                    platforms.put(freePlatform, trains[i]);
                }
            }
        }

        return platforms.size();
    }

    private static int getFreePlatform(Interval train, Map<Integer, Interval> platforms) {
        int probableNewPlatform;boolean isOverlappedChecked;
        for(Map.Entry<Integer,Interval> entry:platforms.entrySet()){
            if(entry.getValue().departureTime<train.arrivalTime){
                return entry.getKey();
            }
        }
        return 0;
    }

    static class Interval implements Comparable<Interval> {
        int arrivalTime;
        int departureTime;

        public Interval(int arrivalTime, int departureTime) {
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "arrivalTime=" + arrivalTime +
                    ", departureTime=" + departureTime +
                    '}';
        }

        @Override
        public int compareTo(Interval o) {
            if (this.arrivalTime < o.arrivalTime) {
                return -1;
            } else if (this.arrivalTime > o.arrivalTime) {
                return 1;
            } else if (this.departureTime < o.departureTime) {
                return -1;
            } else if (this.departureTime > o.departureTime) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
