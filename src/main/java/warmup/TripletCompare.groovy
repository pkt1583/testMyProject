package warmup

def scanner=new Scanner(System.in)
def alice=new Integer[3]
def bob=new Integer[3]
3.times {
 alice[it]=scanner.nextInt()
}
3.times {
    bob[it]=scanner.nextInt()
}

int bobPoints=0
int alicePoints=0

3.times {
    if(alice[it]>bob[it]){
        alicePoints++
    }else if (alice[it]<bob[it]){
        bobPoints++
    }
}

println "$alicePoints $bobPoints"