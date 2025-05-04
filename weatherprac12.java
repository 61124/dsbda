import java.io.*;
public class weatherprac{
    public static void main(String[] args) {
        String filepath = "weather_data.txt";
        Double tempSum = 0.0;
        Double dewSum = 0.0;
        Double windSum = 0.0;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String Line;
            Boolean firstLine=true;
            while ((Line = br.readLine())!=null) { 
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = Line.split("\t");
                if (parts.length<7) continue;
                Double temp = Double.parseDouble(parts[1]);
                Double dew = Double.parseDouble(parts[2]);
                Double wind = Double.parseDouble(parts[4]);
                tempSum+=temp;
                dewSum+=dew;
                windSum+=wind;
                count++;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        System.out.println(tempSum/count);
        System.out.println(dewSum/count);
        System.out.println(windSum/count);
    }
}