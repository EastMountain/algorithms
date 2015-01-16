package com.md.file;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File demo = new File("demo");
		if(!demo.exists()){
			demo.mkdir();
		}
		File file = new File(demo,"raf.dat");
		if(!file.exists()){
			file.createNewFile();
		}
		
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		System.out.println(raf.getFilePointer());
		
		raf.write('a');
		System.out.println(raf.getFilePointer());
		raf.write('b');
		int i=0x7fffffff;
		raf.writeInt(i);
		raf.write(i >>> 24);
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i >>> 0);
		System.out.println(raf.getFilePointer());
		raf.seek(0);
		System.out.println(raf.getFilePointer());
		
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		System.out.println(new String(buf));
	}

}
