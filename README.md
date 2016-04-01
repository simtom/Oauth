#Oauth

<strong>Oauth示例</strong>

项目用Maven管理

使用的技术


<ol>

 <li>Spring </li>

 <li>Spring Security </li>

 <li>spring-security-oauth2 </li>

</ol>

<hr/>




<h3>
 <a href="http://localhost:8080">在线测试</a>
</h3>
<hr/>
<p>
<strong>如何使用?</strong>
<ol>
<li>
项目是Maven管理的, 需要本地安装maven, 还有MySql
</li>
<li>
创建MySQL数据库(如数据库名oauth2), 并运行相应的SQL脚本(脚本文件位于others/database目录),

<br/>

   执行sql脚本即可

</li>

<li>

修改位于src/main/resources目录中的数据库连接信息(包括username, password等)

</li>

<li>

将本地项目导入到IDE(如Intellij IDEA)中,配置Tomcat(或类似的servlet运行服务器), 并启动Tomcat(默认端口为8080);

<br/>
</ol>
</p>
<hr/>
<strong>grant_type</strong>
<br/>

    Oauth支持4种不同的授权方式（现只完成password和implicit的授权方式）
    
<ol>

    <li>
    <code>password</code> -- 密码模式(将用户名,密码传过去,直接获取token)
    <br>
          <a href="https://tools.ietf.org/html/rfc6749#section-1.3.1">查看password授权在RFC 6749协议中的认证流程</a>
     
    
    </li>
    
    
    
    
    
    
    <li><code>implicit</code> -- 不通过第三方应用程序的服务器，直接在浏览器中向认证服务器申请令牌
    <br>
          <a href="https://tools.ietf.org/html/rfc6749#section-1.3.1">查看implicit授权在RFC 6749协议中的认证流程</a></li>

</ol>
<hr/>
#***password授权方式***
<strong>测试token的获取</strong>
<p>使用python测试，请求token

<code>import requests
data={"client_id":"test","client_secret":"test","username":"test","password":"test","grant_type":"password","scope":"read"}
r = requests.post("http://127.0.0.1:8080/Oauth/oauth/token",params=data)
print(r.text)
</code>
<p>返回的token相关信息
<code>
{"access_token":"22e73c1a-876e-42fe-9549-16096eceb0ec","token_type":"bearer","expires_in":3599,"scope":"read"}
</code>
<hr/>
<strong>访问受保护的资源</strong>
<p>使用获取到的token，访问受保护的资源
<code>
import requests
token={"access_token":"22e73c1a-876e-42fe-9549-16096eceb0ec"}
r = requests.put("http://127.0.0.1:8080/Oauth/abcs/hello",params=token)
print(r.text)
</code>
<p>服务端的响应

<code>
{"test":"hello world!"}
</code>

#***implicit授权方式***


**1.客户端将用户导向认证服务器。**
**2.用户决定是否给于客户端授权。**
**3.假设用户给予授权，认证服务器将用户导向客户端指定的"重定向URI"，在URI中包含了访问令牌。**
**4.浏览器向资源服务器发出请求，使用上一步的令牌**
**5.获取到资源**
<br>
<code>
http://localhost:8080/Oauth/oauth/authorize?client_id=test&redirect_uri=http://localhost:8080/Oauth/teacher/getAll&response_type=code&scope=read
</code>

