package com.etsy.android.grid.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * An {@link android.widget.ImageView} layout that maintains a consistent width to height aspect ratio.
 */
public class DynamicHeightImageView extends ImageView {

    private double mHeightRatio;
    public static float radius = 2.0f;  
    
    Path clipPath = new Path();
    RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
    
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public DynamicHeightImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
		if (Build.VERSION.SDK_INT < 18) {
			this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}
    }

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public DynamicHeightImageView(Context context) {
        super(context);
		if (Build.VERSION.SDK_INT < 18) {
			this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}
    }

    public void setHeightRatio(double ratio) {
        if (ratio != mHeightRatio) {
            mHeightRatio = ratio;
            requestLayout();
        }
    }

    public double getHeightRatio() {
        return mHeightRatio;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mHeightRatio > 0.0) {
            // set the image views size
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = (int) (width * mHeightRatio);
            setMeasuredDimension(width, height);
        }
        else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
    
	@Override
	protected void onDraw(Canvas canvas) {
		rect.left = 0;
		rect.top = 0;
		rect.right = this.getWidth();
		rect.bottom = this.getHeight();
		clipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
		canvas.clipPath(clipPath);
		super.onDraw(canvas);
	}
}
