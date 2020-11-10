import java.io.*;
import java.util.*;

class addition
{
	int result,num;
	int add(String temp)
	{
		System.out.println("\n Checking Inputs....");
		if(!temp.isEmpty())
		{
			String str[] = temp.split("");
			int len = temp.length();
			int flag=0,num=0,neg=0;
			List<Integer> list=new ArrayList<Integer>();
			
			for(int i=0;i<len;i++)
			{
				
				if(str[i].equals("1") || str[i].equals("2") || str[i].equals("3") || str[i].equals("4") || str[i].equals("5") || str[i].equals("6") || str[i].equals("7") || str[i].equals("8") || str[i].equals("9") ||str[i].equals("0"))
				{
					flag=0;
					//System.out.println("Digit.");
					if(i==len-1)
					{
						if(flag==0 && neg==0)
						{
							//System.out.println("\n Last Location \n Adding..");
							int t = Integer.parseInt(str[i]);
							num = (num*10) + t;
							result+=num;
							if(num>1000)
								num=0;							
							//System.out.println("\n "+num+" Added Successfully.");
							//System.out.println("result : "+result);
							num=0;
						}
						else if(flag==0 && neg==1)
						{
							int t = Integer.parseInt(str[i]);
							num = (num*10) + t;
							System.out.println("\n Negative Not Allowed.\n -"+num+" is negative.\n");
							result = -1;
							return 0;
						}
					}
					else
					{					
						int t = Integer.parseInt(str[i]);
						num = (num*10) + t;
						//System.out.println("Number : "+num);
					}
				}
				else if(str[i].equals("-"))
				{
					if(i==len-1)
					{
						System.out.println("\n "+temp+" is Incorrect Input.");
						result=-1;
						return 0;
					}
					else if(i!=0 && flag==0)
					{
						System.out.println("\n "+temp+" is Incorrect Input.");
						result=-1;
						return 0;
					}
					else{
						flag=0;
						neg=1;						
					}
				}
				else if(!(str[i].equals("1") || str[i].equals("2") || str[i].equals("3") || str[i].equals("4") || str[i].equals("5") || str[i].equals("6") || str[i].equals("7") || str[i].equals("8") || str[i].equals("9") ||str[i].equals("0")))
				{
					//System.out.println("Special Charcter");
					flag=1;
					if(i==len-1)
					{
						
						result=-1;
						System.out.println("\n "+temp+" is Incorrect input.");
						return 0;
					}
					else if(flag==1 && neg==1)
					{
						
						System.out.println("\n Negative Not Allowed.\n -"+num+" is negative.\n");
						result = -1;
						return 0;
					}
					else if(flag==1 && neg==0)
					{
						
						//System.out.println("Adding..");
						if(num>1000)
							num=0;
						result+=num;
						//System.out.println("\n "+num+" Added Successfully.");
						//System.out.println("result : "+result);
						num=0;
					}
					else{
						
						if(str[i].equals("["))
						{
							while(!(str[i].equals("]")) && i<(len-1)){
								i++;
							}
						}
						else if((str[i].equals("("))){
							while(!(str[i].equals(")")) && i<(len-1)){
								i++;
								
							}
						}
						else if((str[i].equals("{")) ){
							while(!(str[i].equals(")")) && i<(len-1)){
								i++;
								
							}
						}
					}
				}
				
				//System.out.println("str["+i+"] : "+str[i]+"flag : "+flag +"\t neg : "+neg);
			}
			if(flag==1)
			{
				System.out.println("\n Negative Not Allowed.\n -"+num+" is negative.\n");
				result = -1;
				return 0;
			}
		}
		else
		{
			System.out.println("\n Error : Input is Empty.");
		}
		return result;
	}	
	
}

public class stringCalculatorDemo
{
	public static void main(String args[])
	{
		addition a1 = new addition();
		String temp;
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" String Calculator \n Enter String To Perform Calculation (for exa : 1 or 1,2 or 1,2,3 )");
		System.out.println("\n To Enter Empty String Enter Null.");
		System.out.print("\n Enter Input : ");
		temp = sc.next();
		temp=temp.toLowerCase();
		
		if(temp.equals("null"))
			temp="";
		System.out.println("\n String : " + temp);
		int ans =  a1.add(temp);
		
		if(ans!=-1 && ans!=0)
			System.out.println(" Sum : "+ans);
		else
			System.out.print("\n\n \tPlease Enter Proper Input.");
	}
}