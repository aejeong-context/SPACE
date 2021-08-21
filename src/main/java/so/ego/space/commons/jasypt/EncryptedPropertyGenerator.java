package so.ego.space.commons.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptedPropertyGenerator {
    public static void main(String[] args) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword("ego_workspace_password");
        standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");

        String cipherText = standardPBEStringEncryptor.encrypt("jdbc:mysql://3.34.163.67:3306/useSSL=false&characterEncoding=UTF-8&serverTimezone=Asia/Seoul&autoReconnection=true");
        String plainText = standardPBEStringEncryptor.decrypt("oluJPFocN/alJ52ifISkIoxKsAkCBbCQFo33YyzDGP0Z4cBJ3OYKm8WTOq4wKpjfffBWNaCARbRRJcsl7zd3o9/enGaRhz9AOC4woSJcMnPw8TaW1B4kGksrgYydyM20pK/IFRsVJ2LuyV/zfhTClZrU5mzoGc0YS/VnuquCEwjkthDk3olODYQKxVDeVBsWrszvHThdETotFYWQQzlmCg==");

        System.out.println("CipherText : " + cipherText);
        System.out.println("PlainText : " + plainText);
    }
}