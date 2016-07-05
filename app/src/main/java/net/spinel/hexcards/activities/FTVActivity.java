package net.spinel.hexcards.activities;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;

import net.spinel.hexcards.R;

public class FTVActivity extends AppCompatActivity {
    private RelativeLayout rl_ftv;
    private ImageView iv_ftv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftv);

        rl_ftv = (RelativeLayout) this.findViewById(R.id.textftv);
        iv_ftv = (ImageView) this.findViewById(R.id.iv_ftv);
    }

    public void onFTV(View view){
        rl_ftv.setDrawingCacheEnabled(true);
        rl_ftv.buildDrawingCache();  //启用DrawingCache并创建位图
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache()); //创建一个DrawingCache的拷贝，因为DrawingCache得到的位图在禁用后会被回收
        rl_ftv.setDrawingCacheEnabled(false);
        iv_ftv.setImageBitmap(bitmap);
    }
}
