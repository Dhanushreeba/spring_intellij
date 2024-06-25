package com.xworkz.image.Controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@RequestMapping("/")
public class ImageUploadController {

    public ImageUploadController()
    {
        System.out.println("Created ImageUploadController");
    }

    @PostMapping("upload")
    public String uploadImage(@RequestParam MultipartFile file) throws IOException {
        System.out.println("Image upload");
        System.out.println("file getName"+file.getName());
        System.out.println("file getSize"+file.getSize());
        System.out.println("file getContentType"+file.getContentType());
        System.out.println("file getResource"+file.getResource());
        System.out.println("file getBytes"+file.getBytes());
        System.out.println("file getOriginalFilename"+file.getOriginalFilename());



        byte[] bytes=file.getBytes();
        Path path= Paths.get("C:\\Users\\VARSHITHA\\Desktop\\ImageUpload",file.getOriginalFilename());
        Files.write(path,bytes);

        System.out.println("fileName:"+file.getOriginalFilename()+"ContentType:"+file.getContentType());
        return "index";

    }


    @GetMapping("download")
    public String download(HttpServletResponse  response, @RequestParam String fileName)
    {
        System.out.println("Running download method...");
        response.setContentType("image/jpeg");
        File file=new File("C:\\Users\\VARSHITHA\\Desktop\\ImageUpload",fileName);
        try {
            InputStream buffer=new BufferedInputStream(new FileInputStream(file));
            ServletOutputStream outputStream =response.getOutputStream();
            IOUtils.copy(buffer,outputStream);
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();

            //throw new RuntimeException(e);
        }
        return "index";

    }

}
