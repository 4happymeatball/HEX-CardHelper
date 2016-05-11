package net.spinel.hexcards;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by Spinel on 16/5/11.
 */
public class HEXApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DisplayImageOptions.Builder options = new DisplayImageOptions.Builder();
        options.showImageOnFail(R.mipmap.ic_launcher);
        options.cacheInMemory(true);
        options.cacheOnDisk(true);
        options.considerExifParams(true);
        options.bitmapConfig(Bitmap.Config.RGB_565);

        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(this);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024);
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.defaultDisplayImageOptions(options.build());

        ImageLoader.getInstance().init(config.build());
    }
}
