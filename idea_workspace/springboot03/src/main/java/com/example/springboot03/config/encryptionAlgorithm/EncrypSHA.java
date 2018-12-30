package com.example.springboot03.config.encryptionAlgorithm;

/**
 * @ ClassName EncrypSHA
 * @ Description TODO
 * @ Author hzd
 * @ Date 2018/12/10 18:35
 * @ Version 1.0
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncrypSHA {

    public byte[] eccrypt(String info) throws NoSuchAlgorithmException{
        MessageDigest md5 = MessageDigest.getInstance("SHA");
        byte[] srcBytes = info.getBytes();
        //使用srcBytes更新摘要
        md5.update(srcBytes);
        //完成哈希计算，得到result
        byte[] resultBytes = md5.digest();
        return resultBytes;
    }

    /**
     * @param args
     * @throws NoSuchAlgorithmException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String msg = "郭XX-精品相声技术";
        EncrypSHA sha = new EncrypSHA();
        byte[] resultBytes = sha.eccrypt(msg);
        System.out.println("明文是：" + msg);
        System.out.println("密文是：" + new String(resultBytes));

    }

}
