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