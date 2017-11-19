package walSprint

new HikingSelfieProcessor().process(new Scanner(System.in))
class HikingSelfieProcessor{
    def process(Scanner scanner){
        int n=scanner.nextInt()+1
        int r=2
        int sum=0
        for (int i = r; i <=n ; i++) {
            int comboAdd=combos(n,r)
            sum=sum+comboAdd
        }
        sum= sum+1
        print(Math.abs(scanner.nextInt()-sum))

    }

    def combos = { n, r -> fac(n)/(fac(r)*fac(n-r))}

   /* def fac = { n,  acc = 1 ->
        if (n == 1) return acc
        fac.trampoline(n - 1, n * acc)
    }.trampoline()*/
    def fac = {it = it as BigInteger;  it <= 1 ? 1 : it * call(it - 1)}
}


