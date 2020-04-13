# APIGateway
APIGateway API网关项目，从头开始实现一个APIGateway，用来学习API网关的设计和实现。

# 文档列表

- [APIGateway设计的思路](http://cxis.me/2020/04/06/APIGateway设计的思路/)
- [APIGateway设计文档](http://cxis.me/2020/04/07/APIGateway设计文档/)
- [APIGateway中责任链模式的使用](http://cxis.me/2020/04/08/APIGateway中责任链模式的使用/)
- [APIGateway中加密验签介绍](http://cxis.me/2020/04/08/APIGateway中加密验签介绍/)
- [APIGateway中流控介绍](http://cxis.me/2020/04/09/APIGateway中流控介绍/)
- [APIGatewat中使用Dubbo泛化调用](http://cxis.me/2020/04/09/APIGatewat中使用Dubbo泛化调用/)
- [APIGateway中获取客户端IP的方法](http://cxis.me/2020/04/12/APIGateway中获取客户端IP的方法/)
- [APIGateway总结](http://cxis.me/2020/04/13/APIGateway总结)

# 运行

1. 启动Zookeeper
2. 启动mysql，执行sql目录下的schema.sql和data.sql
3. 可使用APIGateway-core中的me.cxis.agw.utils.CodecUtil示例，加密和解密请求数据
4. 启动APIGateway-sample中的示例Dubbo Provider项目
5. 启动APIGateway-core
6. 使用第三步中的URL和加密data，POST方式请求接口
7. 返回加密的数据，可以根据实际情况使用CodecUtil解密
