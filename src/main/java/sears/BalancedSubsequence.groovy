package sears
def scanner=new Scanner(System.in)

new Processor().process(scanner)

class Processor{
    def process(Scanner scanner){
        scanner.nextInt().times {
            char [] ch=scanner.next().toCharArray()
            startOperation(ch)
        }

    }

    def startOperation(char[] chars) {
        def elements=[] as Stack
        int count=0;
        chars.each {

            if(elements.size()!=0 && (elements.peek()=='(' && it==')')){
                elements.pop()
                count++
            }else if(it=='('){
                elements.push('(')
            }
        }
        println(count*2)
    }
}



