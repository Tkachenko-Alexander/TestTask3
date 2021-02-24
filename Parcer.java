package task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcer {
    static public final SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    static public final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    static public final String inputTag = " wanna top up ";
    static public final String outputTag = " wanna scoop ";
    static public final String uom = "l";

    // 2020-01-01T12:00:00
    public final Date startDate, endDate;
    private Date currentDate;

    public Parcer (String startDate, String endDate) throws ParseException {
        this.startDate = dataFormat.parse(startDate);
        this.endDate = dataFormat.parse(endDate);
    }
    public double parceLine(String line) throws ParseException {
        currentDate = simpleDataFormat.parse(line.substring(0,23));
        if (currentDate.before(startDate))
            return 0;
        if (currentDate.after(endDate))
            return 0;
        // line.split("-")[4];
        return Double.valueOf(line.split("-")[3].replace(uom,"").replace(inputTag,"").replace(outputTag, ""));
        }
        public void generate(int lineCnt, String fileName) {
        Date startDate = new Date();
        try( BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            while (lineCnt-- > 0) {
                writer.write(simpleDataFormat.format(startDate));
                writer.write(" – [username1] -");
                writer.write(generateRandomValue(300));
                writer.newLine();
            }

            } catch (IOException e) {
            e.printStackTrace();
        }

        }
        private String generateRandomValue(double maxVolume){
        double valume = Math.random()*maxVolume;
        return (Math.random()>0.5? inputTag: outputTag) + valume + uom;
        }
}
