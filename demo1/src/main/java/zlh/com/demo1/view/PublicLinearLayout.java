package zlh.com.demo1.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import zlh.com.demo1.MainActivity;
import zlh.com.demo1.R;

/**
 * Time:${Data}
 * <p>
 * Author:Lenovo
 * <p>
 * Description:自定义view组合控件
 */
public class PublicLinearLayout extends LinearLayout implements View.OnClickListener {

    private EditText edit_text;
    private TextView text_view;

    MainActivity activity;
    public PublicLinearLayout(Context context) {
        super(context);
    }

    public PublicLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        activity= (MainActivity) context;
        View view=LayoutInflater.from(context).inflate(R.layout.p_layout,this);
        edit_text = view.findViewById(R.id.ed_id);
        text_view = view.findViewById(R.id.searc_id);
        edit_text.setOnClickListener(this);
        text_view.setOnClickListener(this);
    }

    public PublicLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ed_id:
                break;
            case R.id.searc_id:
                String count=edit_text.getText().toString();
                TextView textView=new TextView(activity);
                textView.setText(count);
                activity.flowLayout.addView(textView);
                break;
        }
    }
}
