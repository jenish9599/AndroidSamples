package com.jenish9599.android.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jenishpatel on 22/12/17.
 */

public class SimpleDrawingView extends View {

    private final int paitColor = Color.BLACK;

    private Paint dwarPaint;

    private Path path;


    private List<Point> circlePoints;
    public SimpleDrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupPaint();
        circlePoints = new ArrayList<>();
        path = new Path();
    }


    private void setupPaint(){
        dwarPaint = new Paint();
        dwarPaint.setColor(paitColor);
        dwarPaint.setAntiAlias(true);
        dwarPaint.setStrokeWidth(5);

        dwarPaint.setStrokeJoin(Paint.Join.ROUND);
        dwarPaint.setStrokeCap(Paint.Cap.ROUND);
        dwarPaint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, dwarPaint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            default:
                return false;
        }

        postInvalidate();
        return true;
    }
}
