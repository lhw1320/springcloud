package com.qdfae.jdk.token;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class GUIDGenerator extends Object {
	
	public String valueBeforeMD5 = "";

    public String valueAfterMD5 = "";

    private static Random myRand;

    private static SecureRandom mySecureRand;
    
    static {
        mySecureRand = new SecureRandom();
        long secureInitializer = mySecureRand.nextLong();
        myRand = new Random(secureInitializer);
    }
    
    public GUIDGenerator() {
        getRandomGUID(false);
    }
    
    public GUIDGenerator(boolean secure) {
        getRandomGUID(secure);
    }
    
    private void getRandomGUID(boolean secure) {
        MessageDigest md5 = null;
        StringBuffer sbValueBeforeMD5 = new StringBuffer();

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {
            InetAddress id = InetAddress.getLocalHost();
            long time = System.currentTimeMillis();
            long rand = 0;

            if (secure) {
                rand = mySecureRand.nextLong();
            } else {
                rand = myRand.nextLong();
            }

            // This StringBuffer can be a long as you need; the MD5
            // hash will always return 128 bits. You can change
            // the seed to include anything you want here.
            // You could even stream a file through the MD5 making
            // the odds of guessing it at least as great as that
            // of guessing the contents of the file!
            sbValueBeforeMD5.append(id.toString());
            sbValueBeforeMD5.append(":");
            sbValueBeforeMD5.append(Long.toString(time));
            sbValueBeforeMD5.append(":");
            sbValueBeforeMD5.append(Long.toString(rand));

            valueBeforeMD5 = sbValueBeforeMD5.toString();
            md5.update(valueBeforeMD5.getBytes());

            byte[] array = md5.digest();
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < array.length; j++) {
                int b = array[j] & 0xFF;
                if (b < 0x10)
                    sb.append('0');
                sb.append(Integer.toHexString(b));
            }

            valueAfterMD5 = sb.toString();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    
    public String toString() {
        String raw = valueAfterMD5.toUpperCase();
        StringBuffer sb = new StringBuffer();
        sb.append(raw.substring(0, 8));
        //sb.append("-");
        sb.append(raw.substring(8, 12));
        //sb.append("-");
        sb.append(raw.substring(12, 16));
        //sb.append("-");
        sb.append(raw.substring(16, 20));
        //sb.append("-");
        sb.append(raw.substring(20));

        return sb.toString();
    }

    public static String getGUID() {
        GUIDGenerator myGUID = new GUIDGenerator();
        return myGUID.toString();
    }

    /*
      * Demonstraton and self test of class
      */
    public static void main(String args[]) {

        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println(">"+addr.getHostAddress());
            Random myRand = new Random(6);
            System.out.println(System.currentTimeMillis()+":myRand.nextLong() = " + myRand.nextInt());
//        GUIDGenerator myGUID = new GUIDGenerator();
//        Date start = new Date();
//        System.out.println("RandomGUID=" + GUIDGenerator.getGUID());
//        System.out.println("RandomGUID=" + myGUID.toString());
//        System.out.println("UUID=" + UUID.randomUUID().toString());
//        Date end = new Date();
//        System.out.println("Time:" + (end.getTime() - start.getTime()) + "ms.");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
