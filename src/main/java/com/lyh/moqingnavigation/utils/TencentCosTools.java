package com.lyh.moqingnavigation.utils;

import com.lyh.moqingnavigation.exception.BusinessException;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.COSObjectInputStream;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.utils.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 上传文件到腾讯cos的工具类
 *
 * @author :liangyuhang1
 * @className :TencentCosTools
 * @date :2023/10/20/17:28
 */

public class TencentCosTools {

    /**
     * 获取Cos客户端
     *
     * @return
     */
    public static COSClient getCOSClient() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        // SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String appId = "appId";
        String secretId = "secretId";//用户的 SecretId，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretKey = "secretKey";//用户的 SecretKey，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        COSCredentials cred = new BasicCOSCredentials(appId, secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        //clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }


    /**
     * 上传头像到Cos
     *
     * @param avatar
     * @throws IOException
     */
    public static void uploadAvatar(MultipartFile avatar, String userId) throws IOException {
        // 获取文件输入流
        InputStream inputStream = avatar.getInputStream();
        COSClient cosClient = getCOSClient();
        System.out.println(" getName: " + avatar.getName());
        String filename = avatar.getOriginalFilename();
        System.out.println(" getOriginalFilename: " + filename);

        // 指定文件将要存放的存储桶
        String bucketName = "easypan-1318187204";
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "easypan/avatar/" + userId + ".jpg";
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(avatar.getSize());
        try {
            // 上传文件
            cosClient.putObject(bucketName, key, inputStream, objectMetadata);
            System.out.println("头像上传成功！");
        } catch (Exception e) {
            e.printStackTrace();
            new BusinessException("上传头像失败----");
        } finally {
            cosClient.shutdown();
            inputStream.close();
        }
    }


    /**
     * 获取用户头像
     *
     * @param userId
     */
    public static void getUserAvatar(HttpServletResponse response, String userId) throws IOException {
        COSClient cosClient = getCOSClient();

        // 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
        String bucketName = "easypan-1318187204";
        // 对象键(Key)是对象在存储桶中的唯一标识。详情请参见 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = "easypan/avatar/" + userId + ".jpg";

        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        COSObjectInputStream cosObjectInput = null;

        // 判断COS是否有用户头像，若没有则返回默认头像
        boolean objectExists = cosClient.doesObjectExist(bucketName, key);
        if (!objectExists) {
            key = "easypan/avatar/" + "default_avatar.jpg";
        }

        getObjectRequest.setKey(key);

        try {
            COSObject cosObject = cosClient.getObject(getObjectRequest);
            cosObjectInput = cosObject.getObjectContent();
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

        // 获取字节流
        byte[] bytes = null;
        try {
            bytes = IOUtils.toByteArray(cosObjectInput);
            // 将byte[]写入响应体
            response.getOutputStream().write(bytes);
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 用完流之后一定要调用 close()
            cosObjectInput.close();
            cosClient.shutdown();
        }
    }

    // 以下为测试代码
    public static void testUpload(MultipartFile file) throws IOException {
        COSClient cosClient = getCOSClient();

        // 获取文件输入流
        InputStream inputStream = file.getInputStream();

        // 指定文件将要存放的存储桶
        String bucketName = "test-1318187204";
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "picture/" + "test.jpg";
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        try {
            // 上传文件
            cosClient.putObject(bucketName, key, inputStream, objectMetadata);
            System.out.println("头像上传成功！");
        } catch (Exception e) {
            e.printStackTrace();
            new BusinessException("上传头像失败----");
        } finally {
            cosClient.shutdown();
            inputStream.close();
        }

    }

    public static void testGet(HttpServletResponse response) throws IOException {
        COSClient cosClient = getCOSClient();

        // 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
        String bucketName = "test-1318187204";
        // 对象键(Key)是对象在存储桶中的唯一标识。详情请参见 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = "picture/test.jpg";

        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        COSObjectInputStream cosObjectInput = null;

        // 判断COS是否有用户头像，若没有则返回默认头像
        boolean objectExists = cosClient.doesObjectExist(bucketName, key);

        try {
            COSObject cosObject = cosClient.getObject(getObjectRequest);
            cosObjectInput = cosObject.getObjectContent();
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

        // 获取字节流
        byte[] bytes = null;
        try {
            bytes = IOUtils.toByteArray(cosObjectInput);
            // 将byte[]写入响应体
            response.getOutputStream().write(bytes);
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 用完流之后一定要调用 close()
            cosObjectInput.close();
            cosClient.shutdown();
        }
    }
}
