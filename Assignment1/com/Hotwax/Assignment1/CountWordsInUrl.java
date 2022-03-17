import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CountWordsInUrl {
    private String url;

    CountWordsInUrl(String url) {
        this.url = url;
    }

    public void getData() {
        try {
            Document document = null;
            document = Jsoup.connect(url).get();
            String[] arrrayUrlData = document.text().split(" ");
            File file = new File("words.txt");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            String[] arrayFileData = randomAccessFile.readLine().split(",");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
