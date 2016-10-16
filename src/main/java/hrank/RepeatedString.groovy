package hrank

new Processor().beingProcess()

class Processor {
    def beingProcess() {
        def scanner = new Scanner(System.in)
        String inputString = scanner.next()
        long numberOfChars = scanner.nextLong()
        long multiplier = 0
        long additional = 0
        def uniqueElement = [] as Set
        long repeat = countRepeat(inputString, uniqueElement)

        if (numberOfChars > inputString.length()) {
            numberOfChars = numberOfChars - inputString.length()
            multiplier = numberOfChars / inputString.length()
            additional = numberOfChars % inputString.length()
        }
        long totalRepeat = (multiplier * repeat) + repeat

        for(char  ch:inputString.toCharArray()){
            if(additional==0){
                break;
            }else {
                if ( ch == 'a') {
                    uniqueElement << ch

                    totalRepeat++
                }
            }
            additional--
        }
        // println "multiplier is $multiplier and additional is $additional and numberOfChars $numberOfChars and repeat is $repeat and total repeat is $totalRepeat"
        println uniqueElement.size() == 0 ? 0 : totalRepeat

    }

    def countRepeat(String input, uniqueElement) {

        def repeatCount = 0
        input.each {
            if (isDupPerRule(it, uniqueElement)) {
                uniqueElement << it
                repeatCount++
            }
        }
        return repeatCount
    }

    def isDupPerRule(element, uniqueElement) {
        //return  !uniqueElement.add(element)
        return element == "a"
    }
}