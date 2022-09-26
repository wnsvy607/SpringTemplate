package com.app;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

public class JasyptTest {

    private String tokenSecret = "and0LXRva2VuLXNlY3JldA==";

    @Test
    void jasyptTest() {
        String password = "";   //password
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(4);
        encryptor.setPassword(password);
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");   //암호화 알고리즘
        String content = "";        //암호화 할 내용
        String encryptedContent = encryptor.encrypt(content); //암호화
        String decryptedContent = encryptor.decrypt(content); //복호화
        System.out.println("Enc : " + encryptedContent + ", DEC: " + decryptedContent);
    }

    @Test
    void jasyptDEC() throws Exception {
        //given
        String password = "";   // 비밀번호
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(4);
        encryptor.setPassword(password);
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
        String content = "";         //복호화 할 내용
        String decryptedContent = encryptor.decrypt(content); //복호화
        System.out.println("DEC: " + decryptedContent);


    }


    @Test
    void getTokenClaimTest() throws Exception {
        String token = "";
        //given
        Claims claims;
        claims = Jwts.parser().setSigningKey(tokenSecret.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token).getBody();
        //when
        System.out.println("claims = " + claims);
        //then
    }

}
