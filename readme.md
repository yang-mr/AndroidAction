一般情况下，我们谈性能优化基本上会从以下几个方面：
    App启动速度优化
    UI流畅度优化
    内存优化
    apk瘦身
    电量优化

ThreadLocal.ThreadLocalMap 的底层数据结构导致 ThreadLocal 有内存泄漏的情况，尽可能在每次使用 ThreadLocal 后手动调用 remove()，以避免出现 ThreadLocal 经典的内存泄漏甚至是造成自身业务混乱的风险。

一款新型智能照片软件，是依据现代人的拍照需求量身打造的服务软件。系统会自动备份和整理您的照片备份到家庭CafeBox，并通过AI识别各种场景进行分类.

待复习：
    retrofit okhttp glide greenDao rxjava rxandroid dagger2
    四大组件启动流程
    动画（view, 属性动画)

待写博客
    ListView 观察者模式分析

注解处理器 annotation processor

四大组件
 广播:
  LocalBroadcastManager
  的异同
  BroadcastReceiver
  
  IntentFilter和Intent的异同

  
  Http
    If-None-Match
    If-modified-Since 304 比较client跟server资源的时间，如果相等，则server返回304 client直接用本地缓存

    xUtils3:http(s)

    TaskProxy 里面包含一个真实的AbsTask(能继承canceable接口的抽象类)实现类为HttpTask, 
    1. 执行TaskProxy.doBackground(), 里面调用HttpTask的doBackground();
    2. 由1 HttpTask.doBackground里面创建RequestWorker实例，（RequestWorker类是HttpTask内部类), 执行requestWorker.request();
    3. 由2 requestWorker.request() 执行request.loadResult(); request: UriRequest实现类是HttpRequest类，在 2 httpTask.doBackground 方法里的createNewRequest() 方法创建的;
    4. 由3 HttpRequest.loadResult() 调用父类UriRequest.loadResult()-->Loader.load(UriRequest request) (Loader的实现类是StringLoader这个是在创建HttpRequest创建的也就是3 ）
    5. 由4 stringLoader.load(UriRequest request)--> request.sendRequest()执行完，StringLoader通过load(InputStream in)方法将响应的二进制流转为相应的对象;
    6.这样3 里面的RequestWorker 得到了响应的对象，然后一层一层传最终到1 TaskProxy.doBackground(), TaskProxy.onSuccess()->HttpTask.onSuccess(), HttpTask 拿到最终的响应结果通过用户传入的callback回调响应的结果。
    
    xUtils3:DB(ORM)
        1.DbManager db = x.getDb(daoConfig)通过DbManager.DaoConfig 配置实例得到具体的DbManagerImpl实例，x.getDb(daoConfig)方法里通过调用DbManagerImpl的静态方法getInstance(daoConfig)例得到具体的DbManagerImpl实例,getInstance方法里首先看DAO_MAP集合（key:daoConfig value:DbManagerImpl)是否有对应的DbManagerImpl实例，有的话替换daoConfig,否则创建个实例，再保存到DAO_MAP集合方便下次使用；
        2.创建DbManagerImpl实例主要通过openOrCreateDatabase得到SQLiteDatabase， 将DaoConfig里面的一些属性赋值到自己, 然后通过DaoConfig的dbOpenListener接口回调onDbOpened(DbManager db)方法, getInstance方法得到了DbManagerImpl后，通过比较DbManagerImpl里面的SQLiteDatabase的数据库版本跟DaoConfig的数据库版本，如果不相等则设置新的数据库版本号；
        3. 由1 2配置好了数据，现在就开始进行增删改查，


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




    一些测试工具
        压力测试Monke

        单元测试junit mockito
            1. 依赖隔离
            2. mock 模拟条件

    内存分析工具
        Mat
        LeakCanary


eventBus分析
    
    订阅模式
    POSTING：发布跟订阅在同一线程，开销最小，默认的模式；

    MAIN：
    如果发布者在非ui线程，订阅者会切换到ui线程；

    MAIN_ORDERED：
    订阅者会先放到队列里，直到执行完相关逻辑代码才会处理订阅的代码。如果发布者在非ui线程，订阅者会切换到ui线程；
    BACKGROUND
    如果发布者在ui线程，订阅者会另开一个线程；如果发布者在非ui线程，订阅者会在当前线程；
    ASYNC
    订阅者都会另开一个线程

    Sticky 默认为false
    Sticky=true
    Sticky事件只指事件消费者在事件发布之后才注册的也能接收到该事件的特殊类型。

    订阅事件
    EventBus.getDefault().register(this); // 订阅
    
    // 订阅回调方法
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void hand(Event01 event01) {
        String name = event01.getName();
    }

    发布事件：
    EventBus.getDefault().postSticky(new Event01("jack"));

订阅逻辑代码分析：
    1.通过单例模式EventBus.getDefault()得到实例eventBus, 然后通过eventBus.register(Object subscriber) 方法实现订阅, 在register方法里， 首先会通过实例得到相应的类， 然后通过(该实例是在EventBus(EventBusBuilder builder)构造方法里实例化的)subscriberMethodFinder.findSubscriberMethods(subscriberClass) 得到订阅者的所有订阅方法, 该方法里ConcurrentHashMap(实现缓存)保存类的所有订阅者方法，如果缓存中没有相应的信息，ignoreGeneratedIndex（boolean 默认是false)则调用findUsingInfo(subscriberClass), 该方法里把相关信息保存在FindState实例(通过prepareFindState() 该方法里通过FIND_STATE_POOL数组进行stateFind的缓存如果数组里面有stateFind则直接方法并把数组相应的位置的保存对象设为null, 否则就new一个, 该数组里的对象是在 下面的 2保存的)里面， 然后通过findUsingReflectionInSingleClass(FindState findState)该方法里通过反射得到所有DeclaredMethod， 然后遍历所有的方法，通过判断方法的参数个数为1， 然后再获取方法注解类是否为Subscribe，判断通过后stateFind.checkAdd(Method method, Class<?> eventType)添加到stateFind实例的anyMethodByEventType hashMap里， 该方法会检查是否有存在多个订阅者监听相同的事件类型， checkAdd返回true, 最后会将注解类里信息保存到SubscriberMethod实例，添加到stateFind的subscriberMethods集合里面；
    2. 由1 我们得到了一些订阅者的信息保存在stateFind实例里， findUsingInfo方法最后通过getMethodsAndRelease(findState)得到List<SubscriberMethod>，然后将stateFind实例的属性进行回收， 再将stateFind保存到FIND_STATE_POOL数组里面方便下次再用。
    3. 通过1 2 findSubscriberMethods方法得到List<SubscriberMethod>保存在METHOD_CACHE里面方便下次使用；eventBus.register(Object subscriber)方法得到了List<SubscriberMethod>后再遍历调用subscribe(subscriber, subscriberMethod)该方法里总要将相关信息保存到Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType (Subscription实例保存subscriber订阅者，subscriberMethod订阅者里面的订阅方法)
    4.





