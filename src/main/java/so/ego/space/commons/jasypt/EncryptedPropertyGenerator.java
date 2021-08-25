package so.ego.space.commons.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptedPropertyGenerator {
    public static void main(String[] args) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword("password");
        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");

        String cipherText = standardPBEStringEncryptor.encrypt("put the text");
        String plainText = standardPBEStringEncryptor.decrypt(cipherText);

        System.out.println("CipherText : " + cipherText);
        System.out.println("PlainText : " + plainText);
    }
}