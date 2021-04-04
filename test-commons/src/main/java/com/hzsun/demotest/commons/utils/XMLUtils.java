package com.hzsun.demotest.commons.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;


public class XMLUtils {
	public static Map<String, String> parserXML(String strXML) throws DocumentException{
		 Map<String, String> retMap = new HashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            Document parseText = DocumentHelper.parseText(strXML);
            Element rootElement = parseText.getRootElement();
            ArrayList<org.dom4j.Element> elements = (ArrayList<org.dom4j.Element>) rootElement.elements();
            for (org.dom4j.Element e : elements) {
           	 nodeadd2Map(e, retMap);
            }
        }  catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retMap;
    }
	private static void nodeadd2Map(org.dom4j.Element element, Map<String, String> retMap) {
//		if (node.hasChildNodes()) {
//			NodeList childNodes = node.getChildNodes();
//			for (int i = 0; i < childNodes.getLength(); i++) {
//				nodeadd2Map(childNodes.item(i), retMap);
//			}
//		}else {
//			retMap.put(node.getNodeName(), node.getNodeValue());
//		}
		if (element.elements().isEmpty()) {
			retMap.put(element.getName(), element.getText());
		}else {
			for (org.dom4j.Element e : (ArrayList<org.dom4j.Element>)element.elements()) {
          	 	nodeadd2Map(e, retMap);
           }
		}
		
	}
    public static String map2xml(Map<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if (null != v && !"".equals(v) && !"appkey".equals(k)) {
                sb.append("<" + k + ">" + parameters.get(k) + "</" + k + ">\n");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

}
