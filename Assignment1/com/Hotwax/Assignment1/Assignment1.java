import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Assignment1 {
    public static void main(String[] gg) {

        File file = new File("Urls.txt");
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            // reading urls from url.txt.
            String url1 = randomAccessFile.readLine();
            String url2 = randomAccessFile.readLine();
            // passing the urls to CountWordsInUrl class
            CountWordsInUrl countWordsInUrl = new CountWordsInUrl(url1);
            countWordsInUrl.getData();
            CountWordsInUrl countWordsInUrl2 = new CountWordsInUrl(url2);
            countWordsInUrl2.getData();
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
