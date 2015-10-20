package bozovic.nemanja.threestatebutton;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private ThreeStateButton mButton;
    private ThreeStateButton mButton2;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (ThreeStateButton) findViewById(R.id.toggleButton);
        mButton2 = (ThreeStateButton) findViewById(R.id.toggleButton2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreeStateButton.State state = mButton.getState();

                if (state == ThreeStateButton.State.INITIAL) {
                    state = ThreeStateButton.State.CLICKED;
                } else if (state == ThreeStateButton.State.CLICKED) {
                    state = ThreeStateButton.State.UNCLICKED;
                } else {
                    state = ThreeStateButton.State.CLICKED;
                }

                mButton.setState(state);
                mButton2.setState(state);
            }
        });
    }
}
