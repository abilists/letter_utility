package io.utility.letter;

import java.util.ArrayList;
import java.util.List;

public class StringUtility {

	public static int LEFT = 1;
	public static int RIGHT = 2;
	public static int BOTH = 3;

	public static List<String> compareString(List<String> strArrayA, List<String> strArrayB, int option) {

		List<String> returnList = new ArrayList<String>();

		switch (option) {
		case 1:
			/*
			 * a - a
			 * b - c
			 * c - d
			 * d - e
			 * 
			 * result : b
			 */
			for(String strA: strArrayA) {
				boolean blnFlag = true;
				for(String strB: strArrayB) {
					if(strA.equals(strB)) {
						blnFlag = false;
						break;
					}
				}
				if(blnFlag) {
					returnList.add(strA);
				}
			}
			break;

		case 2:
			/*
			 * a - a
			 * b - c
			 * c - d
			 * d - e
			 * 
			 * result : e
			 */
			for(String strB: strArrayB) {
				boolean blnFlag = true;
				for(String strA: strArrayA) {
					if(strB.equals(strA)) {
						blnFlag = false;
						break;
					}
				}
				if(blnFlag) {
					returnList.add(strB);
				}
			}
			break;
		case 3:
			/*
			 * a - a
			 * b - c
			 * c - d
			 * d - e
			 * 
			 * result : a c d
			 */
			for(String strA: strArrayA) {
				for(String strB: strArrayB) {
					if(strA.equals(strB)) {
						returnList.add(strA);
						break;
					}
				}
			}

			break;
		default:

			break;
		}

		return returnList;
	}

	public static List<String> removeDuplicatedString(String[] strArray) {

		List<String> result = new ArrayList<String>();
		for (String item : strArray) {
			boolean duplicate = false;
			for (String str : result) {
				if (str.equals(item)) {
					duplicate = true;
					break;
				}
			}
			if (!duplicate) {
				result.add(item);
			}
		}

		return result;
	}

	public static String getFileName(String fileName, String extend) {

		StringBuffer sb = new StringBuffer();

		if(fileName == null) {
			return null;
		}

		if(!fileName.contains("\\.") && extend != null) {
			sb.append(fileName).append(".").append(extend);
			fileName = sb.toString();
		}

		return fileName;
	}

	public static String getFileNameWithExt(String fileName, String extend) {

		StringBuffer sb = new StringBuffer();

		if(fileName == null) {
			return null;
		}

		if(!fileName.contains("\\.") && extend != null) {
			
			int idxEnd = fileName.lastIndexOf('.');
			String fName = fileName.substring(0, idxEnd);

			sb.append(fName).append(".").append(extend);
			fileName = sb.toString();
		}

		return fileName;
	}

	public static String getExtFileName(String fileName) {

		String[] arrayFileName = fileName.split("\\.");
		if (arrayFileName.length < 2) {
			return null;
		}

		return arrayFileName[arrayFileName.length -1];
	}

	public String removeQuotes(String source) {
    	if(source.contains("\"")) {
    		source = source.replace("\"", "");
    	}
    	return source;
	}

}