package test.bwie.com.drawmycycle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/8
 */

public class MyCycle extends View {


    private Paint paint;

    public MyCycle(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(4);
        paint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        paint.setColor(Color.RED);
        canvas.drawCircle(width / 2, height / 2, 100, paint);
        paint.setColor(Color.BLUE);
        Path p1 = new Path();
        p1.moveTo(width / 2, height / 2 - 100);
        p1.lineTo(width / 2 + 100, height / 2);
        p1.lineTo(width / 2, height / 2 + 100);
        p1.lineTo(width / 2 - 100, height / 2);
        p1.close();
        canvas.drawPath(p1, paint);

        //在画个路径
        paint.setColor(Color.GREEN);
        Path p2 = new Path();
        p2.moveTo((width / 2 + (width / 2 + 100)) / 2, ((height / 2 - 100) + height / 2) / 2);
        p2.lineTo(((width / 2 + 100) + width / 2) / 2, ((height / 2 + 100) + height / 2) / 2);
        p2.lineTo((width / 2 + (width / 2 - 100)) / 2, ((height / 2 + 100) + height / 2) / 2);
        p2.lineTo(((width / 2 - 100) + width / 2) / 2, (height / 2 + (height / 2 - 100)) / 2);
        p2.close();
        canvas.drawPath(p2, paint);
    }
}
