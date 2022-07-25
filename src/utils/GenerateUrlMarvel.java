package utils;

import config.Keys;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateUrlMarvel {

    public String generate(String url) {
        var key = new Keys();
        String publicKey = key.getPublicKey();
        String privateKey = key.getPrivateKey();
        // Trabalha com
        if (url.contains("marvel") && url.contains("events")) {
            url = "https://gateway.marvel.com/v1/public/events?" + accessUrl(publicKey, privateKey);
        } else if( url.contains("marvel") && url.contains("characters")) {
            url = "https://gateway.marvel.com/v1/public/characters?" + accessUrl(publicKey, privateKey);
        }

        return url;
    }

    private String accessUrl(String publicKey, String privateKey) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
        String timeStamp = date.format(new Date())
                .replaceAll("\\.", "")
                .replaceAll(":", "");
        String hash = timeStamp + privateKey + publicKey;
        return  "ts=" + timeStamp +
                "&apikey=" + publicKey +
                "&hash=" + getMd5(hash) +
                "&limit=100"; // No momento (2022) retorna no máximo 100 personagem ou títulos
    }

    // Fonte Md5: https://www.geeksforgeeks.org/md5-hash-in-java/
    private static String getMd5(String input)
    {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }



}
