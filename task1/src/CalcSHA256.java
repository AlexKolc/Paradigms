import javax.xml.bind.DatatypeConverter;
import java.nio.file.*;
import java.security.*;
import java.io.*;

public class CalcSHA256 {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        for (String file : Files.readAllLines(Paths.get(args[0]))) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(Files.readAllBytes(Paths.get(file)));
            System.out.println(DatatypeConverter.printHexBinary(hash));
        }
    }
}