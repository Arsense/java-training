# 好记性不如烂笔头  
> `Java Source`：个人java训练代码库。


## TODO LIST

* [x] [SSM(一)DEMO1](https://github.com/Arsense/java-training)

## 参考书籍

- Springboot 整合Redis源码
目录
base-freemwork->
base-springboot->
base.springboot.book1.chapter7


## 需要书籍请留言 
邮箱+书名

# 初版三个库
- java-training 记录练习代码
- java-learning 记录技术java文章与技巧(自己写的) 
- java-book-storing 一些看的书的源码
别人写的好维护CSDN https://mp.csdn.net/postedit/102551769  



# 功能

## 排序
- [快速排序](base-java/base-new-java/src/main/java/com/base/demo/structure/sort/QuickSortService.java)








# 参考描述
CountDownTask 实现接口异步调用
解决的问题 5个查询接口 50msx5 = 250ms 接口优化为50ms性能优化为5倍
参考：https://juejin.im/post/5b9861d15188255c581a92a0
- case 1  CountDownLatch 
problem 需要耦合CountDownLatch的代码 countDownLatch.countDown(); 少掉一次 各种异常
- case 2 CompletableFuture
减少了CountDownLatch的耦合与管理
改进版 使用 CompletableFuture； 它是一个多功能的非阻塞的Future
实现见 CompletableFutureParallel类

- case 3  Fork/Join
我们上面用CompletableFuture完成了我们对多组任务并行执行，但是其依然是依赖我们的线程池，在我们的线程池中使用的是阻塞队列，也就是当我们某个线程执行完任务的时候需要通过这个阻塞队列进行，那么肯定会发生竞争




