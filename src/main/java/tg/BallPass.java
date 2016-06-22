package tg;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class BallPass {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(new BufferedInputStream(System.in));
      //  int  numberOfFriends=scanner.nextInt();
       // int maxPass=scanner.nextInt();
       // int steps=scanner.nextInt();
        System.out.println(passCount(5,3,2));
    }

    public static int passCount(int input1,int input2,int input3)
    {
        Person currentBallHolder=null;
        LinkedList<Person> list=new LinkedList<>();
        for (int i = 0; i < input1; i++) {
            list.add(new Person(input2,i+1));
        }
        int ballPassedCount=0;
        ListIterator<Person> iterator=list.listIterator();
        currentBallHolder=list.getFirst();
        while (true){
            if(ballPassedCount==0){
                Person person=iterator.next();
                ballPassedCount=ballPassedCount+1;
                if(person.isMaxPassed()){
                    return ballPassedCount;
                }
            }else {
                if((currentBallHolder.id)%2.0==0.0){
                    for (int i = 0; i <input3; i++) {
                        if(iterator.hasPrevious()) {
                            currentBallHolder = iterator.previous();
                            if(currentBallHolder.equals(iterator.next())){
                                currentBallHolder=iterator.previous();
                            }
                        }else {
                            while (iterator.hasNext()){
                               currentBallHolder= iterator.next();
                            }
                        }
                    }
                    if(currentBallHolder.isMaxPassed()){
                        return ballPassedCount;
                    }else {
                        ballPassedCount=ballPassedCount+1;
                        currentBallHolder.ballReceivedCount=currentBallHolder.ballReceivedCount+1;
                    }
                }else {
                    for(int i=0;i<=input3;i++){
                        if(iterator.hasNext()){
                            currentBallHolder= iterator.next();
                            if(currentBallHolder.equals(iterator.previous())){
                                currentBallHolder=iterator.next();
                            }
                        }else {
                            while (iterator.hasPrevious()){
                                currentBallHolder=iterator.previous();
                            }
                        }
                    }
                    if(currentBallHolder.isMaxPassed()){
                        return ballPassedCount;
                    }else {
                        ballPassedCount=ballPassedCount+1;
                        currentBallHolder.ballReceivedCount=currentBallHolder.ballReceivedCount+1;
                    }
                }
            }
        }
    }

    static class Person{
         final int id;
        int ballReceivedCount=0;
        int maxPass;
        Person nextPerson;
        Person previousPerson;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            return id == person.id;

        }

        @Override
        public int hashCode() {
            return id;
        }

        public Person(int maxPass, int id){
            this.maxPass=maxPass;
            this.id=id;
        }
        public boolean isMaxPassed(){
            return ballReceivedCount==maxPass;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", ballReceivedCount=" + ballReceivedCount +
                    ", maxPass=" + maxPass +
                    '}';
        }
    }
}
