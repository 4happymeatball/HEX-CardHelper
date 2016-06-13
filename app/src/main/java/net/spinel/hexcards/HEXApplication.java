package net.spinel.hexcards;

import android.app.Application;
import android.content.SharedPreferences;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import net.spinel.hexcards.utils.DBManager;

/**
 * Created by Spinel on 16/5/11.
 */
public class HEXApplication extends Application {
    public static final int SET1_COUNT = 394;
    public static final int SET2_COUNT = 280;
    public static final int SET3_COUNT = 274;

    @Override
    public void onCreate() {
        super.onCreate();

        if (!isDBExist()) {
            DBManager manager = new DBManager(this);
            manager.openDatabase();
            manager.closeDatabase();
            SharedPreferences.Editor editor = getSharedPreferences("info", MODE_PRIVATE).edit();
            editor.putBoolean("db_exist", true);
            editor.apply();
        }

        DisplayImageOptions.Builder options = new DisplayImageOptions.Builder();
        options.showImageOnFail(R.drawable.no_pic);
        options.cacheInMemory(true);
        options.cacheOnDisk(true);
        options.considerExifParams(true);

        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(this);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024);
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.defaultDisplayImageOptions(options.build());

        ImageLoader.getInstance().init(config.build());
    }

    private boolean isDBExist() {
        SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
        return sp.getBoolean("db_exist", false);
    }
}
