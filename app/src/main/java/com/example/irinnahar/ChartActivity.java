package com.example.irinnahar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class ChartActivity extends AppCompatActivity {
    private ImageView reusableImageView;
    TextView textViewTitle;


    //variable initializaion
    private int startx = 100;
    private int starty = 100;
    private int endx = 300;
    private int endy = 300;


    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        //creating a bitmap as content view for the image
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        canvas = new Canvas(bitmap);
        //set the background for your drawings
        canvas.drawColor(Color.BLACK); //background
        //setup the image

        //setup the image view
        reusableImageView = (ImageView)findViewById(R.id.ImageViewForDrawing);
        //tell image view for the bitmap format/content
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);
        //create the paint for our drawings
        paint = new Paint();
        textViewTitle  = (TextView) findViewById(R.id.titleChart);
        paint.setStrokeWidth(20);
        paint.setColor(Color.WHITE);

        Bundle extras = getIntent().getExtras();
        String message = null;
        if (extras != null) {
            message = getIntent().getStringExtra("chosenRegion");
            textViewTitle.setText( "Trends for: " + message);

            Context context=getApplicationContext();

            switch(message) {
                
                case "Toronto":
                    String[] toronto = context.getResources().getStringArray(R.array.Toronto);
                    int[] numArray = convertStringToInt(toronto);
                    paint.setColor(Color.MAGENTA);
                    draw(canvas,numArray);
                    break;

                case "Peel":
                    String[] peel = context.getResources().getStringArray(R.array.Peel);
                     numArray = convertStringToInt(peel);
                    paint.setColor(Color.RED);
                    draw(canvas,numArray);
                    break;

                case "Ottawa":
                    String[] ottawa = context.getResources().getStringArray(R.array.Ottawa);
                    numArray = convertStringToInt(ottawa);

                    paint.setColor(Color.GREEN);
                    draw(canvas,numArray);
                    break;

                case "Waterloo":
                    String[] waterloo = context.getResources().getStringArray(R.array.Waterloo);
                    numArray = convertStringToInt(waterloo);

                    paint.setColor(Color.YELLOW);
                    draw(canvas,numArray);
                    break;

                case "Hamilton":
                    String[] hamilton = context.getResources().getStringArray(R.array.Waterloo);
                    numArray = convertStringToInt(hamilton);

                    paint.setColor(Color.BLUE);
                    draw(canvas,numArray);
                    break;
            }
        }

    }

    public int[] convertStringToInt(String[] arrayStr){
        int[] numArray = new int[arrayStr.length];
        for (int i =0; i<arrayStr.length; i++){
            numArray[i] = Integer.parseInt(arrayStr[i]);
        }
        return numArray;
    }

    public void drawLine(Canvas canvas)
    {
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx = endx;
        starty = endy;

    }
    public void draw(Canvas canvas, int[] numArray){
        int x = 0, y = 0;
        for (int i=0; i<numArray.length; i++){
            // x = 0;
            y = numArray[i];
            //     endx = x;
            endy = y;
            drawLine(canvas);
        }
    }
}