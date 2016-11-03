/*
 * Sprite.java
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
package batfai.samuentropy.brainboarda;

/**
 *
 * @author nbatfai
 */
public class Sprite {

    private android.graphics.Bitmap tiles;
    private int length;
    private int width;
    private int height;
    private int boxWidth;
    private int boxHeight;
    private int tileIndex = 0;
    private int x;
    private int y;
    private android.graphics.Rect from;
    private android.graphics.Rect to;
    static java.util.Random random = new java.util.Random();

    public Sprite(android.graphics.Bitmap tiles, int length, int width, int height, int boxWidth, int boxHeight) {
        this.tiles = tiles;
        this.length = length;
        this.width = width;
        this.height = height;
        this.boxWidth = boxWidth;
        this.boxHeight = boxHeight;
        from = new android.graphics.Rect(0, 0, width, height);
        to = new android.graphics.Rect(0, 0, width, height);

        java.util.Random r = new java.util.Random();

        tileIndex = random.nextInt(length) + 1;

        x = (random.nextInt(100) + 1) * 3;
        y = (random.nextInt(200) + 1) * 3;

    }

    public void step() {
        
        nextTile();
        
        int dx = 2 * random.nextInt(2) - 1;
        int dy = 2 * random.nextInt(2) - 1;

        x = Math.abs((x + dx) % (boxWidth-width));
        y = Math.abs((y + dy) % (boxHeight-height));

        setXY(x, y);
    }

    public void nextTile() {
        tileIndex = (tileIndex + 1) % length;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(float shiftx, float shifty, android.graphics.Canvas canvas) {

        int x = this.x + (int) shiftx;
        int y = this.y + (int) shifty;

        from.left = tileIndex * width;
        from.right = tileIndex * width + width;
        to.left = x;
        to.top = y;
        to.right = x + width;
        to.bottom = y + height;

        canvas.drawBitmap(tiles, from, to, null);

    }

}
