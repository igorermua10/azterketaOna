package ehu.isad;

import org.apache.commons.codec.binary.Hex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestForUrl {

    public static String md5Itzuli(String helbidea) throws NoSuchAlgorithmException, FileNotFoundException, IOException {

        URL url = new URL(helbidea);
        InputStream is = url.openStream();
        MessageDigest md = MessageDigest.getInstance("MD5");
        String emaitza = getDigest(is, md, 2048);

        return emaitza;

    }

    public static String getDigest(InputStream is, MessageDigest md, int byteArraySize)
            throws NoSuchAlgorithmException, IOException {

        md.reset();
        byte[] bytes = new byte[byteArraySize];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            md.update(bytes, 0, numBytes);
        }
        byte[] digest = md.digest();
        String result = new String(Hex.encodeHex(digest));
        return result;
    }

}