package walSprint

def scanner=new Scanner(System.in)

long start=scanner.nextLong()
long end=scanner.nextLong()

new NewMinMaxPocessor().process(start,end)

class NewMinMaxPocessor{
    def process(long start,long end){
        long lastVal=0
        long initVal=start

        for(int i=0;i<10;i++){
            char[] ch = String.valueOf(initVal).toCharArray()
            while (initVal<end){
                for(int j=0;j<=9;j++){
                    ch
                }
            }
        }
    }

    def checkAndIncrement(ch,lastVal){
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


