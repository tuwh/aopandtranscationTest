本工程为aop测试工程。
测试总结：

<h2>最外层aop方法调用顺序为</h2>

arroud-begin
before
target
arroud-end
after
after-return
after-throw

<h2>被嵌套的aop调用 顺序为</h2>
before
arroud-begin
target
after
arroud-end
after-return
after-throw

并且在有多个切入点调用的时候，为嵌套式调用。即最外层方法arroud开始后，开始第二个的嵌套.多次嵌套日志如下：
<code>
========================around方法开始调用！AopClass3
=====================before 方法调用！AopClass3
=====================before 方法调用！AopClass1
========================around方法开始调用！AopClass1
=====================before 方法调用！AopClass2
========================around方法开始调用！AopClass2
===================invoke target class
===================after方法调用AopClass2
========================around方法结束调用！AopClass2
===================afterReturn方法调用AopClass2
===================after方法调用AopClass1
========================around方法结束调用！AopClass1
===================afterReturn方法调用AopClass1
========================around方法结束调用！AopClass3
===================after方法调用AopClass3
===================afterReturn方法调用AopClass3
</code>

order顺序最小的切入点在最外面。被嵌套的切入点中所有的切入方法都会优先于外面切入点的方法执行。

<h2>
spring事物是aop中around的运用。根据上面的利润结果，可得出下面的结论：
1、如果自定义的aop，order比事物的order要小。此时自定义的aop如果运行报错，事物不会回滚。
因事物方法为自定义aop类中around方法中嵌套的方法。joinpoint.proceed();方法执行完成后，则表示事物已经执行完成，事物已提交
2、如果自定义的aop，order比事物的order要大。
<p>1、自定义的aop方法如果报错，事物会回滚。</p>
<p>2、如果target方法报错，自定义around方法进行异常捕获。此时事物不会回滚</p>
</h2>
