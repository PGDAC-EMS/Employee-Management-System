package com.app.utils;

import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class DiskStorageServiceImpl implements StorageService {
   @Value("${disk.upload.basepath}")
   private String BASEPATH;

   public DiskStorageServiceImpl() {
   }

   public List<String> loadAll() {
      File dirPath = new File(this.BASEPATH);
      return List.of(dirPath.list());
   }

   public String store(MultipartFile file) {
      String fileName = UUID.randomUUID().toString().replaceAll("-", "");
      File filePath = new File(this.BASEPATH, fileName);

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            FileOutputStream out = new FileOutputStream(filePath);

            String var10000;
            try {
               FileCopyUtils.copy(file.getInputStream(), out);
               var10000 = fileName;
            } finally {
               if (out != null) {
                  out.close();
               }

            }

            return var10000;
         } catch (Throwable var14) {
            if (var4 == null) {
               var4 = var14;
            } //else if (var4 != var14) {
               //var4.addSuppressed(var14);
            //}
            //throw var4 ;
         }
      } catch (Exception var15) {
         var15.printStackTrace();
         
      }
      return null;
   }

   public Resource load(String fileName) {
      File filePath = new File(this.BASEPATH, fileName);
      return filePath.exists() ? new FileSystemResource(filePath) : null;
   }

   public void delete(String fileName) {
      File filePath = new File(this.BASEPATH, fileName);
      if (filePath.exists()) {
         filePath.delete();
      }

	   }

}
