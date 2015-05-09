package com.md.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Demo {

	public static void main(String[] args) throws Exception{
		String s = "北京BJ12";
		//默认是utf-8，中文三个字节，字母数字1个字节
		byte[] bytes1 = s.getBytes("utf-8");
		for(byte b: bytes1){
			//把字节（转换成了int）以16进制的方式显示
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		
		System.out.println();
		
		//gbk中文两个字节，字母数字1个字节
		byte[] bytes2 = s.getBytes("gbk");
		for(byte b: bytes2){
			//把字节（转换成了int）以16进制的方式显示
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		
		System.out.println();
		
		//java是双字节编码 utf-16be,都占两个字节
		byte[] bytes3 = s.getBytes("utf-16be");
		for(byte b:bytes3){
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		
		/*
		 * 文本文件就是字节序列
		 * 可以使任意编码的字节序列
		 * 如果是在中文机器上直接创建文本文件，那么该文件就只认识ansi编码
		 */
		System.out.println();
		long start = System.currentTimeMillis();
		String srcFile = "C:\\Users\\Public\\Videos\\Sample Videos\\wild.wmv";
		String targetFile = "C:\\Users\\Public\\Videos\\Sample Videos\\wild3.wmv";
//		copyFileByBuffer(srcFile,targetFile);
		copyFileByBufferByteArray(srcFile,targetFile);
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
		
	}
	
	
	public static void copyFileByBuffer(String srcFile , String targetFile) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
		int c;
		while ((c=bis.read()) != -1){
			bos.write(c);
		}
		bos.flush();
		bis.close();
		bos.close();
	}
	
	public static void copyFileByBufferByteArray(String srcFile , String targetFile) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile),65536);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile),65536);
		byte[] b = new byte[8192];
		while (bis.read(b) != -1){
			bos.write(b);
		}
		bos.flush();
		bis.close();
		bos.close();
	}
}
