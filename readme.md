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



    view事件分发
        dispatchTouchEvent(MotionEvent event)---->mOnTouchListener.onTouch()---->onTouchEvent()---->mOnClickListener.onClick()


    PreLoader 
        startActivity之前预加载
           由1 2步提前加载数据：
           1.PreLoader.preLoad(DataLoader loader)->PreLoaderPool.preLoad(DataLoader loader)->创建个Worker实例, 然后执行preLoadWorker(worker)该方法里生成一个唯一的id，然后将id和worker一对一保存在ConcurrentHashMap里面，最后执行worker.preLoad();
           2.由1 state.startLoad()->worker.doStartLoadWork()之前的state是创建Worker的时候init()方法里设置的StatusInitialed状态，在该方法里置worker状态StateLoading, 其次执行线程池的线程,该线程里加载数据得到数据（用户传入的接口，然后回调用户获取到的数据）最后置worker为StateLoadCompleted状态;
           显示数据
           3.得到PreLoaderId, PreLoader.listenData(int preLoaderId, DataListener listener)->PreLoaderPool.listenData(int id, DataListener listener) get对应id的worker，然后执行worker.listenData(DataListener listener)->state.listenData(DataListener listener)state由最近重置的StateLoadCompleted状态->worker.doSendLoadedDataToListenerWork(DataListener listener)首先将DataListener保存在dataListeners(CopyOnWriteArrayList)里面，然后执行doSendLoadedDataToListenerWork(final List<DataListener<T>> listeners)该方法里面置state为StateDone状态, 然后再执行safeListenData(List<DataListener<T>> listeners, T t)->接口回调，用户最终得到数据。
           4. activity.onDestroy()->PreLoader.destroy(int id)->PreLoaderPool.destroy(int id) remove对应的worker， 然后worker.destroy()->state.destroy()该处的state为最近设置的StateDone状态->worker.doDestroyWork()该方法里设置state为StateDestroyed状态清理一些数据;
