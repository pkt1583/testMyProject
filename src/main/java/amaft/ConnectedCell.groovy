package amaft

/**
 * Created by pankaj on 13-06-2016.
 */
def scanner=new Scanner(new InputStreamReader(System.in))
int rows=scanner.nextInt()
int cols=scanner.nextInt()

List<List<Integer>> records=[]
rows.times {
    List<Integer> rowsLine=[]
    cols.times {
            rowsLine.add(scanner.nextInt())
    }
    records.add(rowsLine)
}

int count=0;
int currentMaxCount=0;
records.eachWithIndex { List<Integer> entry, int rowIndex ->
    entry.eachWithIndex { int rowVal, int columnIndex ->
        if(rowVal==1){
            if(getRecordAt(records,rowIndex-1,columnIndex) || getRecordAt(records,rowIndex,columnIndex-1) || getRecordAt(records,rowIndex,columnIndex+1) || getRecordAt(records,rowIndex+1,columnIndex)){
                count++
                if(count>currentMaxCount){
                    currentMaxCount=count
                }
            }
        }
    }
}

println currentMaxCount
def getRecordAt(records,row,column){
    try {
        if(records.get(row).get(column)==1)
            true
    }catch ( aa){
        false
    }
}

/*
5
5
1 1 0 0 0
0 1 1 0 0
0 0 1 0 1
1 0 0 0 1
0 1 0 1 1*/
