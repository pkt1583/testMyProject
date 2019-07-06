package hrank;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ForegroundBackGround {
    public static void main(String[] args) {
        ForegroundBackGround foregroundBackGround = new ForegroundBackGround();
        List<List<Integer>> background = new ArrayList<>();
        background.add(Lists.newArrayList(1, 2));
        System.out.println(foregroundBackGround.optimalUtilization(7,
                newArrayList(newArrayList(1, 2), newArrayList(2, 4), newArrayList(3, 6)),
                background)
        );
    }

    class IdAndMemory {
        Integer id;
        Integer memoryRequired;

        public IdAndMemory(Integer id, Integer memoryRequired) {
            this.id = id;
            this.memoryRequired = memoryRequired;
        }

    }

    class ApplicationPair {
        IdAndMemory foreground;
        IdAndMemory background;
        int sumOfMemory;

        public ApplicationPair(IdAndMemory foreground, IdAndMemory background) {
            this.foreground = foreground;
            this.background = background;
            this.sumOfMemory = foreground.memoryRequired + background.memoryRequired;
        }
    }

    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList) {
        List<List<Integer>> output = new ArrayList<>();

        List<ApplicationPair> temporyOutput = new ArrayList<>();
        for (List<Integer> forgroundApp : foregroundAppList) {
            int foregroundMemoryRequired = forgroundApp.get(1);
            for (List<Integer> backgroundApp : backgroundAppList) {
                int backgroundMemoryRequired = backgroundApp.get(1);
                if (backgroundMemoryRequired + foregroundMemoryRequired <= deviceCapacity) {
                    temporyOutput.add(new ApplicationPair(new IdAndMemory(forgroundApp.get(0), forgroundApp.get(1)),
                            new IdAndMemory(backgroundApp.get(0), backgroundApp.get(1))));
                }
            }
        }
        if(temporyOutput.size()==0){
            return Collections.emptyList();
        }

        Collections.sort(temporyOutput, new Comparator<ApplicationPair>() {
            @Override
            public int compare(ApplicationPair applicationPair, ApplicationPair t1) {
                return applicationPair.sumOfMemory < t1.sumOfMemory ? 1 : -1;
            }
        });
        int bestValue = 0;
        for (ApplicationPair applicationPair : temporyOutput) {
            if (applicationPair.sumOfMemory < bestValue) {
                break;
            } else {
                bestValue = applicationPair.sumOfMemory;
                List<Integer> out=new ArrayList<>();
                out.add(applicationPair.foreground.id);
                out.add(applicationPair.background.id);
                output.add(out);

            }
        }
        return output;
    }
}
