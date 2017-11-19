package walSprint

def processor=new Problem1Processor()
processor.process(new Scanner(System.in))
class Problem1Processor{
    def process(Scanner scanner){
        int n=scanner.nextInt()
        int[] elements=new int[n]
       int totalpossibilities=Math.pow(2,n)-1
        println Math.abs(totalpossibilities-scanner.nextInt())
    }




}

