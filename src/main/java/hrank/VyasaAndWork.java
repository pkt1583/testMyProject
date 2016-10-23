package hrank;

import java.util.*;

public class VyasaAndWork {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int arraySize=scanner.nextInt();
        Map<Integer,Family> familyMap=new HashMap<>();
        char[] foodT=scanner.next().toCharArray();
        char[] sleepT=scanner.next().toCharArray();
        for (int i = 0; i <arraySize; i++) {
            familyMap.put(i+1,new Family(foodT[i]+"",Integer.parseInt(sleepT[i]+"")));
        }
        int numberOfQueries=scanner.nextInt();
        for(int i=0;i<numberOfQueries;i++){
            int startIndex=scanner.nextInt();
            int endIndex=scanner.nextInt();
            process(familyMap,startIndex,endIndex);
        }
    }

    private static void process(Map<Integer, Family> familyMap, int startIndex, int endIndex) {
        Set<Family> familySet=new HashSet<>();
        int specialFamilies=0;
        while (true){
            if(startIndex<=endIndex){
                if(familySet.contains(familyMap.get(startIndex))){
                    specialFamilies++;

                }else {
                    familySet.add(familyMap.get(startIndex));
                }
                startIndex++;
            }else {
                break;
            }
        }
        System.out.println(getCommbinations(specialFamilies));

    }

    private static long getCommbinations(int number){
        long res=1;

        if(number>=2)
        {
            res=getFact(number)/(getFact(number-2)*getFact(2));
            System.out.println("The result is "+res);
        }
        return res;
    }

    public static long getFact(int n)
    {
        long f=1;

        for(int i=n;i>=1;i--)
        {
            f*=i;
        }

        return f;
    }

    static class Family{
        String foodType;
        int sleepType;

       public Family(String foodType, int sleepType) {
           this.foodType = foodType;
           this.sleepType = sleepType;
       }

       public Family(String  foodType) {
            this.foodType = foodType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Family family = (Family) o;

            if ((sleepType != family.sleepType) && foodType.equals(family.foodType))return true;
            if ((sleepType == family.sleepType) && !foodType.equals(family.foodType))return true;
            if ((sleepType == family.sleepType) && foodType.equals(family.foodType))return true;
            return false;
        }

        @Override
        public int hashCode() {
            int result = 31 * sleepType;
            return result;
        }

        @Override
       public String toString() {
           return "Family{" +
                   "foodType='" + foodType + '\'' +
                   ", sleepType=" + sleepType +
                   '}';
       }
   }


}
