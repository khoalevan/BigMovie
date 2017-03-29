package dagger2simple.android.vogella.com.bigmovie.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import dagger2simple.android.vogella.com.bigmovie.R;


/**
 * Created by khoalevan on 3/29/17.
 */

public final class AnimatorStateView extends LinearLayout {
    @Bind(R.id.message_view_image)
    ImageView mImageView;
    @Bind(R.id.message_view_text)
    TextView mTextView;

    private View root;

    private AnimatorStateView(Context context) {
        super(context, null, 0);
        initialize(context, null, 0);
    }

    public AnimatorStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        initialize(context, attributeSet, 0);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyle) {
        root = LayoutInflater.from(context).inflate(R.layout.widget_animator_state, this, true);
        ButterKnife.bind(this, root);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AnimatorStateView, defStyle, 0);
    }
}
