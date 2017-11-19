package walSprint

import java.util.concurrent.*

new MinMaxProcessor().process(new Scanner(System.in))

/*
12345
 */

class ExecuteOperation implements Callable<Long> {
    Long start;
    Long end;

    ExecuteOperation(Long start, Long end) {

        this.start = start
        this.end = end
    }

    @Override
    Long call() throws Exception {
        Long lastVal = 0
        for (long i = start; i <= end; i++) {
            char[] ch = String.valueOf(i).toCharArray()
            for (long j = 0; j < ch.length; j = j + 1) {
                if (j + 3 <= ch.length) {
                    char[] chars = new char[3]
                    chars[0] = ch[j]
                    chars[1] = ch[j + 1]
                    chars[2] = ch[j + 2]
                    if (checkAgain(chars) != 0) {
                        lastVal = lastVal + 1
                    }
                }
            }
        }
        return lastVal
    }

    def checkAgain(char[] ch) {
        if (ch[1] < ch[0] && ch[1] < ch[2]) {
            return 1
        } else if (ch[1] > ch[0] && ch[1] > ch[2]) {
            return 1
        } else {
            return 0
        }
    }
}

class MinMaxProcessor {
    def minMaxMap = [:]

    def process(Scanner scanner) {
        def start = scanner.nextLong()
        def end = scanner.nextLong()
        if (start < 100 && end>100) {
            start=100
        }
        if(start<100 && end<100){
            println(0)
            return
        }
        //println(minMaxMap)
        long lastVal = 0
        ExecutorService executorService = Executors.newCachedThreadPool()
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executorService)
        List<Future<ExecuteOperation<Long>>> tasks = new ArrayList<>()
        for (long v = start; v <= end; v = v + 50000) {
            long tempEnd = v + 49999
            if (end < v + 50000) {
                tempEnd = end
            }
            println "Submitting  task with start $v and end $tempEnd"
            tasks.add(executorCompletionService.submit(new ExecuteOperation(v, tempEnd)))
        }

        for (long i = 0; i < tasks.size(); i++) {
          //  println "Got output"
            lastVal = lastVal + executorCompletionService.take().get()
        }


        println lastVal
        executorService.shutdown()
        return
        // int firstSet= element/100
        //println getMinMax(firstSet)
    }



}
