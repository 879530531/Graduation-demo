#寒假作业

>毕业设计管理系统

[需求文档](./MRD.md)   |  [项目详细分工](./DIVISION.md)

**1.开发环境**

IDE：`idea`  
web服务器：`Tomcat 7.x以上`  
数据库：`Mysql5.7`

**2.数据信息**  

`管理员账号密码：admin/0774123`

**3.项目结构**

├── classes  编译后源代码  
├── src  源代码  
│   ├── com  
│   │   └── gxuwz  
│   │       ├── core  核心类    
│   │       └── PangGuangyao  业务类   
│   ├── conf  配置  
│   ├── META-INF  
│   └── util  工具类  
└── WebRoot  web根目录  
    ├── css  样式  
    ├── error  错误页面  
    ├── images  图像  
    ├── js  js文件  
    ├── META-INF  
    ├── third  相关类库  
    ├── upload 文件上传  
    └── WEB-INF    
        ├── classes  编译后源代码  
        ├── common  
        ├── DB_Backup  数据库备份  
        ├── lib  依赖  
        ├── page  页面  
        └── tld  
        
**4.配置开发环境**  
1.新建数据库  
2.导入DB_Backup文件夹下的[daoa_db.sql](./WebRoot/WEB-INF/DB_Backup/daoa_db.sql)数据库文件  
3.配置Tomcat即可  