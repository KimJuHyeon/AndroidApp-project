package com.example.user.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.hardware.Camera;

public class MainActivity extends AppCompatActivity {

    private Toast toast;
    private Vibrator vibrator;
    private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast = Toast.makeText(this, "토스트 메시지", Toast.LENGTH_LONG);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        camera = Camera.open();
     }

    @Override
    public void onDestroy() {
        super.onDestroy();
        camera.release();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show:
                toast.show();
                break;
            case R.id.btn_hide:
                toast.cancel();
                break;
            case R.id.btn_ring:
                vibrator.vibrate(3000);
                break;
            case R.id.btn_quit:
                vibrator.cancel();
                break;
            case R.id.btn_flash_on:
                Camera.Parameters param = camera.getParameters();
                param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(param);
                camera.startPreview();
                break;
            case R.id.btn_flash_off:
                Camera.Parameters param2 = camera.getParameters();
                param2.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(param2);
                camera.stopPreview();
                break;
        }
    }
}
