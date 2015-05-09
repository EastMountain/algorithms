package com.md.string;

public class StringFilter {

	public StringFilter(){
		
	}
	
	/**
	 *  删除字符串中的b和ac，需要满足两个条件：
	 *  1. 字符串只能遍历一遍
	 *  2. 不能使用额外的空间
	 *  例如：
	  * acbac==>""
	  * aaac ==>aa
	  * ababac ==>aa
	  * bbbbd ==> d
	  * 
	  * 确定：
	  * abbbcd ==> acd:d?
	 */
	public void filter(char ch[]){
		if(ch == null){
			return;
		}
		
		int status =1;
		int j=0;
		for(int i=0;ch[i]!='\0';i++){
			if(status==1&&ch[i]!='a'&&ch[i]!='b'){
				ch[j]=ch[i];
				j++;
			}
			
			if(status==2&&ch[i]!='c'){
				ch[j]='a';
				j++;
				if(ch[i]!='a'&&ch[i]!='b'){
					ch[j]=ch[i];
					j++;
				}
			}
			
			//
			if(j>1&&ch[j-2]=='a'&&ch[j-1]=='c'){
				j=j-2;
			}
			status = ch[i]=='a'?2:1;
		}
		
		if(status==2){
			ch[j]='a';
			j++;
		}
		ch[j]='\0';
	}
}
