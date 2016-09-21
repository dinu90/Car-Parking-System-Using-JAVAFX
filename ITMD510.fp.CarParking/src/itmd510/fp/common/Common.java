package itmd510.fp.common;
/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: Common
 * Source File Name	: Common.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * Common Methods 
 * 
 */
public class Common {
	/**
	 * Used to check whether input is null or empty
	 * @param str string input
	 * @return true if satisfied
	 */
	public static boolean IsNullOrEmpty(String str){
		return (str==null || str.trim().isEmpty()) ? true : false;
	}
}
