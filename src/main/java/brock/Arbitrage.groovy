package brock


def scanner=new Scanner(new BufferedReader(new InputStreamReader(System.in)))
int numberOfInput=scanner.nextInt()
final int intialAmount=100000
def rateList=[]
numberOfInput.times {
    rateList<< new RateInfo(usdEurRate:scanner.nextDouble(),eurGbpRate:scanner.nextDouble(),gbpUsdRate:scanner.nextDouble())
}
rateList.each {
    int arbitarageAmount=it.getConversionAmount(intialAmount)-intialAmount
    if(arbitarageAmount<0)
        println 0
    else
    println arbitarageAmount
}
class RateInfo{
    double usdEurRate;
    double eurGbpRate;
    double gbpUsdRate;

    def getConversionAmount(initialAmount){
        def finalVal= initialAmount/usdEurRate/eurGbpRate/gbpUsdRate
    }
}