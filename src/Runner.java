import java.io.IOException;

public class Runner {
CaesarCipher caesarCipher;
FileService fileService;

    public Runner(CaesarCipher caesarCipher, FileService fileService) {
        this.caesarCipher = caesarCipher;
        this.fileService = fileService;
    }

    public void run(String[] args) throws IOException {
    if (args.length > 0 ) {

        String command = (args[0]).toLowerCase();
        String path = args[1];
        String typeCommand = "";
        int shiftKey = Integer.parseInt(args[2]);
        String message = fileService.read(path);
        String cypherUncypherText = caesarCipher.encryptDecrypt(command, message, shiftKey);
        if (command.equals("encrypt")) {
                typeCommand = "[ENCRYPTED]";
        } else if (command.equals("decrypt")) {
                typeCommand = "[DECRYPTED]";
        }
        fileService.write(typeCommand, path, cypherUncypherText );
    }

}

}
