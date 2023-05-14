package com.big.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.big.Service.IUploadService;
import com.big.entity.Upload;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/")
public class UploadController {
	@Autowired
	private IUploadService ius;
	
	@RequestMapping(value="/")
	public String init() {
		return "upload";
	}
	
	@RequestMapping(value="/up/go",method=RequestMethod.POST)
	public String getupload(Upload up,@RequestParam MultipartFile imgs,HttpServletRequest request) {//Upload up,@RequestParam MultipartFile img
		  String realPath = request.getSession().getServletContext().getRealPath("/upload");
		  String filename = imgs.getOriginalFilename();
		  String extension = FilenameUtils.getExtension(filename);//拿到文件的后缀
		  String uuid = UUID.randomUUID().toString();
		  String name=uuid+"."+extension;
		  File file2 =new File(realPath);	
		  if (!file2.exists()) {
			  file2.mkdirs();
	        }
		  File file =new File(realPath+"/"+name);
		  try {
			 InputStream in = imgs.getInputStream();
			 OutputStream out=new FileOutputStream(file);
			 FileCopyUtils.copy(in, out);
			 up.setImg("upload/"+name);
			 ius.insertbyUpload(up);
			  System.out.println("tt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/pagelist";
	}
	@RequestMapping(value="pagelist",method=RequestMethod.GET)
	public String getlist(@RequestParam(value="pn",defaultValue = "1") Integer pn,Model m) {
		PageHelper.startPage(pn, 3);
		List<Upload> list = ius.selectAll();
		PageInfo<Upload> pageinfo =new PageInfo<Upload>(list);
		m.addAttribute("pageinfo", pageinfo);
		return "list";
	}
}
