package com.yw.yw.action;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created on 2017/11/121:47.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class MyView extends View {
    private int width = 400;
    private int height = 400;

    private Bitmap mSrcBitmap;
    private Bitmap mDstBitmap;
    //private Paint mPaint;
    private int mItemWaveLength = 0;
    private int dx = 0;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);      //禁用gpu 加速

//        mSrcBitmap = makeSrc(width, height);
//        mDstBitmap = makeDst(width, height);
        mPaint = new Paint();

        // 正片叠底 实例
//        mDstBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.birth1,null);
//        mSrcBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.birth2,null);

        // Mode.Src_in 实例
//        mDstBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.src_in,null);
//        mSrcBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.src_in2,null);


        mPaint = new Paint();
        mPaint.setColor(Color.RED);

        mDstBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.hearmap, null);
        mSrcBitmap = Bitmap.createBitmap(mDstBitmap.getWidth(), mDstBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        mItemWaveLength = mDstBitmap.getWidth();
        startAnim();
    }

    private void startAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0,mItemWaveLength);
        animator.setDuration(6000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int)animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        testModeDST_IN(canvas);
    }

    /**
     * 颜色叠加相关模式
     * Mode.ADD（饱和度相加）、Mode.DARKEN（变暗）
     * Mode.LIGHTEN（变亮）、Mode.MULTIPLY（正片叠底）
     * Mode.OVERLAY（叠加），Mode.SCREEN（滤色）
     *
     * Mode.MULTIPLY（正片叠底）源图片的非相交部分在目标图片透明时，设置为透明。其他mode源图片的非相交部分保持不变
     */
    private void testModeADD(Canvas canvas) {
        int layerID = canvas.saveLayer(0,0,width*2,height*2,mPaint,Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(mDstBitmap, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(mSrcBitmap,width/2,height/2, mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(layerID);
    }

    /**
     *  正片叠底 实例运用
     * @return
     */
    private void testModeMULTIPLY(Canvas canvas) {
        int layerID = canvas.saveLayer(0,0,getWidth(),getHeight(),mPaint,Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(mSrcBitmap, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(mDstBitmap,0,0, mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(layerID);
    }

    /**
     * SRC相关模式
     * Mode.SRC、Mode.SRC_IN、Mode.SRC_OUT、Mode.SRC_OVER、Mode.SRC_ATOP
     * 一般而言SRC_ATOP是可以和SRC_IN通用的，
     * 但SRC_ATOP所产生的效果图在目标图不是透明度不是0或100%的时候，会比SRC_IN模式产生的图像更亮些
     */
    private void testSRC(Canvas canvas) {
        int layerID = canvas.saveLayer(0,0,width*2,height*2,mPaint,Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(mDstBitmap, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(mSrcBitmap,width/2,height/2, mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(layerID);
    }

    /**
     * Mode.SRC_IN 实例
     * @return
     */
    private void testModeSRC_IN(Canvas canvas) {
        int layerID = canvas.saveLayer(0,0,getWidth(),getHeight(),mPaint,Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(mDstBitmap, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mSrcBitmap,0,0, mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(layerID);
    }


    /**
     * DST相关模式
     * Mode.DST、Mode.DST_IN、Mode.DST_OUT、Mode.DST_OVER、Mode.DST_ATOP
     * 一般而言SRC_ATOP是可以和SRC_IN通用的，
     * 但SRC_ATOP所产生的效果图在目标图不是透明度不是0或100%的时候，会比SRC_IN模式产生的图像更亮些
     */
    private void testDST(Canvas canvas) {
        int layerID = canvas.saveLayer(0,0,width*2,height*2,mPaint,Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(mDstBitmap, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(mSrcBitmap,width/2,height/2, mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(layerID);
    }

    /**
     * Mode.DST_IN 实例  当然也可以用Mode.SRC_IN 实现
     * @param canvas
     */
    private void testModeDST_IN(Canvas canvas) {
     /*   Canvas c = new Canvas(mDstBitmap);
        //清空bitmap
        c.drawColor(Color.BLACK, PorterDuff.Mode.CLEAR);*/
        //画上矩形
        canvas.drawRect(mDstBitmap.getWidth() - dx,0,mDstBitmap.getWidth(),mDstBitmap.getHeight(),mPaint);

        //模式合成
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(mDstBitmap,0,0,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(mSrcBitmap,0,0,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }

    // create a bitmap with a circle, used for the "dst" image
    static Bitmap makeDst(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFFFFCC44);
        c.drawOval(new RectF(0, 0, w, h), p);
        return bm;
    }

    // create a bitmap with a rect, used for the "src" image
    static Bitmap makeSrc(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFF66AAFF);
        c.drawRect(0, 0, w, h, p);
        return bm;
    }

    /**
     * android 中的色彩矩阵
     * 
     */

    // 单个颜色的蓝色通道
    private void testColorMatrix(Canvas canvas) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setARGB(255, 200, 100, 100);

        canvas.drawRect(0,0,500,600,mPaint);

        canvas.translate(550, 0);

        /**
         *  RGBA  A:透明度
         *  ColorMatrix colorMatrix = new ColorMatrix(new float[] {
             -1, 0, 0, 0, 0,
             0, -1, 0, 0, 0,
             0, 0, -1, 0, 0,
             0, 0, 0, 1, 0,
             });    // 1.色彩的反转
                        2.色彩的平移
                        3.色彩的缩放
                        4.色彩的旋转
                        5.色彩的投影
         */
        ColorMatrix colorMatrix = new ColorMatrix(new float[] {
                -1, 0, 0, 0, 0,
                0, -1, 0, 0, 0,
                0, 0, -1, 0, 0,
                0, 0, 0, 1, 0,
        });
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawRect(0,0,500,600,mPaint);
    }

    /**
     * Paint之setColorFilter
     *
     * ColorFilter的几个子类的用法 ColorMatrixColorFilter LightingColorFilter光照颜色过滤器
     * PorterDuffColorFilter  通过Mode.SRC、Mode.SRC_IN、Mode.SRC_ATOP能够实现setTint()的功能，可以改变纯色图标的颜色。
     */
    private void testLightingColorFilter(Canvas canvas) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        // R.drawable.bule
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), 0);
        int width = 300;
        int height = 300;

        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), mPaint);

        canvas.translate(550, 0);

        int mul = 0x00ff00;   // 0xffffff:RGB  每个8位
        int add = 0x000000;
        mPaint.setColorFilter(new LightingColorFilter(mul, add));
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), mPaint);

        canvas.translate(900, 0);
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.XOR));
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), mPaint);
    }

    /**
     * Xfermode
     * 1 AvoidXfermode
     * 2
     * 3
     *
     * AvoidXfermode，PixelXorXfermode是完全不支持的，而PorterDuffXfermode是部分不支持的。GPU
     *
     * 即要使用该对象
     *  1.禁用GPU
     *  2.使用离屏绘制
     */
    private void testAvoidXfermode(Canvas canvas) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        // R.drawable.dog
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), 1);
        int width = 300;
        int height = 300;

        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), mPaint);

        canvas.translate(550, 0);

        int layerID = canvas.saveLayer(0,0,width,height,mPaint,Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), mPaint);
       // mPaint.setXfermode(new AvoidXfermode(Color.WHITE,100, AvoidXfermode.Mode.TARGET));
        canvas.drawRect(0,0,width,height,mPaint);

        canvas.restoreToCount(layerID);
    }

    /**
     * Canvas 画布的一些操作
        translate 移动
        canvas.rotate(30);//顺时针旋转画布
        canvas.scale(0.5f, 1);   //缩放  x 缩放到 原来到1／2  y 不变
        canvas.skew(1.732f,0);//X轴倾斜60度，Y轴不变
     */
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Paint mPaint;

    private void testCanvasAndBitmap(Canvas canvas) {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(20);
        mBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);   //只是将字保存在bitmap上  这样不会显示在view
        mCanvas.drawText("启舰大SB",0,100,mPaint);

        canvas.drawBitmap(mBitmap, 0, 0, mPaint);  //将bitmap画在view上
    }

    private void canvasByTranslate(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        canvas.translate(-20, -10);  //画布平移 dx dy
        Rect rect = new Rect(0, 0, 100, 100);
        canvas.drawRect(rect, paint);
    }

    private void canvasByRotate(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        canvas.rotate(40);
        Rect rect = new Rect(110, 110, 400, 400);
        canvas.drawRect(rect, paint);
    }

    /**
     * 画布到保存和恢复   canvas.save();  canvas.restore();
     * @param canvas
     */
    private void canvasBySaveAndRestore(Canvas canvas) {
        canvas.drawColor(Color.RED); //全屏
        canvas.save();

        canvas.clipRect(new Rect(100, 100, 800, 800));
        canvas.drawColor(Color.BLACK);
        canvas.save();

        canvas.clipRect(new Rect(200, 200, 700, 700));
        canvas.drawColor(Color.BLUE);
        canvas.save();

        canvas.clipRect(new Rect(300, 300, 600, 600));
        canvas.drawColor(Color.GREEN);
        canvas.save();  //先进后出

        canvas.restore(); //从栈顶取一个之前save 画布
        canvas.restore();
        canvas.drawColor(Color.RED);
    }

    float mLastX = 0;
    float mLastY = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       /* float x = event.getRawX();
        float y = event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                float diffX = x - mLastX;
                float diffY = y - mLastY;

                float translationX = this.getTranslationX() + diffX;
                float translationY = this.getTranslationY() + diffY;
                this.setTranslationX(translationX);
                this.setTranslationY(translationY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        mLastY = x;
        mLastY = y;*/
        return super.onTouchEvent(event);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);

    }

    /**
     * Created from 2017/11/3 23:09
     * Author jackyang
     * ------------------
     * @desc 测试弹性滑动
     * @param
     * @return
     */
   /* private void testScroller(){
        Scroller scroller = new Scroller(getContext());
        scroller.startScroll();
    }*/

    @Override
    public void computeScroll() {
        super.computeScroll();
    }

    /**
     * Created from 2017/11/1 21:49
     * Author jackyang
     * ------------------
     * @desc 绘制不规则的区域 region
     * @param
     * @return
     */
    private void drawOnAnomaly(Canvas canvas) {
        //初始化Paint
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        //构造一个椭圆路径
        Path ovalPath = new Path();
        RectF rect =  new RectF(50, 50, 200, 500);
        float x = rect.centerX();
        float y = rect.centerY();
        canvas.drawRect(rect, paint);
        ovalPath.addOval(rect, Path.Direction.CW);

        canvas.drawPath(ovalPath, paint);

        paint.setColor(Color.BLACK);
        //SetPath时,传入一个比椭圆区域小的矩形区域,让其取交集
        Region rgn = new Region();
        rgn.setPath(ovalPath, new  Region(50, 50, 200, 200));
        //画出路径
        //drawRegion(canvas, rgn, paint);


    }

    /**
     * Created from 2017/11/1 23:15
     * Author jackyang
     * ------------------
     * @desc
     * @param
     * @return
     */
    private void testCanvas(Canvas canvas) {
        Bitmap b = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
        Canvas temp = new Canvas(b);
        Paint paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.RED);
        temp.drawText("kfjkdjfd", 0, 100, paint);

        canvas.drawBitmap(b, 0, 0, paint);
    }


    /**
     * Created from 2017/11/1 21:50
     * Author jackyang
     * ------------------
     * @desc  RegionIterator类，实现了获取组成区域的矩形集的功能
     * @param
     * @return
     */
    private void drawRegion(Canvas canvas, Region rgn, Paint paint) {
        RegionIterator regions = new RegionIterator(rgn);
        Rect rect = new Rect();
        while (regions.next(rect)) {
            canvas.drawRect(rect, paint);
        }
    }

}
