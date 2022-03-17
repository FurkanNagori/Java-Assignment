import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CountWordsInUrl {
    private String url;

    CountWordsInUrl(String url) {
        this.url = url;
    }

    public Map<String, Integer> getData() {
        Map<String, Integer> dataMap = null;
        try {
            Document document = null;
            document = Jsoup.connect(url).get();
            List<String> urlDataList = new ArrayList<>();
            urlDataList = List.of(document.text().split(" "));
            File file = new File("words.txt");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            List<String> fileDataList = new ArrayList<>();
            fileDataList = List.of(randomAccessFile.readLine().split(","));
            dataMap = new HashMap<>();
            int count = 0;
            for (int i = 0; i < fileDataList.size(); i++) {
                for (int j = 0; j < urlDataList.size(); j++) {
                    if (fileDataList.get(i).equalsIgnoreCase(urlDataList.get(j))) {
                        count++;
                    }
                }
                dataMap.put(fileDataList.get(i), count);
                count = 0;
            }
            System.out.println("For URL : "+url);
            for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }

}
