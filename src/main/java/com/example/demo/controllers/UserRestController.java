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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
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
public class UserRestController implements ServletContextAware{

	@Autowired
	private MotelService motelService;
	public String UploadImg="uploads";
	//private BannerService bannerService;
	private ServletContext servletContext;
	
	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Motel1>> findAll() {
		try {
			return new ResponseEntity<List<Motel1>>(motelService.findAllMotel(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Motel1>>(HttpStatus.BAD_REQUEST);
		}
	}@RequestMapping(value = "findbyusername/{username}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Motel1>> findAllMotelByUsername(@PathVariable ("username") String username) {
		try {
			return new ResponseEntity<List<Motel1>>(motelService.findModelByUsername(username),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Motel1>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value ="create",method = RequestMethod.POST,
			produces = MimeTypeUtils.ALL_VALUE,
			consumes = MimeTypeUtils.ALL_VALUE)
	
	public ResponseEntity<Motel> create(@RequestBody Motel motel/*,@RequestParam("file") MultipartFile file*/){
		try {
		//	String fileName=saveFile(file);
		//	System.out.println("af: "+fileName);
			Account account=new Account();
			account.setId(1);
			
			
			
			//motel.setImage1(fileName);
			
			
		//	motel.setName("aaaa");
		//	motel.setAddress("bbbb");
		//	motel.setDescribe("sfa");
		//	motel.setEmail("asgasg");
		//	motel.setImage2("aga");
		//	motel.setImage3("asgg");
		//	motel.setImage4("asg");
		//	motel.setPhoneNumber("4734");
		//	motel.setPrice(2363);
			motel.setStatus(true);
			
			
			motel.setAccount(account);
			motel=motelService.save(motel);
			return new ResponseEntity<Motel>(motel,HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<Motel>(HttpStatus.BAD_REQUEST);
		
		}
	}
	
	private String saveFile(MultipartFile file) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
			String fileName = simpleDateFormat.format(new Date()) + file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			Path path = Paths.get(servletContext.getRealPath ("/uploads/" + fileName));
			Files.write(path, bytes);
			return fileName;
		} catch (Exception e) {
			return null;
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
	            ImageIO.write(img, "jpeg", bos);
	            return bos.toByteArray();
	        } catch (FileNotFoundException e) {
	            return null; //todo: return safe photo instead
	        } catch (IOException e) {
	            return null;  //todo: return safe photo instead
	        }
	    }
	 
	 
	 @RequestMapping(value= "find/{id}",method = RequestMethod.GET,produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
		
		public ResponseEntity<Motel1> find(@PathVariable("id") int id){
			try {
				
				return new ResponseEntity<Motel1>(motelService.find(id),HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<Motel1>(HttpStatus.BAD_REQUEST);
			}
		}
	 @RequestMapping(value = "search/{address}", method = RequestMethod.GET, 
				produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<Motel1>> findInvoiceByStatus(@PathVariable("address") String address) {
				try {
					return new ResponseEntity<List<Motel1>>(motelService.search(address) , HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<List<Motel1>>(HttpStatus.BAD_REQUEST);
				}
			}
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
	
	
	
	/*@RequestMapping(value = "upload", method = RequestMethod.POST,produces = MimeTypeUtils.ALL_VALUE,
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
	}*/
	
	
	
	
}
