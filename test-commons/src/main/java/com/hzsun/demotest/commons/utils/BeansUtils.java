package com.hzsun.demotest.commons.utils;

import com.hzsun.demotest.commons.exceptions.ApiErrorEnum;
import com.hzsun.demotest.commons.exceptions.ApiException;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**  
* @Description:类的转化器 
 * @Author: dingjl  
* @Date: 2018年4月12日  
**/
public class BeansUtils {
    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);
    /**
     * @Description 类的转化通过 把源对象的变量值转化到目标相同的对象值上面
     * @param srcbean 源对象
     * @param 目标对象
     * **/
    public static void convert(Object srcBean, Object targetBean){
        if(CollectionUtil.isEmpty(srcBean)){
            targetBean=null;
            return;
        }
        if(CollectionUtil.isEmpty(targetBean)){
            return;
        }
      try {
        BeanUtils.copyProperties(targetBean, srcBean);
      } catch (IllegalAccessException e) {
        logger.error(ExceptionUtils.getTrace(e));
      } catch (InvocationTargetException e) {
        logger.error(ExceptionUtils.getTrace(e));
      }
    }
    /**
	 * 通过属性名获取属性对象
	 * @param object 对象
	 * @param name 属性名
	 * @return 属性对象
	 */
	public static final Field getDeclaredProperty(Object object, String name) {
		return null != object ? getDeclaredProperty(object.getClass().getName(), name) : null;
	}
    /**
	 * 通过属性获取相应的值
	 * @param object 对象
	 * @param name 属性名
	 * @return 相应的值
	 */
	public static final Object getValueByProperty(Object object, String name) {
		Object result = null;
		if (null != object && StringUtil.isNotBlank(name)) {
			Field field = getDeclaredProperty(object, name);
			if (null != field) {
				boolean accessible = field.isAccessible();
				field.setAccessible(true);
				try {
					result = field.get(object);
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {
				}
				field.setAccessible(accessible);
			}
		}
		return result;
	}
	/**
	 * 通过属性名获取属性对象
	 * @param className 类名
	 * @param name 属性名
	 * @return 属性对象
	 */
	public static final Field getDeclaredProperty(String className, String name) {
		Field f = null;
		try {
			if (StringUtil.isNoneBlank(className, name)) {
				Class<?> clazz = Class.forName(className);
				f = clazz.getDeclaredField(name);
			}
		} catch (SecurityException e) {
		} catch (NoSuchFieldException e) {
		} catch (ClassNotFoundException e) {
		}
		return f;
	}
	
	/** 
    * 将一个 JavaBean 对象转化为一个  Map 
    * @param bean 要转化的JavaBean 对象 
    * @return 转化出来的  Map 对象 
    * @throws IntrospectionException 如果分析类属性失败 
    * @throws IllegalAccessException 如果实例化 JavaBean 失败 
    * @throws InvocationTargetException 如果调用属性的 setter 方法失败 
    */  
	 @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map convertBean(Object bean) {  
	     try{
	        Class type = bean.getClass();  
	        Map returnMap = new HashMap();  
	        BeanInfo beanInfo = Introspector.getBeanInfo(type);  
	  
	        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();  
	        for (int i = 0; i< propertyDescriptors.length; i++) {  
	            PropertyDescriptor descriptor = propertyDescriptors[i];  
	            String propertyName = descriptor.getName();  
	            if (!propertyName.equals("class")) {  
	                Method readMethod = descriptor.getReadMethod();  
	                Object result = readMethod.invoke(bean, new Object[0]);  
	                if (result != null) {  
	                    returnMap.put(propertyName, result);  
	                } 
	            }  
	        } 
	        return returnMap; 	        
	     }catch(Exception e){
	         throw new ApiException(ApiErrorEnum.A_Application_ConvertError);
	     }
	       
	   
	    }

}
  
    