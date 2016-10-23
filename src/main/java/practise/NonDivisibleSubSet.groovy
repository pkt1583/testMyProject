package practise

def scanner=new Scanner(System.in)

int numberOfElements=scanner.nextInt()
int divisor=scanner.nextInt()

def elements=[] as List

numberOfElements.times {
    elements<<scanner.nextInt()
}

for(int i=0;i<elements.size();i++){
    int iElement=elements.get(i)
    for(int j=i+1;j<elements.size();j++){
        int jElement=elements.get(j)
        if((iElement+jElement)%divisor==0){
            elements.remove(jElement)
            j=i+1
        }
    }
}

println elements

println elements.size()

/*
Failing case
5 1
1 2 3 4 5

output: 1

 */