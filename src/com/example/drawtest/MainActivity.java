package com.example.drawtest;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		image = (ImageView) findViewById(R.id.image);

//		Bitmap bit = buildRadom();
		Bitmap bit = buildCycles();
		System.out.println("test merage");
		image.setImageBitmap(bit);
	}

	private Bitmap buildRadom() {
		Bitmap bit = Bitmap.createBitmap(720, 1280, Config.ARGB_8888);
		Canvas c = new Canvas(bit);
		Paint paint = new Paint();
		paint.setStyle(Style.STROKE);
//		paint.setAntiAlias(true);
		paint.setStrokeWidth(1);
		paint.setTextSize(60);

		Rect rect = new Rect(0, 0, 600, 300);
		c.drawRect(rect, paint);
		paint.setStyle(Style.FILL);
		c.drawText("4 5 9 3", rect.centerX() - 60, rect.centerY(), paint);
		Random rx = new Random();
		Random ry = new Random();
		paint.setColor(Color.RED);
		Point p1 = new Point(rx.nextInt(600), ry.nextInt(300));
		Point p2 = new Point(rx.nextInt(600), ry.nextInt(300));
//		c.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
		for (int i = 0; i < 100; i++) {
			c.drawLine(p1.x, p1.y, p2.x, p2.y, paint);
			System.out.println(p1 + "---" + p2);
			p1.set(rx.nextInt(600), ry.nextInt(300));
			p2.set(rx.nextInt(600), ry.nextInt(300));
		}

//		final int offsetDy = 50;
//		for(int i = 0; i < 5; i ++){
//		c.drawLine(10, offsetDy * i, 300, offsetDy * i, paint);
//		}
		return bit;
	}

	private Bitmap buildCycles() {
		Bitmap bit = Bitmap.createBitmap(720, 1280, Config.ARGB_8888);
		Canvas c = new Canvas(bit);
		Paint paint = new Paint();
		paint.setStyle(Style.FILL_AND_STROKE);
		paint.setAntiAlias(true);
		paint.setStrokeWidth(1);
		Point start = new Point(20, 20);
		int radius = 20;
		Point temp = new Point(start);
		Random r = new Random();
		paint.setColor(r.nextInt());
		c.drawCircle(start.x, start.y, radius, paint);
		while (temp.x < 720 && temp.y < 1280) {
			if (temp.x + 2 * radius < 720) {
				temp.offset(2 * radius, 0);
			} else {
				temp.offset(-720, 2 * radius);
			}
			paint.setColor(r.nextInt());
			c.drawCircle(temp.x, temp.y, radius, paint);

		}
		return bit;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
