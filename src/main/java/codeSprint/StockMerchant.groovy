package codeSprint

def scanner = new Scanner(System.in)
def shocksMap = [:]
int pairCounts = 0;
scanner.nextInt().times {
    int n1 = scanner.nextInt()
    if (shocksMap.containsValue(n1)) {
        pairCounts++
        shocksMap[n1]=0
    } else if (shocksMap.containsKey(n1)) {
        shocksMap[n1] = n1
    } else {
        shocksMap[n1] = 0
    }
}

println shocksMap.findAll { key, value -> value != 0? true:false}.size() + pairCounts