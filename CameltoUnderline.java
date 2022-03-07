import java.util.*;

public class CameltoUnderline{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        
		StringBuilder builder = new StringBuilder();
        
        int r = 0; int l = 0;        //双指针法
        for(; r < line.length(); r++){        //单次遍历
			if(Character.isUpperCase(line.charAt(r))){
                if(!Character.isUpperCase(line.charAt(r + 1))){        //若不为连续大写，判断大写字母是否为首字母
                    if(r == 0){
                        builder.append(Character.toLowerCase(line.charAt(r)));
                    }
                    else{
                    builder.append('_');
                    builder.append(Character.toLowerCase(line.charAt(r)));
                        }
                }
                else{                                                  //若为连续大写，则继续往下判别大写区间
                    l = r + 1;    //左指针指向下一个连续字符
                    while(l < line.length() && Character.isUpperCase(line.charAt(l))){
                        l++;
                        }
                                                                      //确认区间后，判断此区间处于头部、尾部或中间，对应处理方式
                        if(r == 0 && l == line.length()){
                        builder.append(line.substring(r,l).toLowerCase());
                        r = l;
                        }
                        else if(r == 0 && l != line.length()){
                            builder.append(line.substring(r,l - 1).toLowerCase()+ '_');
                        r = l - 2;
                        }
                        else if(r != 0 && l == line.length()){
                        builder.append('_');
                        builder.append(line.substring(r,l).toLowerCase());
                        r = l;
                        }
                        else{
                        builder.append('_');
                        builder.append(line.substring(r,l - 1).toLowerCase() + '_');
                        r = l - 2;
                        }
                }
            }
            else {    //未检测到大写字母
                builder.append(line.charAt(r));
            }
        }
		System.out.println(builder);
	}
}