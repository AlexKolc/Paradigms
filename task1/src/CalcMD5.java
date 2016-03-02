import java.nio.file.*;
import java.security.*;
import java.io.*;
import java.math.BigInteger;

public class CalcMD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        for (String file : Files.readAllLines(Paths.get(args[0]))) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(Files.readAllBytes(Paths.get(file)));
            System.out.println(String.format("%032X", new BigInteger(1, hash)));
        }
    }
}