package openbracket


new Caandies().process()

class Caandies {
    def scanner = new Scanner(System.in)
    def numberOfMachines
    def numberOfWorkers
    def costOfWorkerOrMachine
    def targetCandies

    def process() {
         numberOfMachines = scanner.nextDouble()
         numberOfWorkers = scanner.nextDouble()
         costOfWorkerOrMachine = scanner.nextDouble()
         targetCandies = scanner.nextDouble()

        def producedCandies = numberOfWorkers * numberOfMachines

        if (producedCandies == targetCandies) {
            println 1
            return
        }
        buy(producedCandies)

        println(iterations)
    }
    long iterations=1
    def buy(candies){
        double numberOfMaxBuy=candies/costOfWorkerOrMachine
        iterations=iterations+1
        for(double i=1;i<=numberOfMaxBuy;i++){
            def currentCandies=numberOfMachines*(i+numberOfWorkers)
            if(currentCandies<targetCandies){
                candies=currentCandies

            }else if(targetCandies<=currentCandies){
                return
            }
        }
        //iterations++
        buy(candies)

    }

}



