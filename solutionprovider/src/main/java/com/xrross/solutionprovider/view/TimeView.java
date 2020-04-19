package com.xrross.solutionprovider.view;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

public class TimeView extends AppCompatTextView {

    private LinearGradient mLinearGradient;
    private Paint mPaint;
    private Paint ampmPaint;
    private Rect mTextBound = new Rect();
    private Rect ampmTextBound = new Rect();
    private Timer timer = new Timer();
    private int hour = 0;
    private int minute = 0;
    private int second = 0;
    private String contentText = "";
    private String am_pm;
    private boolean is24Format;

    private  Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 2:
                    refreshTime();
                    invalidate();
                    break;

            }
        }
    };

    public TimeView(Context context) {
        super(context);
        init();
    }

    public TimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        mPaint = getPaint();
        mPaint.setAntiAlias(true);
        mPaint.setTypeface(Typeface.SANS_SERIF);

        ampmPaint = new Paint();
        ampmPaint.setAntiAlias(true);
        ampmPaint.setColor(Color.WHITE);
        ampmPaint.setTypeface(Typeface.SANS_SERIF);
        ampmPaint.setTextSize(20);
        timer.schedule(timerTask,0,1000);
    }
    public String getAm_pm(){
        return am_pm;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int height = getMeasuredHeight();
        mPaint.getTextBounds(contentText, 0, contentText.length(), mTextBound);
        mLinearGradient = new LinearGradient(0, 0, 0, height,
                new int[] {  0xffff660a, 0xffd03c00 },
                null, Shader.TileMode.REPEAT);
        mPaint.setShader(mLinearGradient);
        float contentX = 0;
        if (is24Format){
            contentX = (getMeasuredWidth()-mTextBound.width())/2;
        }
        canvas.drawText(contentText, contentX, getMeasuredHeight()-8, mPaint);

        ampmPaint.getTextBounds(am_pm,0,am_pm.length(),ampmTextBound);
        canvas.drawText(am_pm,getMeasuredWidth()-ampmTextBound.width(),getMeasuredHeight()-8,ampmPaint);
    }

    private void refreshTime(){
        ContentResolver cv = getContext().getContentResolver();
        String strTimeFormat = Settings.System.getString(cv, Settings.System.TIME_12_24);
        is24Format = TextUtils.isEmpty(strTimeFormat)?true:strTimeFormat.equals("24");

        Calendar calendar = Calendar.getInstance();
        if (is24Format){
            am_pm = "";
            hour = calendar.get(Calendar.HOUR_OF_DAY);
        }else {
            if (calendar.get(Calendar.AM_PM) == 0) {
                am_pm = "AM";
            } else {
                am_pm = "PM";
            }
            hour = calendar.get(Calendar.HOUR);
        }
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        if (second%2 == 0){
            contentText = String.format("%02d",hour)+":"+String.format("%02d",minute);
        }else {
            contentText = String.format("%02d",hour)+" "+String.format("%02d",minute);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        final int minimumWidth = getSuggestedMinimumWidth();
//        final int minimumHeight = getSuggestedMinimumHeight();
        setMeasuredDimension(210, 80);
    }

    private int measureWidth(int defaultWidth, int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.AT_MOST:
                defaultWidth = (int) mPaint.measureText(contentText) + getPaddingLeft() + getPaddingRight();
                break;
            case MeasureSpec.EXACTLY:
                defaultWidth = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                defaultWidth = Math.max(defaultWidth, specSize);
        }
        return defaultWidth;
    }

    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            handler.sendEmptyMessage(2);
        }
    };

}
