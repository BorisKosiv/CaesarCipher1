import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        FileService fileService = new FileService();
        CaesarCipher caesarCipher = new CaesarCipher();
        Runner runner = new Runner(caesarCipher, fileService);
        runner.run(args);

    }
}
