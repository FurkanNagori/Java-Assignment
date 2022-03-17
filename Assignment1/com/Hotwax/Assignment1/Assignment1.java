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
            String url1 = randomAccessFile.readLine();
            System.out.println(url1);
            CountWordsInUrl countWordsInUrl = new CountWordsInUrl(url1);
            countWordsInUrl.getData();
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
