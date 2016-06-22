package tower;

import java.io.BufferedInputStream;
import java.util.*;

public class CabTimings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int numberOfInput = scanner.nextInt();
        List<Duration> sortedDuration = new ArrayList<>();
        Set<Duration> cabs=new HashSet<>();
        for (int i = 0; i < numberOfInput; i++) {
            String str = scanner.next();
            String[] startTime = str.split(":");
            long start = (Integer.parseInt(startTime[0]+""+startTime[1]));
            str = scanner.next();
            startTime = str.split(":");
            long end = (Integer.parseInt(startTime[0]+""+startTime[1]));
            Duration duration = new Duration(start, end);
            sortedDuration.add(duration);
        }
       /* Iterator<Duration> iterator=sortedDuration.iterator();
        while (iterator.hasNext()){

        }*/
        Collections.sort(sortedDuration);
        cabs.add(sortedDuration.get(0));
        for(int i=1;i<sortedDuration.size();i++){
            boolean done=false;
            for(Duration entry:cabs){
                Duration newDuration=sortedDuration.get(i);
                if(checkCanBeReused(i,sortedDuration,newDuration,cabs)){
                    done=true;
                    break;
                }
              if(entry.isOverlap(newDuration)){
                  cabs.add(sortedDuration.get(i));
                  done=true;
                  break;
              }

            }
            if(!done)
                cabs.add(sortedDuration.get(i));
        }

        System.out.println(cabs.size()+1);
    }

    private static boolean checkCanBeReused(int index, List<Duration> sortedDuration,Duration duration,Set<Duration> cabs) {
        for(int i=0;i<index;i++){
            if(sortedDuration.get(i).endtime<duration.starttime){
                cabs.remove(sortedDuration.get(i));
                sortedDuration.remove(i);
                cabs.add(duration);
                return true;
            }
        }
        return false;
    }
  static   class Duration implements Comparable<Duration> {
        long starttime;
        long endtime;

        public Duration(long start, long end) {
            this.starttime = start;
            this.endtime = end;
        }

        @Override
        public String toString() {
            return "Duration{" +
                    "starttime=" + starttime +
                    ", endtime=" + endtime +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Duration duration = (Duration) o;

            if (starttime != duration.starttime) return false;
            return endtime == duration.endtime;

        }

        @Override
        public int hashCode() {
            int result = (int) (starttime ^ (starttime >>> 32));
            result = 31 * result + (int) (endtime ^ (endtime >>> 32));
            return result;
        }

        public boolean isOverlap(Duration other){
            if(this.endtime>=other.starttime && this.endtime>=other.endtime){
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Duration o) {
       /* if(isOverlap(o)){
            return 0;
        }*/
            if (this.starttime < o.starttime) {
                return -1;
            } else if (this.starttime > o.starttime) {
                return 1;
            } else {

                return 0;
            }
        }
    }

}


