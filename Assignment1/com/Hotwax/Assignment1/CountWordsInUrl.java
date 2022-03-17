import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class CountWordsInUrl {
    private String url;

    CountWordsInUrl(String url) {
        this.url = url;
    }

    public void getData() {
        Map<String, Integer> dataMap = null;
        try {
            Document document = null;
            // By using jsoup we are reading data from url in html form first.
            document = Jsoup.connect(url).get();
            // now url data spliting by space.
            List<String> urlDataList = List.of(document.text().split(" "));
            File file = new File("words.txt");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            // now words.txt data spliting by comma.
            List<String> fileDataList = List.of(randomAccessFile.readLine().split(","));
            dataMap = new HashMap<>();
            // using count var form checking frequency.
            int count = 0;
            for (int i = 0; i < fileDataList.size(); i++) {
                for (int j = 0; j < urlDataList.size(); j++) {
                    // comparing word of word.txt file with url text data if equals increase count.
                    if (fileDataList.get(i).equalsIgnoreCase(urlDataList.get(j))) {
                        count++;
                    }
                }
                // and here put the word and its frequency in map.
                dataMap.put(fileDataList.get(i), count);
                count = 0;
            }
            // now sorting the map through values means its frequency.
            Set<Map.Entry<String, Integer>> entries = dataMap.entrySet();
            ArrayList<Map.Entry<String, Integer>> arr = new ArrayList<>(entries);
            Collections.sort(arr, (e1, e2) -> {
                return e2.getValue() - e1.getValue();
            });
            // printing sorted.
            System.out.println("Sorted data by frequency in url : " + url);
            System.out.println(arr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
