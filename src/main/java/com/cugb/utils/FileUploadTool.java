package com.cugb.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class FileUploadTool {
	// 实现文件上传操作
	public static String FileUpload(String errorPage, Part part, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println(part.getSize());

		// 判断是否选择了上传的图片
		if (part.getSize() == 0) {
			request.setAttribute("msg", "请选择一张要上传的图片！");
			request.getRequestDispatcher(errorPage).forward(request, response);
			return "";
		}

		// 获取要上传的图片名称
		String filename = part.getSubmittedFileName();
		// System.out.println(filename);
		// 图片格式：jpg jpeg png gif bmp
		// 取后缀
		String type = filename.substring(filename.lastIndexOf(".") + 1);
		// 判断文件格式
		if (!"jpg".equals(type) && !"jpeg".equals(type) && !"png".equals(type) && !"gif".equals(type)
				&& !"bmp".equals(type)) {
			request.setAttribute("msg", "图片格式不正确");
			request.getRequestDispatcher(errorPage).forward(request, response);
			return "";
		}

		// 给图片加个随机前缀
		String photo = UUID.randomUUID() + filename;
		// System.out.println(filename);

		// 创建上传的文件路径
		String path = "E:\\TomcatServiceFakePath\\image";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}

		// 上传操作
		// fileName：上传的图片的完整路径F:/xmpic/face1.jpg
		part.write(path + "/" + photo);
		return photo;
	}

	// 实现文件上传操作
	public static String videoUpload(String errorPage, Part part, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 判断是否选择了上传的视频
		if (part.getSize() == 0) {
			request.setAttribute("msg", "请选择要上传的视频！");
			request.getRequestDispatcher(errorPage).forward(request, response);
			return "";
		}

		// 获取要上传的视频名称
		String filename = part.getSubmittedFileName();
		// System.out.println(filename);
		// 视频格式：mp4,avi,wmv,mkv,flv,rmvb
		// 取后缀
		String type = filename.substring(filename.lastIndexOf(".") + 1);
		// 判断文件格式
		if (!"mp4".equals(type) && !"avi".equals(type) && !"wmv".equals(type) && !"mkv".equals(type)
				&& !"flv".equals(type) && !"rmvb".equals(type)) {
			request.setAttribute("msg", "视频格式不正确");
			request.getRequestDispatcher(errorPage).forward(request, response);
			return "";
		}

		// 给视频加个随机前缀
		String video = UUID.randomUUID() + filename;
		// System.out.println(filename);

		// 创建上传的文件路径
		String path = "E:\\TomcatServiceFakePath\\videos";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}

		// 上传操作
		// fileName：上传的视频的完整路径F:/videos/1.avi
		part.write(path + "/" + video);
		return video;
	}
}
