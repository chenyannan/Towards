package com.waitou.towards.util.bindingadapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by waitou on 17/1/3.
 */

public class GlideBindingAdapter {

    /**
     * CenterCrop,FitCenter
     * CenterCrop,FitCenter都是对目标图片进行裁剪,了解过ImageView的ScaleType属性就知道,
     * 这2种裁剪方式在ImageView上也是有的,分别对应ImageView的ImageView.ScaleType.CENTER_CROP和mageView.ScaleType.FIT_CENTER的.
     * <p>
     * DiskCacheStrategy.NONE:什么都不缓存
     * DiskCacheStrategy.SOURCE:仅缓存原图(全分辨率的图片)
     * DiskCacheStrategy.RESULT:仅缓存最终的图片,即修改了尺寸或者转换后的图片
     * DiskCacheStrategy.ALL:缓存所有版本的图片,默认模式
     * <p>
     * 下载优先级
     * • Priority.LOW
     * • Priority.NORMAL
     * • Priority.HIGH
     * • Priority.IMMEDIATE
     * <p>
     * Glide.with(context)
     * .load(url)
     * .asBitmap() 强制处理成bitmap
     * .asGif() 指明了加载gif图，即使不指定Glide也会自己判断
     * .placeholder() 加载中显示的图片
     * .error()加载错误显示的图片
     * .crossFade()淡入显示，如果设置了这个则需要去掉asBitmap
     * .dontAnimte()直接显示图片
     * .override(80,80).//设置最终显示的图片像素为80*80,注意:这个是像素,而不是控件的宽高
     * .centerCrop().//中心裁剪,缩放填充至整个ImageView
     * .skipMemoryCache(true).//跳过内存缓存
     * .diskCacheStrategy(DiskCacheStrategy.RESULT).//保存最终图片
     * .thumbnail(0.1f).//10%的原图大小
     * .transform(new BlurTransformation(this)).//高斯模糊处理
     * .animate(R.anim.left_in).//加载xml文件定义的动画
     * <p>
     * 清理磁盘缓存 需要在子线程中执行
     * Glide.get(this).clearDiskCache();
     * 清理内存缓存  可以在UI主线程中进
     * Glide.get(this).clearMemory();
     */

    @BindingAdapter({"imageUrl", "placeholder", "error"})
    public static void loadImageFromUrl(ImageView view, String url, Drawable drawable, Drawable error) {
        Glide.with(view.getContext())
                .load(url)
                .crossFade()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .error(error)
                .placeholder(drawable)
                .into(view);
    }

    @BindingAdapter("imageUrl")
    public static void loadImageFromUrl(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .crossFade()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(view);
    }


    @BindingAdapter("load")
    public static void loadImageFromUrl(ImageView view, int drawable) {
        Glide.with(view.getContext())
                .load(drawable)
                .crossFade()
                .into(view);
    }
}
