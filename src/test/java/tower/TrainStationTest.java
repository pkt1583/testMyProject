package tower;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrainStationTest {
    @org.junit.Test
    public void process() throws Exception {
        List<TrainStation.Interval> intervals=new ArrayList<>();
        intervals.add(getInterval(317,1024));
        intervals.add(getInterval(2316,2318));
        intervals.add(getInterval(913,2038));
        intervals.add(getInterval(1053,2153));
        intervals.add(getInterval(1018,1323));
        intervals.add(getInterval(342,0647));
        intervals.add(getInterval(230,1534));
        intervals.add(getInterval(1418,1925));
        intervals.add(getInterval(919,2038));
        intervals.add(getInterval(1930,1936));
        assertEquals(5,TrainStation.process(intervals.toArray(new TrainStation.Interval[1])));
//answer should be 5
    }

    @Test
    public void processSimple()throws Exception{
        List<TrainStation.Interval> intervals=new ArrayList<>();
        intervals.add(getInterval(1000,2000));
        intervals.add(getInterval(1600,2130));
        intervals.add(getInterval(930,1300));
        intervals.add(getInterval(2100,2230));
        intervals.add(getInterval(1200,1230));
        assertEquals(3,TrainStation.process(intervals.toArray(new TrainStation.Interval[1])));

    }


    private TrainStation.Interval getInterval(int start,int end){
        return new TrainStation.Interval(start,end);
    }

}