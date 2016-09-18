package yyydjk.com.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/9/18 0018.
 */

public class CouponViewHelper {

    private Context context;

    private View view;

    //半圆画笔
    private Paint semicirclePaint;

    //虚线画笔
    private Paint dashLinePaint;

    //半圆之间间距
    private float semicicleGap = 4;

    //半圆半径
    private float semicircleRadius = 4;

    //半圆颜色
    private int semicircleColor = 0xffffff;

    //半圆数量X
    private int semicircleNumX;

    //半圆数量Y
    private int semicircleNumY;

    //绘制半圆曲线后X轴剩余距离
    private int remindSemicircleX;

    //绘制半圆曲线后Y轴剩余距离
    private int remindSemicircleY;

    //虚线的长度
    private float dashLineLength = 8;

    //虚线的间距
    private float dashLineGap = 4;

    //虚线的颜色
    private int dashLineColor = 0xffffff;

    //绘制虚线后X轴剩余距离
    private float remindDashLineX;

    //绘制虚线后Y轴剩余距离
    private float remindDashLineY;

    //虚线数量X
    private int dashLineNumX;

    //半圆数量Y
    private int dashLineNumY;

    //开启顶部半圆曲线
    private boolean isTopSemicircle;

    //开启底部半圆曲线
    private boolean isBottomSemicircle;

    //开启左边半圆曲线
    private boolean isLeftSemicircle;

    //开启左边半圆曲线
    private boolean isRightSemicircle;

    //开启顶部虚线
    private boolean isTopDashLine;

    //开启底部虚线
    private boolean isBottomDashLine;

    //开启左边虚线
    private boolean isLeftDashLine;

    //开启左边虚线
    private boolean isRightDashLine;


    public CouponViewHelper(View view, Context context, AttributeSet attrs, int defStyle) {
        this.context = context;
        this.view = view;
        TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.CouponView, defStyle, 0);

        a.recycle();
        init();

    }

    private void init() {
        semicirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        semicirclePaint.setDither(true);
        semicirclePaint.setColor(semicircleColor);
        semicirclePaint.setStyle(Paint.Style.FILL);

        dashLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dashLinePaint.setDither(true);
        dashLinePaint.setColor(dashLineColor);
        dashLinePaint.setStyle(Paint.Style.FILL);
    }

    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (isTopSemicircle && remindSemicircleX == 0 || isBottomSemicircle && remindSemicircleX == 0) {
            remindSemicircleX = (w - dp2Px(semicicleGap)) % (2 * dp2Px(semicircleRadius) + dp2Px(semicicleGap));
            semicircleNumX = (w - dp2Px(semicicleGap)) / (2 * dp2Px(semicircleRadius) + dp2Px(semicicleGap));
        }

        if (isLeftSemicircle && remindSemicircleY == 0 || isRightSemicircle && remindSemicircleY == 0) {
            remindSemicircleY = (h - dp2Px(semicicleGap)) % (2 * dp2Px(semicircleRadius) + dp2Px(semicicleGap));
            semicircleNumY = (h - dp2Px(semicicleGap)) / (2 * dp2Px(semicircleRadius) + dp2Px(semicicleGap));
        }

        if (isTopDashLine && remindDashLineX == 0 || isBottomDashLine && remindDashLineX == 0) {
            remindDashLineX = (w - dp2Px(dashLineGap - view.getPaddingLeft() - view.getPaddingRight()) % (dp2Px(dashLineLength) + dp2Px(dashLineGap)));
            dashLineNumX = (w - dp2Px(dashLineGap) - view.getPaddingLeft() - view.getPaddingRight()) / (dp2Px(dashLineLength) + dp2Px(dashLineGap));
        }

        if (isLeftDashLine && remindDashLineY == 0 || isRightDashLine && remindDashLineY == 0) {
            remindDashLineY = (h - dp2Px(dashLineGap) - view.getPaddingTop() - view.getPaddingBottom()) % (dp2Px(dashLineLength) + dp2Px(dashLineGap));
            dashLineNumY = (h - dp2Px(dashLineGap) - view.getPaddingTop() - view.getPaddingBottom()) / (dp2Px(dashLineLength) + dp2Px(dashLineGap));
        }

    }

    public void onDraw(Canvas canvas) {

    }

    private int dp2Px(float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    private int px2Dp(float px) {
        return (int) (px / context.getResources().getDisplayMetrics().density + 0.5f);
    }
}
