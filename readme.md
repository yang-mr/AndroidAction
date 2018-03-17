四大组件
 广播:
  LocalBroadcastManager
  的异同
  BroadcastReceiver
  
  IntentFilter和Intent的异同

  
  Http
    If-None-Match
    If-modified-Since 304 比较client跟server资源的时间，如果相等，则server返回304 client直接用本地缓存

    xUtils3:

    TaskProxy 里面包含一个真实的AbsTask(能继承canceable接口的抽象类)实现类为HttpTask, 
    1. 执行TaskProxy.doBackground(), 里面调用HttpTask的doBackground();
    2. 由1 HttpTask.doBackground里面创建RequestWorker实例，（RequestWorker类是HttpTask内部类), 执行requestWorker.request();
    3. 由2 requestWorker.request() 执行request.loadResult(); request: UriRequest实现类是HttpRequest类，在 2 httpTask.doBackground 方法里的createNewRequest() 方法创建的;
    4. 由3 HttpRequest.loadResult() 调用父类UriRequest.loadResult()-->Loader.load(UriRequest request) (Loader的实现类是StringLoader这个是在创建HttpRequest创建的也就是3 ）
    5. 由4 stringLoader.load(UriRequest request)--> request.sendRequest()执行完，StringLoader通过load(InputStream in)方法将响应的二进制流转为相应的对象;
    6.这样3 里面的RequestWorker 得到了响应的对象，然后一层一层传最终到1 TaskProxy.doBackground(), TaskProxy.onSuccess()->HttpTask.onSuccess(), HttpTask 拿到最终的响应结果通过用户传入的callback回调响应的结果。
