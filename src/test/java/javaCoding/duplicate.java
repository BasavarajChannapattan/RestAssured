package javaCoding;

public class duplicate {
    public static void main(String[] args) {
        String name = "Big black bug bit a big black dog on his big black nose";
        name = name.toLowerCase();
     int count;
        String[] words = name.split(" ");
        //print duplicate words
        for(int i = 0; i < words.length; i++) {

             count =1;
            for(int j=i+1; j< words.length; j++) {
                if(words[i].equals(words[j])) {
                    count++;
                words[j]= "0";
                }
            }
            if(count>1 && ! words[i].equals("0")) {
                System.out.println(words[i]);
        }
    }
}
}
