package dagger2simple.android.vogella.com.bigmovie.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.NoCopySpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import dagger2simple.android.vogella.com.bigmovie.R;

/**
 * Created by khoalevan on 4/1/2017.
 */

public final class AspectLockedImageView extends ImageView {

    private float aspectRatio = 0;
    private AspectRatioSource aspectRatioSource = null;

    public AspectLockedImageView(Context context) {
        super(context);
    }

    public AspectLockedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AspectLockedImageView);
        aspectRatio = a.getFloat(R.styleable.AspectLockedImageView_imageAspectRatio, 0);
        a.recycle();
    }

    public void setAspectRatioSource(View v) {
        this.aspectRatioSource = new ViewAspectRatioSource(v);
    }

    public void setAspectRatioSource(AspectRatioSource aspectRatioSource) {
        this.aspectRatioSource = aspectRatioSource;
    }

    public interface AspectRatioSource {
        int getWidth();

        int getHeight();
    }

    private static class ViewAspectRatioSource implements AspectRatioSource {
        private View v = null;

        ViewAspectRatioSource(View v) {
            this.v = v;
        }

        @Override
        public int getWidth() {
            return v.getWidth();
        }

        @Override
        public int getHeight() {
            return v.getHeight();
        }
    }
}
