import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            int line;
            int sum = 0;
            while ((line = reader.read()) != -1) {
                System.out.println(line);
                sum += line;
            }
            reader.close();
            inputStreamReader.close();
            fileInputStream.close();
            System.out.println("Tổng = " + sum);
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readfileEx = new ReadFileExample();
        readfileEx.readFileText(path);
    }
}
