# ddeemmoo
这是我的一个demo小仓库，我会把我觉得实用的代码整理在这里

## nomal
### base
`HelloWorld` 打印 hello world

### date
`DateTest` 对日期进行计算




## springboot001
`UserController.addUser` 测试将post请求中的数据封装为实体类<br>
可以使用 postman 模拟post请求，请求地址 `localhost:8080/addUser`, 在 body里面添加 json 数据
```json
{
	"code": "1234",
	"user": {
		"username": "penruins",
		"password": "mzrfviwhninayh",
		"email": "lx_tdcq_king@icloud.com",
		"phone": "17356582393"
	},
	"msg": "login success"
}

```

`Springboot0001ApplicationTests.testSelect`
读取数据库中t_user的数据
- 在 `pom.xml` 中添加 `postgresql`, `mybatis plus` 和 `lombok` 的依赖
- 在 `application.yaml` 中添加 `datasource`
- 在数据库中创建数据表，初始化一些数据，脚本在script/db.sql中
- 编写与数据库对应的实体类 User
- 编写UserMapper
- 在 `Springboot0001Application` 中添加注解 @MapperScan()
- 在测试类 P0001ApplicationTests 编写测试代码











