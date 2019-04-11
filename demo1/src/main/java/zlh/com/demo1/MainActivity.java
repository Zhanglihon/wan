package zlh.com.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zlh.com.demo1.view.FlowLayout;

public class MainActivity extends AppCompatActivity {

    public FlowLayout flowLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flowLayout=findViewById(R.id.Flow_layout);
    }
}
