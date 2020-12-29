package com.yao.common.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.lang.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @author : 妖妖
 * @date : 17:18 2020/9/10
 */
public class AESUtil {
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param secureKey 加密密钥
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String secureKey) throws Exception {
        if ((StringUtils.isEmpty(content)) ||
                (StringUtils.isEmpty(secureKey))) {
            return null;
        }
        KeyGenerator kgen = KeyGenerator.getInstance("AES");

        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(secureKey.getBytes());
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        byte[] byteContent = content.getBytes("utf-8");
        cipher.init(1, key);
        byte[] result = cipher.doFinal(byteContent);
        return encodeBASE64(result);
    }

    /**
     * AES 解密操作
     *
     * @param content 待加密的报文
     * @param secureKey 解密的密匙
     * @return
     */
    public static String decrypt(String content, String secureKey) throws Exception {
        if ((StringUtils.isEmpty(content)) || (StringUtils.isEmpty(secureKey))) {
            return null;
        }
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(secureKey.getBytes());
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, key);
        byte[] base64Dec = Base64.decode(content);
        byte[] result = cipher.doFinal(base64Dec);
        return new String(result);
    }
    public static String encodeBASE64(byte[] content) throws Exception {
        return Base64.encode(content);
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
//    private static SecretKeySpec getSecretKey(final String key) throws Exception {
//        //返回生成指定算法密钥生成器的 KeyGenerator 对象
//        KeyGenerator kg = null;
//        kg = KeyGenerator.getInstance(KEY_ALGORITHM);
//        //AES 要求密钥长度为 128
//        kg.init(128, new SecureRandom(key.getBytes()));
//        //生成一个密钥
//        SecretKey secretKey = kg.generateKey();
//        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
//    }



}
