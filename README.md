#eno-simple-servlet-framework 1.0.3 使用说明

##依赖jar
    commons-beanutils-1.8.0.jar

    commons-collections-3.2.1.jar

    commons-lang-2.5.jar

    commons-logging-1.1.1.jar

    dom4j-1.6.1.jar

    ezmorph-1.0.6.jar

    son-lib-2.4-jdk15.jar

    namphy_core-1.0.0.jar

##pom.xml (dependencies)
```xml
    <dependencies>
    	<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>commons-collections</groupId>
			<artifactId>commons-collections</artifactId>
			<version>3.2.2</version>
		</dependency>
		<dependency>
			<groupId>commons-lang</groupId>
			<artifactId>commons-lang</artifactId>
			<version>2.6</version>
		</dependency>
		<dependency>
			<groupId>commons-logging</groupId>
			<artifactId>commons-logging</artifactId>
			<version>1.2</version>
		</dependency>
		<dependency>
			<groupId>net.sf.ezmorph</groupId>
			<artifactId>ezmorph</artifactId>
			<version>1.0.6</version>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>commons-beanutils</groupId>
			<artifactId>commons-beanutils</artifactId>
			<version>1.9.2</version>
		</dependency>
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.3.1</version>
		</dependency>
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.4</version>
		</dependency>
		<dependency>
			<groupId>dom4j</groupId>
			<artifactId>dom4j</artifactId>
			<version>1.6.1</version>
		</dependency>
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.6.1</version>
		</dependency>
	</dependencies>
```

##必备url参数
###url地址: enoAjaxJSONHandler
* 参数名  : ANNO_BEAN
    * 备注 : service注解名(默认类名小写开头，可自定义)


##Html-ajax调用方式
```javascript
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>

<script type="text/javascript">
 function test(){
     
	 $.ajax({
		url:"enoAjaxXMLHandler",	// 请求的url地址,Struts2中就是请求的<action>的name
		type:"post",	// 提交方式
		data:{"ANNO_BEAN":"testService"},	// 提交的数据,一般使用JSON表示
		success:function(data){	// 请求成功后执行的操作
			alert(data);
		},
		error:function(data){	// 请求失败后执行的操作
			alert("error")
		}
	 }) 
 }
 function test2(){
	 
	 $.ajax({
		url:"enoAjaxJSONHandler",	// 请求的url地址,Struts2中就是请求的<action>的name
		type:"post",	// 提交方式
		data:{"ANNO_BEAN":"testService2"},	// 提交的数据,一般使用JSON表示
		success:function(data){	// 请求成功后执行的操作
			alert(JSON.stringify(data);
		},
		error:function(data){	// 请求失败后执行的操作
			alert("error")
		}
	 }) 
 }

</script>
```



##创建service类


```java
@ServiceBean (name=”自定义的名称”)
public class TestService  implements IService { // xml返回方式
    @Override
	public Object execute(Map<String, String> params) throws Exception {
		ItemXMLObject ixo =null;
//		ixo.addProperty("hello", "欢迎");
//		ixo.setContent("--");
		return ixo ;
	}
}

@ServiceBean (name=”自定义的名称”)
public class TestService2  implements IService{ // json返回方式
	@Override
	public Object execute(Map<String, String> params) throws Exception{
	Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success for inval : " + params.get("name"));
		return map;
	}
}
```


##配置web.xml
```xml
<context-param>
<!-- 固定参数 -->
<param-name>enoServiceConfigLocation</param-name>
<!-- xml地址,可以为classpath:com.eno.xx.xml 。 -->
<!-- 无classpath表示，在webroot根目录下的文件。 -->
<param-value>classpath:enoAnnoServiceConfig.xml</param-value>        
</context-param>
```

##enoAnnoServiceConfig.XML文件格式
```xml
<?xml version="1.0" encoding="UTF-8"?>
<config>
    <service>
		<list>
			<item>com.eno.note</item>
			<item>com.eno.anno</item>
		</list>
	</service>
</config>
```
 
 

##关于作者
* [qq空间](http://user.qzone.qq.com/945891539)
 