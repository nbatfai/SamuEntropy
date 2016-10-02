/*
 * NorbironSurfaceView.java
 *
 * Norbiron Game
 * This is a case study for creating sprites for SamuEntropy/Brainboard.
 *
 * Copyright (C) 2016, Dr. Bátfai Norbert
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Ez a program szabad szoftver; terjeszthető illetve módosítható a
 * Free Software Foundation által kiadott GNU General Public License
 * dokumentumában leírtak; akár a licenc 3-as, akár (tetszőleges) későbbi
 * változata szerint.
 *
 * Ez a program abban a reményben kerül közreadásra, hogy hasznos lesz,
 * de minden egyéb GARANCIA NÉLKÜL, az ELADHATÓSÁGRA vagy VALAMELY CÉLRA
 * VALÓ ALKALMAZHATÓSÁGRA való származtatott garanciát is beleértve.
 * További részleteket a GNU General Public License tartalmaz.
 *
 * A felhasználónak a programmal együtt meg kell kapnia a GNU General
 * Public License egy példányát; ha mégsem kapta meg, akkor
 * tekintse meg a <http://www.gnu.org/licenses/> oldalon.
 *
 * Version history:
 *
 * 0.0.1, 2013.szept.29.
 */
package batfai.samuentropy.brainboard4;

/**
 *
 * @author nbatfai
 */
public class NorbironSurfaceView extends android.view.SurfaceView implements Runnable {

    private float startsx = 0;
    private float startsy = 0;
    private float width = 2048;
    private float height = 2048;

    protected float swidth;
    protected float sheight;

    protected float fromsx;
    protected float fromsy;

    protected float boardx = 0;
    protected float boardy = 0;

    private android.graphics.Bitmap boardPic;
    private android.graphics.Bitmap neuronSprite;
    private NeuronBox[] neuronBox;

    private android.view.SurfaceHolder surfaceHolder;
    private android.view.ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.0f;

    private boolean running = true;

    public void setScaleFactor(float scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public NorbironSurfaceView(android.content.Context context) {
        super(context);

        cinit(context);

    }

    public NorbironSurfaceView(android.content.Context context,
            android.util.AttributeSet attrs) {
        super(context, attrs);

        cinit(context);

    }

    public NorbironSurfaceView(android.content.Context context,
            android.util.AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        cinit(context);

    }

    @Override
    protected void onSizeChanged(int newx, int newy, int x, int y) {

        super.onSizeChanged(newx, newy, x, y);

        width = newx;
        height = newy;

        swidth = width / 2 - boardPic.getWidth() / 2;
        sheight = height / 2 - boardPic.getHeight() / 2;

    }

    private void cinit(android.content.Context context) {

        surfaceHolder = getHolder();

        surfaceHolder.addCallback(new SurfaceEvents(this));

        int resId = getResources().getIdentifier("pcb550i", "drawable",
                "batfai.samuentropy.brainboard4");

        boardPic = android.graphics.BitmapFactory.decodeResource(getResources(), resId);

        resId = getResources().getIdentifier("neuronsprite", "drawable",
                "batfai.samuentropy.brainboard4");

        neuronSprite = android.graphics.BitmapFactory.decodeResource(getResources(), resId);

        neuronSprite = android.graphics.Bitmap.createScaledBitmap(neuronSprite, 50 * 7, 48, false);

        neuronBox = new NeuronBox[3];
        neuronBox[0] = new NeuronBox(neuronSprite, 7, 50, 48, 100, 100, 200, 100, 100);
        neuronBox[1] = new NeuronBox(neuronSprite, 7, 50, 48, 10, 100, 200, 250, 100);
        neuronBox[2] = new NeuronBox(neuronSprite, 7, 50, 48, 15, 100, 200, 400, 100);

        scaleGestureDetector = new android.view.ScaleGestureDetector(context, new ScaleAdapter(this));

    }

    @Override
    public void onDraw(android.graphics.Canvas canvas) {

        if (surfaceHolder.getSurface().isValid()) {

            canvas.save();
            canvas.scale(scaleFactor, scaleFactor);

            canvas.drawColor(android.graphics.Color.BLACK);

            canvas.drawBitmap(boardPic, -startsx + boardx, -startsy + boardy, null);

            for (int i = 0; i < neuronBox.length; ++i) {
                neuronBox[i].draw(-startsx, -startsy, canvas);
            }

            canvas.restore();
        }
    }

    public void repaint() {

        android.graphics.Canvas canvas = null;
        try {
            canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                onDraw(canvas);
            }

        } finally {

            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

        }
    }

    @Override
    public boolean onTouchEvent(android.view.MotionEvent event) {

        scaleGestureDetector.onTouchEvent(event);

        float x = event.getX() / scaleFactor;
        float y = event.getY() / scaleFactor;

        if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {

            fromsx = x;
            fromsy = y;

        } else if (event.getAction() == android.view.MotionEvent.ACTION_POINTER_DOWN) {

        } else if (event.getAction() == android.view.MotionEvent.ACTION_CANCEL) {

        } else if (event.getAction() == android.view.MotionEvent.ACTION_MOVE) {

            startsx += (fromsx - x);
            startsy += (fromsy - y);

            fromsx = x;
            fromsy = y;

            repaint();

        } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {

            fromsx = x;
            fromsy = y;

        }

        return true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        long now = System.currentTimeMillis(), newnow;
        float spritex = 0;
        running = true;
        while (running) {

            if ((newnow = System.currentTimeMillis()) - now > 100) {

                for (int i = 0; i < neuronBox.length; ++i) {
                    neuronBox[i].step();
                }

                repaint();

                now = newnow;
            }

        }

    }
}
