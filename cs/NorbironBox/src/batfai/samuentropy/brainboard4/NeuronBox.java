/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batfai.samuentropy.brainboard4;

/**
 *
 * @author nbatfai
 */
public class NeuronBox {

    private Sprite[] neurons;

    private android.graphics.Bitmap tiles;
    private int boxWidth;
    private int boxHeight;
    private int x;
    private int y;
    int numberOfNeurons;
    private android.graphics.Rect from;
    private android.graphics.Rect to;
    private static android.graphics.Paint boxPaint = new android.graphics.Paint();

    public NeuronBox(android.graphics.Bitmap tiles, int length, int width, int height,
            int numberOfNeurons, int boxWidth, int boxHeight, int x, int y) {
        this.x = x;
        this.y = y;
        this.tiles = tiles;
        this.boxWidth = boxWidth;
        this.boxHeight = boxHeight;
        this.numberOfNeurons = numberOfNeurons;

        boxPaint.setColor(android.graphics.Color.argb(0xaf, 0xc4, 0xd9,
                0xbf));
        boxPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        boxPaint.setAntiAlias(true);
        boxPaint.setStrokeWidth(15);

        neurons = new Sprite[numberOfNeurons];
        for (int i = 0; i < neurons.length; ++i) {
            neurons[i] = new Sprite(tiles, length, width, height, boxWidth, boxHeight);
        }
    }

    public void draw(float shiftx, float shifty, android.graphics.Canvas canvas) {

        for (int i = 0; i < neurons.length; ++i) {
            neurons[i].draw(x + shiftx, y + shifty, canvas);
        }

        canvas.drawRect(x + shiftx, y + shifty, x + shiftx + boxWidth, y + shifty + boxHeight, boxPaint);

    }

    public void step() {

        for (int i = 0; i < neurons.length; ++i) {
            neurons[i].step();
        }

    }

}
