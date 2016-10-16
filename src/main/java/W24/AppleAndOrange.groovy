package W24

def scanner = new Scanner(System.in)

int sama = scanner.nextInt()
int samb = scanner.nextInt()

int apple = scanner.nextInt()

int orange = scanner.nextInt()

int numberOfApples = scanner.nextInt()

int numberOfOranges = scanner.nextInt()

int aCount=0
int bCount=0
numberOfApples.times {
    int position = apple + (scanner.nextInt())

    if (position >= sama) {
        aCount = aCount + 1
    }
}

numberOfOranges.times {
    int position = orange + (scanner.nextInt())
    if (position <= samb) {
     //   println "Printing count for $position"
        bCount = bCount + 1
    }
}

println(aCount)
println(bCount)
