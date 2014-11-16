package lhe.file;


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
	}
}
