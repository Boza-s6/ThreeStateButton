package bozovic.nemanja.threestatebutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/**
 * Created by nemanja on 10/20/15.
 */
public class ThreeStateButton extends ToggleButton {
    private Drawable mInitial;
    private Drawable mClicked;
    private Drawable mUnclicked;
    private int mColorInitial;
    private int mColorClicked;
    private int mColorUnclicked;
    private String mTextInitial;
    private String mTextClicked;
    private String mTextUnclicked;

    private State mCurrentState; //0, 1, 2

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ThreeStateButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ThreeStateButton);

        mInitial = a.getDrawable(R.styleable.ThreeStateButton_drawableInitial);
        mClicked = a.getDrawable(R.styleable.ThreeStateButton_drawableClicked);
        mUnclicked = a.getDrawable(R.styleable.ThreeStateButton_drawableUnclicked);

        mColorInitial = a.getColor(R.styleable.ThreeStateButton_textColorInitial, 0);
        mColorClicked = a.getColor(R.styleable.ThreeStateButton_textColorClicked, 0);
        mColorUnclicked = a.getColor(R.styleable.ThreeStateButton_textColorUnClicked, 0);

        mTextInitial = a.getString(R.styleable.ThreeStateButton_textInitial);
        mTextClicked = a.getString(R.styleable.ThreeStateButton_textClicked);
        mTextUnclicked = a.getString(R.styleable.ThreeStateButton_textUnClicked);

        a.recycle();

        mCurrentState = State.INITIAL;

        setState(mCurrentState);
    }

    public ThreeStateButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ThreeStateButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ThreeStateButton(Context context) {
        this(context, null);
    }

    public State getState() {
        return mCurrentState;
    }

    public void setState(State state) {
        mCurrentState = state;
        switch (mCurrentState) {
            case INITIAL:
                setTopDrawable(mInitial);
                setTextColor(mColorInitial);
                setText(mTextInitial);
                break;
            case CLICKED:
                setTopDrawable(mClicked);
                setTextColor(mColorClicked);
                setText(mTextClicked);
                break;
            case UNCLICKED:
                setTopDrawable(mUnclicked);
                setTextColor(mColorUnclicked);
                setText(mTextUnclicked);
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setTopDrawable(Drawable drawable) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawable, null, null);
    }

    public enum State {
        INITIAL,
        CLICKED,
        UNCLICKED
    }
}
