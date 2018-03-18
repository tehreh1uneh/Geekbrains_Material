package com.tehreh1uneh.geekbrains_material;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    private int themeIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            setNextThemeIndex();

            int themeId;
            switch (themeIndex) {
                case 0:
                    themeId = R.style.MyTheme_Yellow;
                    break;
                case 1:
                    themeId = R.style.MyTheme_Red;
                    break;
                default:
                    themeId = R.style.MyTheme_Yellow;
                    break;
            }
            setTheme(themeId);
            init();
        });
    }

    private void setNextThemeIndex() {
        themeIndex = themeIndex == 1 ? 0 : themeIndex + 1;
    }
}
