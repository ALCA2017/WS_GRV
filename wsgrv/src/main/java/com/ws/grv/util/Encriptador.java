package com.ws.grv.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Encriptador {

    private final static String SECRETKEY = "@solmit@2016ADM";

    public static String encriptarTexto(String texto) {
        //Encriptar en MD5
        texto = encriptarMD5(texto);
        //Encriptar en SHA-256
        texto = encriptarSHA256(texto);

        return texto;
    }

    public static String encriptarBigDecimal(BigDecimal numero) {
        System.out.println(numero);
        String texto = numero.toPlainString();
        System.out.println(texto);
        texto = encriptarTexto(texto);
        return texto;
    }

    public static BigDecimal desencriptarBigDecimal(String texto) throws Exception {

        texto = desencriptarTexto(texto);

        return new BigDecimal(texto);
    }

    public static String desencriptarTexto(String texto) throws Exception {
        //desencriptar en MD5
        texto = desencriptarSHA256(texto);
        //desencriptar en SHA-256
        texto = desencriptarMD5(texto);

        return texto;
    }

    private static String encriptarSHA256(String texto) {

        String base64EncryptedString = "";
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digestOfPassword = md.digest(SECRETKEY.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    private static String encriptarMD5(String texto) {

        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(SECRETKEY.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    private static String desencriptarSHA256(String textoEncriptado) throws Exception {

        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digestOfPassword = md.digest(SECRETKEY.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    private static String desencriptarMD5(String textoEncriptado) throws Exception {

        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(SECRETKEY.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    public static String codeBase64(String texto) throws Exception {
        byte[] authBytes = texto.getBytes(StandardCharsets.UTF_8);
        String encoded = java.util.Base64.getEncoder().encodeToString(authBytes);
        return encoded;
    }

    public static String decodeBase64(String texto) throws Exception {
        String salida = "";
        try {
            byte[] decoded = java.util.Base64.getDecoder().decode(texto);
            salida = new String(decoded, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Encriptador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }

//    public static void main(String[] args) {
//        String texto = "asdfghjklñqpwoeirutymnbcvdfsgt";
//        String texto_e = encriptarTexto(texto);
//        System.out.println("texto:" + texto);
//        System.out.println("texto len:" + texto.length());
//        System.out.println("texto_e:" + texto_e);
//        System.out.println("texto_e len:" + texto_e.length());
//
//    }
}
