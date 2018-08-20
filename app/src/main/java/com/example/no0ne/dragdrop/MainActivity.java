package com.example.no0ne.dragdrop;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.targetTextView);

        textView1.setOnLongClickListener(longClickListener);
        textView2.setOnLongClickListener(longClickListener);
        textView3.setOnLongClickListener(longClickListener);

        textView4.setOnDragListener(dragListener);
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");

            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);

            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            final View view = (View) event.getLocalState();

            int dragEvent = event.getAction();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:

                    if (view.getId() == R.id.textView1) {
                        textView4.setText("TextView 1 Is Entered");
                    } else if (view.getId() == R.id.textView2) {
                        textView4.setText("TextView 2 Is Entered");
                    } else {
                        textView4.setText("TextView 3 Is Entered");
                    }

                    break;
                case  DragEvent.ACTION_DRAG_EXITED:

                    if (view.getId() == R.id.textView1) {
                        textView4.setText("TextView 1 Is Exited");
                    } else if (view.getId() == R.id.textView2) {
                        textView4.setText("TextView 2 Is Exited");
                    } else {
                        textView4.setText("TextView 3 Is Exited");
                    }

                    break;
                case DragEvent.ACTION_DROP:

                    if (view.getId() == R.id.textView1) {
                        textView4.setText("TextView 1 Is Dropped");
                    } else if (view.getId() == R.id.textView2) {
                        textView4.setText("TextView 2 Is Dropped");
                    } else {
                        textView4.setText("TextView 3 Is Dropped");
                    }

                    //view.animate().x(textView4.getX()).y(textView4.getY()).setDuration(1000).start();

                    break;
            }

            return true;
        }
    };
}
