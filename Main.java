package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Barrel barrel = new Barrel(200, 32);
        if(!(barrel.getTotalAttempsCnt() == 0)){
            System.out.println("problem11");
        }
        barrel.addLine(10);
        barrel.addLine(500);
        if(!(barrel.getErrorPercents() == 0.5)){
            System.out.println("problem16");
        }
        if(!(barrel.getTotalImput() == 10)){
            System.out.println("problem19");
        }
        if(!(barrel.getTotalFailInput() == 500)){
            System.out.println("problem22");
        }
        barrel.addLine(-12);
        barrel.addLine(-550);

        if(!(barrel.getOutputCnt() == 2 )){
            System.out.println("problem28");
        }
        if(!(barrel.getOutputErrorProcents() == 0.5)){
            System.out.println("problem31");
        }
        if(!(barrel.getTotalOutput() == -12)){
            System.out.println("problem34");
        }
        if(!(barrel.getTotalFailOutput() == -550)){
            System.out.println("problem37");
        }
        Parcer parcer;
        String name;
         if (args.length >= 3) {
             parcer = new Parcer(args[1], args[2]);
             name = args[0];
        }else {
            parcer = new Parcer("2021-02-23T19:02:48.901","2021-02-23T19:02:48.901");
            name = "res/Log1.txt";
        }

        /* try(BufferedReader reader = new BufferedReader( new FileReader(name)) ){
            String line;
            while( ( line = reader.readLine() ) != null ){
              //  line.split("") [2]
            barrel.addLine(parcer.parceLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } */
          parcer.generate(15_000,"res/Log1.txt");
    }
}
