#Springboot

book1 参考深入浅出Springboot 2.0x


- aopdemo aop拦截Controller的一直实例
- chapter7 Springboot 集成Redis

```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
			<version>2.2.1.RELEASE</version>
			<!--不依赖Redis的异步客户端lettuce-->
			<exclusions>
				<exclusion>
					<groupId>io.lettuce</groupId>
					<artifactId>lettuce-core</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<!--引入Redis的客户端驱动jedis-->
		<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>2.9.0</version>
		</dependency>
	</dependencies>

```