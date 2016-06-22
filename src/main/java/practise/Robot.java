package practise;

public class Robot {
    public static void main(String[] args) {
        int[] spaces=new int[10];
        String command="PMLPMMMLPMLPMML";
        command="PLPLPLPLPLPLPLPLPLPL";
        command="LML";
        char ch[]=command.toCharArray();
        int robotPosition=0;
        boolean hasPickedup=false;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='P'){
                robotPosition=0;
                hasPickedup=true;
            }else if(ch[i]=='M'){
                if(robotPosition==9){
                    continue;
                }else {
                    if(hasPickedup) {
                        robotPosition = robotPosition + 1;
                    }
                }
            }else if(ch[i]=='L'){
                if(spaces[robotPosition]<15 && robotPosition!=0) {
                    spaces[robotPosition] = spaces[robotPosition] + 1;
                    robotPosition = 0;
                    hasPickedup=false;
                }
            }
        }

        for(int i=0;i<spaces.length;i++){
            System.out.print(Integer.toHexString(spaces[i]));
        }
    }
}
