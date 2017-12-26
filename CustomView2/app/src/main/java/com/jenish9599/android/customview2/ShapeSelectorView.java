package com.jenish9599.android.customview2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by jenishpatel on 26/12/17.
 */

public class ShapeSelectorView extends View {


    private int shapeColor;
    private boolean displayShapeName;



    private int shapeWidth = 100;
    private int shapeHeight = 100;
    private int textXOffset = 0;
    private int textYOffset = 30;
    private Paint paintShape;

    private String[] shapeValues = { "square", "circle", "triangle" };
    private int currentShapeIndex = 0;







    public ShapeSelectorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupAttributes(attrs);
        setupPaint();

    }

    private void setupAttributes(AttributeSet attributeSet){
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.ShapeSelectorView, 0, 0);
        // Extract custom attributes into member variables
        try {
            shapeColor = a.getColor(R.styleable.ShapeSelectorView_shapeColor, Color.BLACK);
            displayShapeName = a.getBoolean(R.styleable.ShapeSelectorView_displayShapeName, false);

        } finally {
            // TypedArray objects are shared and must be recycled.
            a.recycle();
        }

    }



    public boolean isDisplayingShapeName() {
        return displayShapeName;
    }

    public void setDisplayingShapeName(boolean state) {
        this.displayShapeName = state;
        invalidate();
        requestLayout();
    }

    public int getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(int color) {
        this.shapeColor = color;
        invalidate();
        requestLayout();
    }


    private void setupPaint() {
        paintShape = new Paint();
        paintShape.setStyle(Paint.Style.FILL);
        paintShape.setColor(shapeColor);
        paintShape.setTextSize(30);
    }


    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        String shapeSelected = shapeValues[currentShapeIndex];
        if (shapeSelected.equals("square")) {
            canvas.drawRect(0, 0, shapeWidth, shapeHeight, paintShape);
            textXOffset = 0;
        } else if (shapeSelected.equals("circle")) {
            canvas.drawCircle(shapeWidth / 2, shapeHeight / 2, shapeWidth / 2, paintShape);
            textXOffset = 12;
        } else if (shapeSelected.equals("triangle")) {
            canvas.drawPath(getTrianglePath(), paintShape);
              textXOffset = 0;
        }
        if (displayShapeName) {
            canvas.drawText(shapeSelected, 0 + textXOffset, shapeHeight + textYOffset, paintShape);
        }


    }

    protected Path getTrianglePath() {
        Point p1 = new Point(0, shapeHeight), p2 = null, p3 = null;
        p2 = new Point(p1.x + shapeWidth, p1.y);
        p3 = new Point(p1.x + (shapeWidth / 2), p1.y - shapeHeight);
        Path path = new Path();
        path.moveTo(p1.x, p1.y);
        path.lineTo(p2.x, p2.y);
        path.lineTo(p3.x, p3.y);
        return path;
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int textPadding = 10;
        int contentWidth = shapeWidth;


        int minw = contentWidth + getPaddingLeft() + getPaddingRight();
        int w = resolveSizeAndState(minw, widthMeasureSpec, 0);


        int minh = shapeHeight + getPaddingBottom() + getPaddingTop();
        if (displayShapeName) {
            minh += textYOffset + textPadding;
        }
        int h = resolveSizeAndState(minh, heightMeasureSpec, 0);



        setMeasuredDimension(w, h);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            currentShapeIndex =  (currentShapeIndex ++) % shapeValues.length;
            postInvalidate();

            Toast.makeText(getContext(),"TochEvent",Toast.LENGTH_SHORT).show();
            return true;
        }

        return  super.onTouchEvent(event);

    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        // Store base view state
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        // Save our custom view state to bundle
        bundle.putInt("currentShapeIndex", this.currentShapeIndex);
        // ... store any other custom state here ...
        // Return the bundle
        return bundle;

    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if(state instanceof Bundle){
            Bundle bundle = (Bundle) state;
            // Load back our custom view state
            this.currentShapeIndex = bundle.getInt("currentShapeIndex");
            // ... load any other custom state here ...
            // Load base view state back
            state = bundle.getParcelable("instanceState");

        }

        super.onRestoreInstanceState(state);

    }
}
