package com.cugb.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class FileUploadTool {
	// ʵ���ļ��ϴ�����
	public static String FileUpload(String errorPage, Part part, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println(part.getSize());

		// �ж��Ƿ�ѡ�����ϴ���ͼƬ
		if (part.getSize() == 0) {
			request.setAttribute("msg", "��ѡ��һ��Ҫ�ϴ���ͼƬ��");
			request.getRequestDispatcher(errorPage).forward(request, response);
			return "";
		}

		// ��ȡҪ�ϴ���ͼƬ����
		String filename = part.getSubmittedFileName();
		// System.out.println(filename);
		// ͼƬ��ʽ��jpg jpeg png gif bmp
		// ȡ��׺
		String type = filename.substring(filename.lastIndexOf(".") + 1);
		// �ж��ļ���ʽ
		if (!"jpg".equals(type) && !"jpeg".equals(type) && !"png".equals(type) && !"gif".equals(type)
				&& !"bmp".equals(type)) {
			request.setAttribute("msg", "ͼƬ��ʽ����ȷ");
			request.getRequestDispatcher(errorPage).forward(request, response);
			return "";
		}

		// ��ͼƬ�Ӹ����ǰ׺
		String photo = UUID.randomUUID() + filename;
		// System.out.println(filename);

		// �����ϴ����ļ�·��
		String path = "E:\\TomcatServiceFakePath\\image";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}

		// �ϴ�����
		// fileName���ϴ���ͼƬ������·��F:/xmpic/face1.jpg
		part.write(path + "/" + photo);
		return photo;
	}

	// ʵ���ļ��ϴ�����
	public static String videoUpload(String errorPage, Part part, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// �ж��Ƿ�ѡ�����ϴ�����Ƶ
		if (part.getSize() == 0) {
			request.setAttribute("msg", "��ѡ��Ҫ�ϴ�����Ƶ��");
			request.getRequestDispatcher(errorPage).forward(request, response);
			return "";
		}

		// ��ȡҪ�ϴ�����Ƶ����
		String filename = part.getSubmittedFileName();
		// System.out.println(filename);
		// ��Ƶ��ʽ��mp4,avi,wmv,mkv,flv,rmvb
		// ȡ��׺
		String type = filename.substring(filename.lastIndexOf(".") + 1);
		// �ж��ļ���ʽ
		if (!"mp4".equals(type) && !"avi".equals(type) && !"wmv".equals(type) && !"mkv".equals(type)
				&& !"flv".equals(type) && !"rmvb".equals(type)) {
			request.setAttribute("msg", "��Ƶ��ʽ����ȷ");
			request.getRequestDispatcher(errorPage).forward(request, response);
			return "";
		}

		// ����Ƶ�Ӹ����ǰ׺
		String video = UUID.randomUUID() + filename;
		// System.out.println(filename);

		// �����ϴ����ļ�·��
		String path = "E:\\TomcatServiceFakePath\\videos";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}

		// �ϴ�����
		// fileName���ϴ�����Ƶ������·��F:/videos/1.avi
		part.write(path + "/" + video);
		return video;
	}
}
