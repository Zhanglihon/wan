package zlh.com.demo1.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:写这个类的作用
 */
public class FlowLayout extends ViewGroup {

    private int cheight;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
        int mLeft=20;
        int mTop=20;

        int sumLeft=20;
        int sumTop=20;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //先测量孩子的宽高
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        int cheight=0;
        for (int i=0;i<getChildCount();i++){
            int chwidth = getChildAt(i).getMeasuredWidth();
            cheight = getChildAt(i).getMeasuredHeight();
            //一上来就换行判断
            if (sumLeft+chwidth+mLeft>getMeasuredWidth()){
                //换行操作
                sumLeft=20;
                //累加高度
                sumTop+= cheight +mTop;
            }
            //累加左边距  和孩子的宽
            sumLeft+=chwidth+mLeft;
        }
        sumTop+=mTop+cheight;

        setMeasuredDimension(getMeasuredWidth(),sumTop);
    }

    @Override
    protected void onLayout(boolean changed, int l, int i1, int i2, int i3) {
        int mLeft=20;
        int mTop=20;

        int sumLeft=20;
        int sumTop=20;
        for (int j=0;j<getChildCount();j++){
            int chwidth = getChildAt(j).getMeasuredWidth();
            cheight = getChildAt(j).getMeasuredHeight();
            //一上来就换行判断
            if (sumLeft+chwidth+mLeft>getMeasuredWidth()){
                //换行操作
                sumLeft=20;
                //累加高度
                sumTop+= cheight +mTop;

                getChildAt(j).layout(sumLeft,sumTop,sumLeft+chwidth,sumTop+cheight);
            }
            getChildAt(j).layout(sumLeft,sumTop,sumLeft+chwidth,sumTop+cheight);
            //累加左边距  和孩子的宽
            sumLeft+=chwidth+mLeft;
        }
    }
}
