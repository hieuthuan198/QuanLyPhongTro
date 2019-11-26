package com.example.demo.controllers;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;s
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Account;
import com.example.demo.entities.Motel;
import com.example.demo.entities.Motel1;
//import com.example.demo.entities.Motel;
//import com.example.demo.entities.Motel1;

import com.example.demo.services.MotelService;
//import com.example.demo.services.MotelService;




@RestController
@RequestMapping("api/motel")
public class UserRestController {

	@Autowired
	private MotelService motelService;
	public String UploadImg="uploads";
	//private BannerService bannerService;

	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Motel1>> findAll() {
		try {
			return new ResponseEntity<List<Motel1>>(motelService.findAllMotel(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Motel1>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value ="create",method = RequestMethod.POST,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Motel> create(@RequestBody Motel motel){
		try {
			Account account=new Account();
			account.setId(1);
			motel.setAccount(account);
			motel=motelService.save(motel);
			return new ResponseEntity<Motel>(motel,HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<Motel>(HttpStatus.BAD_REQUEST);
		
		}
	}
	
	 @RequestMapping (value = "get/{name}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	    @ResponseBody
	    public byte[] getImageByName(HttpServletRequest request, @PathVariable ("name") String name) {
	 
	        //curl -v http://localhost:8080/mydomain/image/get/xxx &gt; /dev/null
	        String realPath =
	                request.getSession().getServletContext().getRealPath("/uploads/" + name);
	 
	        try {
	            InputStream is = new FileInputStream(realPath);
	            BufferedImage img = ImageIO.read(is);
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	            ImageIO.write(img, "png", bos);
	            ImageIO.write(img, "jpg", bos);
	            ImageIO.write(img, "gif", bos);
	            return bos.toByteArray();
	        } catch (FileNotFoundException e) {
	            return null; //todo: return safe photo instead
	        } catch (IOException e) {
	            return null;  //todo: return safe photo instead
	        }
	    }
	
	
	
	@RequestMapping(value = "upload", method = RequestMethod.POST,produces = MimeTypeUtils.ALL_VALUE,
			consumes = MimeTypeUtils.ALL_VALUE)
	public String upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		
			String fileName = simpleDateFormat.format(new Date()) + file.getOriginalFilename();
			String path=request.getServletContext().getRealPath("")+UploadImg+File.separator+fileName;
			
		saveFile(file.getInputStream(), path);
		
		return fileName;
		
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	private void saveFile(InputStream inputStream,String path) {
		// TODO Auto-generated method stub
			try {
				OutputStream outputStream=new FileOutputStream(new File(path));
				int read=0;
				byte []bytes=new byte[1024];
				
				while((read=inputStream.read(bytes))!=-1) {
					outputStream.write(bytes,0, read);
				}
				outputStream.flush();
				outputStream.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	
}
