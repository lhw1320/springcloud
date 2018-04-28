package com.qdfae.spring.multipart;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Spring MVC提供的文件上传MultipartFile接口
 *
 * @author hongwei.lian
 * @date 2018年4月27日 下午8:04:14
 */
public interface MultipartFile {

    /**
     * 获取文件上传的name，例如<input type = "file" name = "fileKey">中的fileKey
     *
     * @return
     * @author hongwei.lian
     * @date 2018年4月27日 下午8:04:40
     */
    String getName();


   /**
    * 获取文件名称
    *
    * @return
    * @author hongwei.lian
    * @date 2018年4月27日 下午8:04:49
    */
    String getOriginalFilename();


    /**
     * 获取文件媒体类型
     *
     * @return
     * @author hongwei.lian
     * @date 2018年4月27日 下午8:04:57
     */
    String getContentType();


    /**
     * 是否为空文件
     *
     * @return
     * @author hongwei.lian
     * @date 2018年4月27日 下午8:05:04
     */
    boolean isEmpty();


    /**
     * 获取文件大小
     *
     * @return
     * @author hongwei.lian
     * @date 2018年4月27日 下午8:05:10
     */
    long getSize();

   /**
    * 获取文件字节数组，可以通过spring文件工具类保存文件
    * FileCopyUtils.copy(byte[] in, File out);
    *
    * @return
    * @throws IOException
    * @author hongwei.lian
    * @date 2018年4月27日 下午8:05:21
    */
    byte[] getBytes() throws IOException;

    /**
     * 获取文件输入流
     *
     * @return
     * @throws IOException
     * @author hongwei.lian
     * @date 2018年4月27日 下午8:05:40
     */
    InputStream getInputStream() throws IOException;

    /**
     * 将MultipartFile转换为FIle
     * 直接保存文件到硬盘中
     *
     * @param dest
     * @throws IOException
     * @throws IllegalStateException
     * @author hongwei.lian
     * @date 2018年4月27日 下午8:05:46
     */
    void transferTo(File dest) throws IOException, IllegalStateException;

}
