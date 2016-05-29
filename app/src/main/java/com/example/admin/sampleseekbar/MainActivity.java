package com.example.admin.sampleseekbar;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.SeekBar;


public class MainActivity extends Activity {

    private SeekBar seekBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawCanvas(this));
    }
}

class DrawCanvas extends SurfaceView {
    public DrawCanvas(Context context) {
        super(context);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    private final SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        // トラッキング開始時に呼び出されます
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Log.v("onStartTrackingTouch()",
                    String.valueOf(seekBar.getProgress()));
        }
        // トラッキング中に呼び出されます
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
            Log.v("onProgressChanged()",
                    String.valueOf(progress) + ", " + String.valueOf(fromTouch));
        }
        // トラッキング終了時に呼び出されます
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Log.v("onStopTrackingTouch()",
                    String.valueOf(seekBar.getProgress()));
        }
    };
}
