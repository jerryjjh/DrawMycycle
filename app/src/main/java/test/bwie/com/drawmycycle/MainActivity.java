package test.bwie.com.drawmycycle;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyCycle mycycle = (MyCycle) findViewById(R.id.mycycle);


        mycycle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int x = (int) event.getX();
                int y = (int) event.getY();

                //激活绘图缓存
                v.setDrawingCacheEnabled(true);

                //根据当前view的缓存转换为bitmap，并获取指定x，y轴的像素
                int pixel = Bitmap.createBitmap(v.getDrawingCache()).getPixel(x, y);
                //关闭绘图缓存
                int red = Color.red(pixel);
                int blue = Color.blue(pixel);
                int green = Color.green(pixel);
                v.setDrawingCacheEnabled(false);

                //判断该像素在颜色中值

                if (red != 0) {
                    Toast.makeText(MainActivity.this, "点击了大圆", Toast.LENGTH_SHORT).show();
                }
                if (blue != 0) {
                    Toast.makeText(MainActivity.this, "点击了大菱形", Toast.LENGTH_SHORT).show();
                }
                if (green != 0) {
                    Toast.makeText(MainActivity.this, "点击了小菱形", Toast.LENGTH_SHORT).show();
                }


                Log.i("xxx", "onTouch: x:" + x + " y:" + y + "  red:" + red + " blue:" + blue + " green:" + green);
                return true;
            }
        });
    }
}
