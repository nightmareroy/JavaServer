package common;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class Config {
	public static String resourcesPath="src/main/resources/";
	
	//callBackManager
	public static int callBackManager_threadPoolNum;
	
	//mysql
	public static String mysql_user;
	public static String mysql_pwd;
	public static String mysql_url;
	
	//loginServer
	public static String loginServer_url;
	public static String loginServer_port;
	
	public static void Init()
	{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document document = db.parse(resourcesPath+"config.xml");
			
			//callBackManager
			Element callBackManager=(Element)document.getElementsByTagName("callBackManager").item(0);
			callBackManager_threadPoolNum=Integer.parseInt(callBackManager.getAttribute("threadPoolNum"));
			
			//mysql
			Element mysql=(Element)document.getElementsByTagName("mysql").item(0);
			mysql_user=mysql.getAttribute("user");
			mysql_pwd=mysql.getAttribute("pwd");
			mysql_url=mysql.getAttribute("url");

			//loginServer
			Element loginServer=(Element)document.getElementsByTagName("loginServer").item(0);
			loginServer_url=loginServer.getAttribute("url");
			loginServer_port=loginServer.getAttribute("port");


		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
