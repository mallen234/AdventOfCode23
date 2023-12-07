import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;

public class main {
    public static void main(String[] args) throws IOException
    {
        File input = new File("./input.txt");
        Scanner scan = new Scanner(input);

        ArrayList<String> data = new ArrayList<>();

        while (scan.hasNextLine()){
            data.add(scan.nextLine());
        }
//        System.out.println(data);


        HashMap<Integer,Integer> ticketCount = new HashMap<>();
        for (int i = 1; i<=220; i++){
            ticketCount.put(i,1);
        }
        
        double points = 0;
        int i = 0;
        for (String s: data) {
            i++;
            String[] ticket = s.split(": ");
            String[] numbers = ticket[1].split("\\|");
            String[] guesses = numbers[0].replace("  "," ").trim().split(" ");
            int matches = 0;
            for (String num : guesses){
                if (numbers[1].contains(String.format(" %s ", num))) {
                    matches ++;
                }
            }
            int curr_tix = ticketCount.get(i);
            for (int j = i+1; j <= (i + matches); j++){
                ticketCount.merge(j, curr_tix, Integer::sum);

            }
            if (matches != 0) {
                int x = matches - 1;
                points += Math.pow(2, x);
            }
        }
        int tot = 0;
        for (int a = 1; a<=220; a++){
            tot+=ticketCount.get(a);
        }
        System.out.println(ticketCount);
        System.out.println(tot);

    }

    public static String pad(String s) {
        return String.format("%-" + s.length()+1 + "s", s);
    }

    public static String padLeft(String s) {
        return String.format("%" + s.length()+1 + "s", s);
    }
}

