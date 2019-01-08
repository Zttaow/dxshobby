package club.ztt.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 赵涛涛
 * @date 2017/9/4.
 */
public class FileUtil {

    /**
     * 单文件上传
     *
     * @param multipartFile
     * @param storePath     文件存储的绝对路径
     * @return 上传到服务器的相对路径
     */
    public static String fileUpload(MultipartFile multipartFile, String storePath) {
        System.out.println(multipartFile);
        System.out.println(multipartFile.isEmpty());

        if (!multipartFile.isEmpty()) {
//            long size = multipartFile.getSize();
//            System.out.println("文件大小:" + size / 1024.0 + "KB");
//
//            String type = multipartFile.getContentType();
//            System.out.println("文件类型：" + type);
//
            //文件后缀
            String suffix = multipartFile.getOriginalFilename().substring
                    (multipartFile.getOriginalFilename().indexOf("."));
            System.out.println("文件后缀：" + suffix);
             //生成文件名
            String fileName = UUID.randomUUID().toString() + suffix;
            System.out.println("生成的唯一文件名:" + fileName);

            //上传路径（图片的完全地址）
            File filepath = new File(storePath, fileName);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
                multipartFile.transferTo(new File(storePath + File.separator + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            return filepath.toString();
        }

        return "文件空";
    }


    /**
     * 多文件上传
     * @param multipartFiles
     * @param storePath
     * @return 返回上传成功文件的数量
     */
    public static int filesUpload(MultipartFile[] multipartFiles, String storePath) {
        File f = new File(storePath);
        //如果当前目录不存在，则创建这个目录
        if (!f.exists()) {
            f.mkdirs();
        }

        //前端一个文件选择框（即使没有真实选择文件）对应files里的一个对象，
//        System.out.println(files);

        int fileNumber = multipartFiles.length;
        if (fileNumber == 0) {
            return 0;
        }

        //记录一次成功上传文件的数量
        int successAccount = 0;
        for (int i = 0; i < fileNumber; i++) {

            //文件是否存在.注意的是，不管前端有没有选择文件，files[i]都不为空，所以不能用files[i]==null判断文件是否存在
            boolean fileExisted = !multipartFiles[i].isEmpty();
            System.out.println(fileExisted);
            if (!fileExisted) {
                continue;
            }

            // 获得原始文件名
            String fileName = multipartFiles[i].getOriginalFilename();
            System.out.println("原始文件名:" + fileName);
            // 新文件名
            String newFileName = UUID.randomUUID() + fileName;
            try {
                multipartFiles[i].transferTo(new File(storePath + File.separator + newFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            successAccount++;
            System.out.println(successAccount);
            System.out.println("上传文件" + successAccount + "到： " + storePath + newFileName);
        }
        System.out.println("总共上传" + fileNumber + "个文件，" + "上传成功" + successAccount + "个！");
        return successAccount;
    }


}
