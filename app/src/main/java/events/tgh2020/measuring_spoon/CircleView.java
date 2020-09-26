package events.tgh2020.measuring_spoon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CircleView extends View {
    Paint paint;
    private Boolean small;
    private Boolean base =true;

    public CircleView(Context context, boolean bool) {
        super(context);
        paint = new Paint();
        small = bool;
    }

    public void showCircle(){
        base = false;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float density = getContext().getResources().getDisplayMetrics().density;

        double size; //trueが小さじ、falseが大さじ
        if (small){
            size = 1;
        }else {
            size = 1.442;
        }

        paint.setAntiAlias(true);
        if(base){
            paint.setColor(Color.argb(255, 192, 192, 192));
            canvas.drawCircle(180*density, 180*density, (float) (110*density*size), paint);
            paint.setColor(Color.argb(255,153, 153, 153));
        }else{
            paint.setColor(Color.WHITE);
        }
        canvas.drawCircle(180*density, 180*density,(float) (103*density*size), paint);
    }
}
