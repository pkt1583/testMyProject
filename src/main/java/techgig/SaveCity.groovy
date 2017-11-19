package techgig


class SaveCity {
    public static void main(String[] args) {
        def scanner=new Scanner(System.in)
        def attackingKingPower=scanner.nextInt()
        def numberOfInput=scanner.nextInt()
        def input=[]
        numberOfInput.times {
            input<<scanner.nextInt()
        }
        Map<Integer, SortedSet<Integer>> combinations = new TreeMap<>()
        input.each {
            int numberOfHelpers = it
            sumOfFriends(it, input, combinations)
        }
       println getSurvivingCity(combinations,attackingKingPower)
    }

    static def getSurvivingCity(Map<Integer, SortedSet<Integer>> maps,attackingKingPower) {

        for(Map.Entry<Integer,SortedSet<Integer>> entry:maps.entrySet()){
            if(entry.value.last()>attackingKingPower){
                return entry.key
            }
        }
            -1

        /*maps.forEach{ key, val ->
            int maxValue = val.last()
            println key
        }*/
    }

    static def sumOfFriends(number, integers, combinations) {
        Set<Integer> elements = new TreeSet<>()
        for (int i = 0; i < integers.size(); i++) {
            int innerSum = 0
            for (int j = i; j <= (number + i) - 1; j++) {
                if (j < integers.size()) {
                    innerSum = innerSum + integers[j]
                } else {
                    innerSum = -1
                }
            }
            if (innerSum != -1) {
                elements.add(innerSum)
            }
            //combinations.add(-1)
        }
        combinations.put(number, elements)

    }
}
