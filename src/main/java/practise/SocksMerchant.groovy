package practise

def scanner=new Scanner(System.in)

def socksPairs=[] as Set
int numberOfPairs=0
scanner.nextInt().times {
    int socksColor=scanner.nextInt()
    if(socksPairs.contains(socksColor)){
        numberOfPairs++
        socksPairs.remove(socksColor)
    }else {
        socksPairs.add(socksColor)
    }
}

println numberOfPairs


