package brock

/**
 * Created by pankaj on 11-06-2016.
 */
class FixedIncomeSecurityTradeAllocation {
    public static void main(String[] args) {
        new FixedIncomeSecurityTradeAllocation().solve()
    }

    void solve(){

    }

    class FixedIncomeSecurity{
        def minimumTradeSize,  increment, availableUnit
        def tradeAbleAmount={n -> minimumTradeSize+(increment*n)}

    }

    class FixedIncomeTrader{
        def numberOfFixedIncomeSecurity //portfolio order
        def totalOrder
    }
}


