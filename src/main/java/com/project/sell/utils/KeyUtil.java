package com.project.sell.utils;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @AuthotAdministrator
 * @Date 2019/7/28 1:06
 **/
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random=new Random();
        int number = random.nextInt(90000) + 10000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
