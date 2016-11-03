/*
 * NodeTypes.java
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
class NodeTypes {

    public final static int NODES_START = 2;

    private android.graphics.Bitmap boardPic;
    private android.graphics.Bitmap neuronSprite;
    private android.graphics.Bitmap nandIronProcCover;
    private static NeuronBox[] neuronBox;
    private static int[] neuronBoxResId;
    private static String[] neuronBoxTxtId;
    NorbironSurfaceView surfaceView;

    public NodeTypes(NorbironSurfaceView surfaceView) {

        this.surfaceView = surfaceView;

        int resId = surfaceView.getResources().getIdentifier("pcb550i", "drawable",
                "batfai.samuentropy.brainboarda");

        boardPic = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);

        boardPic = android.graphics.Bitmap.createScaledBitmap(boardPic, 300, 300, false);

        resId = surfaceView.getResources().getIdentifier("neuronsprite", "drawable",
                "batfai.samuentropy.brainboarda");

        neuronSprite = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);

        neuronSprite = android.graphics.Bitmap.createScaledBitmap(neuronSprite, 64 * 2 * 14, 62, false);

        neuronBox = new NeuronBox[15];
        neuronBoxResId = new int[15];
        neuronBoxTxtId = new String[15];

        resId = surfaceView.getResources().getIdentifier("buildproci", "drawable",
                "batfai.samuentropy.brainboarda");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 84, 98, false);

        neuronBox[0] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 1, nandIronProcCover, 0 + 30 + 35, 0 + 30 + 15 + 7);
        neuronBox[0].setType(-1);

        resId = surfaceView.getResources().getIdentifier("boxinproci", "drawable",
                "batfai.samuentropy.brainboarda");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 84, 98, false);

        neuronBox[1] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 1, nandIronProcCover, 0 + 30 + 35 + 84 + 30 + 35, 0 + 30 + 15 + 7);
        neuronBox[1].setType(0);

        resId = R.drawable.randnmproci;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[2] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);
        neuronBoxResId[2] = resId;
        neuronBoxTxtId[2] = "Random";

        resId = R.drawable.gaussnmproci;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[3] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);
        neuronBoxResId[3] = resId;
        neuronBoxTxtId[3] = "Gauss";

        resId = R.drawable.zeronmproci;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[4] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);
        neuronBoxResId[4] = resId;
        neuronBoxTxtId[4] = "Zero";

        resId = R.drawable.unifnmproci;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[5] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);
        neuronBoxResId[5] = resId;
        neuronBoxTxtId[5] = "Uniform";

        resId = R.drawable.addproci;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);
        neuronBox[6] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);
        neuronBoxResId[6] = resId;
        neuronBoxTxtId[6] = "Addition";

        resId = R.drawable.mulproci;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[7] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 100, 100);
        neuronBoxResId[7] = resId;
        neuronBoxTxtId[7] = "Multiplication";

        resId = R.drawable.nandironproci;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[8] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 25, nandIronProcCover, 100, 100);
        neuronBoxResId[8] = resId;
        neuronBoxTxtId[8] = "Neural net/NAND";

        resId = R.drawable.nandironproci2;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[9] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 50, nandIronProcCover, 350, 100);
        neuronBoxResId[9] = resId;
        neuronBoxTxtId[9] = "Neural net/NAND2";

        resId = R.drawable.matyironproci;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[10] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 25, nandIronProcCover, 600, 100);
        neuronBoxResId[10] = resId;
        neuronBoxTxtId[10] = "Neural net/MATY";

        resId = R.drawable.matyironproci2;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[11] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 50, nandIronProcCover, 100, 400);
        neuronBoxResId[11] = resId;
        neuronBoxTxtId[11] = "Neural net/MATY2";

        resId = R.drawable.gretironproci;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[12] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 25, nandIronProcCover, 350, 400);
        neuronBoxResId[12] = resId;
        neuronBoxTxtId[12] = "Neural net/GRET";

        resId = R.drawable.gretironproci2;

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[13] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 50, nandIronProcCover, 600, 400);
        neuronBoxResId[13] = resId;
        neuronBoxTxtId[13] = "Neural net/GRET2";

        resId = R.drawable.boxproci;
        // Custom box

        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[14] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 15, nandIronProcCover, 600, 400);
        neuronBoxResId[14] = resId;
        neuronBoxTxtId[14] = "Custom Box";

    }

    public android.graphics.Bitmap getBoardPic() {
        return boardPic;
    }

    public NeuronBox get(int i) {
        if (i < 0) {
            return neuronBox[-i - 1];
        } else if (i > 12) {
            return neuronBox[14];
        } else {
            return neuronBox[NODES_START + i];
        }

    }

    public int getResId(int i) {
        if (i < 0) {
            return neuronBoxResId[-i - 1];
        } else if (i > 12) {
            return neuronBoxResId[14];
        } else {
            return neuronBoxResId[NODES_START + i];
        }

    }

    public java.util.List<Integer> getNodeImgIds() {

        java.util.List<Integer> nodeImgIds = new java.util.ArrayList<Integer>();

        for (int i = NODES_START; i < 15; ++i) {
            nodeImgIds.add(neuronBoxResId[i]);
        }

        return nodeImgIds;
    }

    public java.util.List<String> getNodeImgTxts() {

        java.util.List<String> nodeTxtIds = new java.util.ArrayList<String>();

        for (int i = NODES_START; i < 15; ++i) {
            nodeTxtIds.add(neuronBoxTxtId[i]);
        }

        return nodeTxtIds;
    }
    
    public int getSize() {
        return neuronBox.length;
    }

}
