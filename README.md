# ddeemmoo
这是我的一个demo小仓库，我会把我觉得实用的代码整理在这里

## nomal
### base
`HelloWorld` 打印 hello world
### date
`DateTest.test001()` 对日期进行计算<br>
`DateTest.test002()` 如何获取此时此刻的小时数<br>
### database
#### postgresql
`MainTest.test001()` 查询数据库中 `t_users` 表中的所有数据，并且打印<br>
`MainTest.test002()` 在数据库表 `t_people` 插入数据，有一百六十万条<br>
`MainTest.test003()` 读取 160万 条用户的数据<br>
`MainTest.test004()` 查询 160万 条用户的数据，根据 id<br>
`MainTest.test005()` 查询 160万 条用户的数据，根据 id, 先在 `redis` 中查询，如果存在直接读出，如果不存在查询 `postgreSQL`, 并插入 `redis`<br>
运行 `test004()` 162945ms
第一次运行 `test005()` 390024ms
第二次运行 `test005()` 195023ms
### random
`NameRandom.randomNames()` 随机生成400个名字<br>
`NumberRandom.randomNumber(int number)` 产生一个0~number-1 之间的随机数<br>
`NumberRandom.test001()` 对上一个方法的测试<br>
`random.entity.People` 后面对随机生成的用户信息进行封装<br>
`script/db.sql t_people` 这个表用于存储随机生成的用户的信息
### redis
`RedisTest.test001()` 连接 `redis`<br>
`RedisTest.test002()` set a k-v to redis<br>
`RedisTest.test003()` get k-v from redis<br>
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

`UserController.addUser` http的response请求也是可以通过String类型来接收的

`Springboot0001ApplicationTests.testSelect`
读取数据库中t_user的数据
- 在 `pom.xml` 中添加 `postgresql`, `mybatis plus` 和 `lombok` 的依赖
- 在 `application.yaml` 中添加 `datasource`
- 在数据库中创建数据表，初始化一些数据，脚本在script/db.sql中
- 编写与数据库对应的实体类 User
- 编写UserMapper
- 在 `Springboot0001Application` 中添加注解 @MapperScan()
- 在测试类 P0001ApplicationTests 编写测试代码

在 `application.yaml` 中添加一行配置，在执行时会打印出sql语句


`Springboot0001ApplicationTests.testInsert`
- 新建一个 `entity` `User2`, 它和 `User` 的区别在于多了两个字段，`update_time` 和 `create_time`
- 这两个字段在测试方法中是需要手动添加的，在后面需要实现自动填充

`Springboot0001ApplicationTests.testInsert2`
- 在实体类的成员 `createTime` 和 `updateTime` 上添加注解
- 编写 `MyMetaObjectHandler` 并实现 `MetaObjectHandler`
- 编写测试代码, 创建时间和修改时间现在不赋值的情况下，也是有数据的

## springboot002
测试websocket
1. 添加依赖 `spring-boot-starter-websocket`
2. 添加配置 `WebSocketConfig`
3. 编写 `WebSocketServer`
4. 在启动类上添加 `@EnableScheduling`
5. 创建定时任务 `SendSchedule`

最后的实现效果是访问了websocket地址 `ws://localhost:8888/imserver/111`的客户端会每隔5s收到一条 message
在代码中这条 message 是服务器当前的时间