package lesson5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreateFileClass {

    public static final String path = "src/main/java/lesson5/demo.csv";
    public static final String titles = "value1"+ ";" + "value2"
            + ";" + "value3" + ";"+ System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        write();

        AppData appData = read();
        System.out.println(Arrays.deepToString(appData.getData()));
    }


    public static void write() throws IOException {
        Random random = new Random();
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)){
            for(byte b :titles.getBytes(StandardCharsets.UTF_8)){
                fileOutputStream.write(b);
            }
            for(int i=1;i<1000;i++) {
                String raw = random.nextInt(100) + ";" + random.nextInt(200)
                        + ";" + random.nextInt(300) + ";"+ System.getProperty("line.separator");
                for(byte b :raw.getBytes(StandardCharsets.UTF_8)){
                    fileOutputStream.write(b);
                }
            }
        }
    }

    public static AppData read() throws IOException {
        AppData appData = new AppData();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            appData.setHeaders( line.split(";"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        }

        int[][] resultData = new int[records.size()][3];

        for(int i=0;i<records.size();i++){
            for(int j=0;j<records.get(i).size();j++){
                resultData[i][j] = Integer.parseInt(records.get(i).get(j));
            }
        }
        appData.setData(resultData);
        return appData;

    }


}