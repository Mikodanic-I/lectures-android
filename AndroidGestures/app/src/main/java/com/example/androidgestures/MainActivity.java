package com.example.androidgestures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.gesture.Gesture;

import android.view.GestureDetector.*;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private TextView gesturePreview;
    private GestureDetectorCompat gDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gesturePreview = (TextView)findViewById(R.id.gesturePreview);

        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        gDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        gDetector.setOnDoubleTapListener(this);
    }

    private void setPreviewText(String name) {
        int stringID = getResources().getIdentifier(name, "string", MainActivity.this.getPackageName());
        String translatedString = getResources().getString(stringID);

        gesturePreview.setText(translatedString);
    }

    // Gesture callbacks
    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        setPreviewText("down");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
        setPreviewText("fling");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        setPreviewText("long_press");
    }

    @Override
    public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX, float distanceY) {
        setPreviewText("scroll");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        setPreviewText("show_press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        setPreviewText("single_tap_up");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        setPreviewText("double_tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        setPreviewText("double_tap_event");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        setPreviewText("single_tap_confirmed");
        return true;
    }
}