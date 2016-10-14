/*
 * NeuronBox.java
 *
 * Norbiron Board
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
 * 0.0.1, 6 Oct 16.
 */
package batfai.samuentropy.brainboard8;

/**
 *
 * @author nbatfai
 */
public class NeuronBox implements Cloneable {

    private Sprite[] neurons;

    private android.graphics.Bitmap tiles;
    private android.graphics.Bitmap cover;
    android.graphics.Rect to;
    private int boxWidth;
    private int boxHeight;
    private int x;
    private int y;
    int numberOfNeurons;
    protected static android.graphics.Paint boxPaint = new android.graphics.Paint();
    protected static android.graphics.Paint selectedBoxPaint = new android.graphics.Paint();
    protected int selectedBoxPaintSize = 0;

    protected boolean open = false;
    protected boolean selected = false;

    private int type = 1;

    public NeuronBox(android.graphics.Bitmap tiles, int length, int width, int height,
            int numberOfNeurons,
            android.graphics.Bitmap cover, int x, int y) {
        this.x = x;
        this.y = y;
        this.tiles = tiles;

        this.cover = cover;
        this.boxWidth = cover.getWidth();
        this.boxHeight = cover.getHeight();

        to = new android.graphics.Rect(0, 0, boxWidth, boxHeight);

        this.numberOfNeurons = numberOfNeurons;

        boxPaint.setColor(android.graphics.Color.argb(0xaf, 0xc4, 0xd9,
                0xbf));
        boxPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        boxPaint.setAntiAlias(true);
        boxPaint.setStrokeWidth(55);
        boxPaint.setAlpha(170);

        selectedBoxPaint.setColor(android.graphics.Color.argb(0x8f, 0x44, 0xd9,
                0xbf));
        selectedBoxPaint.setStyle(android.graphics.Paint.Style.STROKE);
        selectedBoxPaint.setAntiAlias(true);
        selectedBoxPaint.setStrokeWidth(1);

        neurons = new Sprite[numberOfNeurons];
        for (int i = 0; i < neurons.length; ++i) {
            neurons[i] = new Sprite(tiles, length, width, height, boxWidth, boxHeight);
        }
    }

    public Object clone() {

        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            java.util.logging.Logger.getLogger(NeuronBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        return null;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setCover(boolean open) {
        this.open = open;
    }

    public boolean getCover() {
        return open;
    }

    public int getWidth() {
        return boxWidth;
    }

    public int getHeight() {
        return boxHeight;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(float x, float y) {
        this.x = (int) x;
        this.y = (int) y;
    }

    public void draw(float shiftx, float shifty, android.graphics.Canvas canvas) {

        for (int i = 0; i < neurons.length; ++i) {
            neurons[i].draw(x + shiftx, y + shifty, canvas);
        }

        canvas.drawRect(x + shiftx, y + shifty, x + shiftx + boxWidth, y + shifty + boxHeight, boxPaint);

        if (!open) {
            to.left = x + (int) shiftx;
            to.top = y + (int) shifty;
            to.right = to.left + boxWidth;
            to.bottom = to.top + boxHeight;
            canvas.drawBitmap(cover, null, to, null);
        }

        if (selected) {

            selectedBoxPaintSize = (selectedBoxPaintSize + 3) % 12;
            selectedBoxPaint.setStrokeWidth(1 + selectedBoxPaintSize);

            canvas.drawRect(x + shiftx - selectedBoxPaintSize,
                    y + shifty - selectedBoxPaintSize,
                    x + shiftx + boxWidth + 2 * selectedBoxPaintSize,
                    y + shifty + boxHeight + 2 * selectedBoxPaintSize, selectedBoxPaint);

        }

    }

    public void step() {

        for (int i = 0; i < neurons.length; ++i) {
            neurons[i].step();
        }

    }

}
