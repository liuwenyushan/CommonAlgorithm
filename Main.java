package test2;

import java.util.LinkedList;



public class Main {
	
	int test;
    public static void main(String[] args) {

    	int[] A={ -2, 11, -4, 13, -5, -2 ,188};
    	System.out.print(MaxSubSequence(A));

    }

public static int BinarySearch(int[] ii,int k){//二分查找
   
    	int low=0,high=ii.length-1,mid;
    	while(low <=high){
    		mid=(low+high)/2;
    		if(ii[mid]==k)return mid+1;
    		if(ii[mid]<k)low=mid+1;
    		else high=mid-1;
    	}
    	return 0;
    	
    }
    public static void InsertSort(int[] input){//插入排序

    	int temp;
    	for(int i=1;i<input.length;i++){
    		temp=input[i];
    		int j=i-1;
    		while(j>=0 && temp<input[j]){
    			input[j+1]=input[j];
    			j--;
    		}
    		input[j+1]=temp;
    	}
    }
    public static void BubbleSort(int[] input){//冒泡排序
    	int n=input.length;
    	int temp;
    	for(int i=0;i<n-1;i++){
    		for(int j=0;j<n-i-1;j++){
    			if(input[j]>input[j+1]){
    				temp=input[j];
    				input[j]=input[j+1];
    				input[j+1]=temp;
    			}
    		}
    	}
    	
    }
    public static void QuickSort(int[] input,int s,int t){//快速排序
    	int i=s,j=t;
    	int temp;
    	if(s<j){
    		temp=input[s];
    		while(i!=j){
    			while(j>i && input[j]>=temp)j--;
    			input[i]=input[j];
    			while(j>i && input[i]<=temp)i++;
    			input[j]=input[i];
    		}
    		input[i]=temp;
    		QuickSort(input, s, i-1);
    		QuickSort(input, i+1, t);
    	}
    	
    	
    }
    public static void SelectSort(int[] input){//选择排序
    	int temp,k;
    	for(int i=0;i<input.length-1;i++){
    		k=i;
    		for(int j=i+1;j<input.length;j++){
    			if(input[j]<input[k])
    				k=j;
    		}
    		if(k!=i){
    			temp=input[i];
    			input[i]=input[k];
    			input[k]=temp;
    		}
    	}
    }
    public static Node reverseList(Node head){//链表反转（递归形式）
    	if(head==null||head.next==null)return head;
    	
    	Node pre=reverseList(head.next);
    	head.next.next=head;
    	head.next=null;
    	
    	return pre;
    }
    public static Node reverseList2(Node head){//链表反转（非递归形式）
    	Node prev=null;
    	while(head!=null){
    		Node temp=head.next;
    		head.next=prev;
    		prev=head;
    		head=temp;
    	}
    	return prev;
    }

	public static int  getLCS(String A,String B){//求最长公共子序列
		int m=A.length();
		int n=B.length();
		
		int[][]L=new int[m+1][n+1];
		for(int i=0;i<=m;i++)L[i][0]=0;
		for(int i=0;i<=n;i++)L[0][i]=0;
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(A.charAt(i-1)==B.charAt(j-1)){
					L[i][j]=L[i-1][j-1]+1;
//					sb.append(A.charAt(i-1));
					}
				else L[i][j]=Math.max(L[i][j-1], L[i-1][j]);
			}
			
		}
		System.out.println(sb.toString());
		return L[m][n];
}
	/*public static int getMaxValue(){//背包问题
		
	}*/
public static int MaxSubSequence(int A[]){//最大子序列（动态规划方法）
	int[] sum=new int[A.length];
	sum[0]=A[0];
	int MaxSum=sum[0];
	for(int i=1;i<A.length;i++){	
		sum[i]=Math.max(sum[i-1]+A[i], A[i]);
		if(sum[i]>MaxSum)MaxSum=sum[i];
		}
	
	return MaxSum;
}
	
}

class Node{
	int value;
	Node next;
	
	public Node(int v){
		this.value=v;
	}
	}