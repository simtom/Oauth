﻿                      使用 python 测试，引入requests包


   
     
     Oauth协议的授权流程
![Alt text](./img/新建 RTF 文档53.png)



       1. 配置文件配置了需要保护的资源

![Alt text](./img/新建 RTF 文档75.png)


      2. 尝试去访问受保护的资源  

![Alt text](./img/新建 RTF 文档94.png)



Response为
![Alt text](./img/新建 RTF 文档108.png)



资源受到保护，测试无问题

      3. Oauth2.0协议定义了四种客户端的授权模式

授权码模式（authorization code）
简化模式（implicit）
密码模式（resource owner password credentials）
客户端模式（client credentials）

    4. 采用第三种客户端授权模式测试
![Alt text](./img/新建 RTF 文档282.png)







Respond成功返回了token及相关信息
![Alt text](./img/新建 RTF 文档309.png)


      5. 如果提供的凭证信息有误（更改client_secret）

![Alt text](./img/新建 RTF 文档345.png)


   Respond返回
![Alt text](./img/新建 RTF 文档362.png)


Token相关信息的获取测试通过

    6. 使用token访问受保护的资源
 ![Alt text](./img/新建 RTF 文档402.png)

 Respond返回
![Alt text](./img/新建 RTF 文档418.png)

携带正确的token信息访问受保护的资源测试通过

      7. 携带错误的token信息测试

![Alt text](./img/新建 RTF 文档464.png)

Respond返回

![Alt text](./img/新建 RTF 文档482.png)


携带错误的token信息无法访问资源






