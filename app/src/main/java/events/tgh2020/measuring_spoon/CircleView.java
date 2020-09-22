package events.tgh2020.measuring_spoon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CircleView extends View {
    Paint paint;
    private Boolean size;

    public CircleView(Context context, boolean bool) {
        super(context);
        paint = new Paint();
        size=bool;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float density = getContext().getResources().getDisplayMetrics().density;

        double ratio;
        if (size){
            ratio = 1;
        }else {
            ratio = 1.442;
        }

        paint.setAntiAlias(true);
        paint.setColor(Color.argb(255, 192, 192, 192));
        canvas.drawCircle(180*density, 180*density, (float) (110*density*ratio), paint);
        paint.setColor(Color.argb(255,153, 153, 153));
        canvas.drawCircle(180*density, 180*density,(float) (103*density*ratio), paint);
    }
}
