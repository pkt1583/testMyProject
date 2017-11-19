package W24

def scanner=new Scanner(System.in)

def firstWord=scanner.next()

def secondWord=scanner.next()

def numberOfOperations=scanner.nextInt()

new AppendDeleteProcessor(firstWord: firstWord,secondWord: secondWord,numberOfOperations: numberOfOperations).process()
class AppendDeleteProcessor{
    def firstWord
    def secondWord
    def numberOfOperations
    def process(){
        if(firstWord==secondWord){
            if(numberOfOperations>=firstWord*2){
                println "YES"
                return
            }
        }
    }
}

