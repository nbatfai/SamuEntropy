/*
 * NeuronAnimActivity.java
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
package batfai.samuentropy.brainboard9;

/**
 *
 * @author nbatfai
 */
public class NeuronGameActivity extends android.app.Activity {

    public void saveInts(String file, java.util.List<Integer> list) {

        try {
            java.io.FileOutputStream fos = openFileOutput(file, android.content.Context.MODE_PRIVATE);
            java.io.DataOutputStream dos = new java.io.DataOutputStream(fos);
            dos.writeInt(list.size());
            for (Integer i : list) {
                dos.writeInt(i);
            }
            dos.flush();
            dos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    public java.util.List<Integer> loadInts(String file) {

        java.util.ArrayList<Integer> ret = null;

        try {
            java.io.FileInputStream fis = openFileInput(file);

            java.io.DataInputStream dis = new java.io.DataInputStream(fis);

            ret = new java.util.ArrayList<Integer>();
            int size = dis.readInt();
            for (int i = 0; i < size; ++i) {
                ret.add(dis.readInt());
            }
            dis.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            ret = null;
        }

        return ret;
    }

    public void saveTxts(String file, java.util.List<String> list) {

        try {
            java.io.FileOutputStream fos = openFileOutput(file, android.content.Context.MODE_PRIVATE);
            java.io.DataOutputStream dos = new java.io.DataOutputStream(fos);
            dos.writeInt(list.size());
            for (String i : list) {
                dos.writeUTF(i);
            }
            dos.flush();
            dos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }

    public java.util.List<String> loadTxts(String file) {

        java.util.ArrayList<String> ret = null;

        try {
            java.io.FileInputStream fis = openFileInput(file);

            java.io.DataInputStream dis = new java.io.DataInputStream(fis);

            ret = new java.util.ArrayList<String>();
            int size = dis.readInt();
            for (int i = 0; i < size; ++i) {
                ret.add(dis.readUTF());
            }
            dis.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            ret = null;
        }

        return ret;
    }

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        android.content.Intent intent = getIntent();
        android.os.Bundle bundle = intent.getExtras();

        if (bundle != null) {

            int i = bundle.getInt("selectedNode", -1);

            android.util.Log.w("korte", "bundle");

            if (i != -1) {

                intent.removeExtra("selectedNode");
                
                android.util.Log.w("korte", "selected");

                NorbironSurfaceView.addNodeBoxIds(i);

            }

        } else {

            android.util.Log.w("korte", "else bundle");

            java.util.List<Integer> nodeImgIds = loadInts("nodeImgIds");

            if (nodeImgIds != null) {

                NorbironSurfaceView.setNodeImgIds(nodeImgIds);

            }

            java.util.List<Integer> nodeBoxIds = loadInts("nodeBoxIds");
            if (nodeBoxIds != null) {

                NorbironSurfaceView.setNodeBoxIds(nodeBoxIds);

            }

            java.util.List<String> nodeImgTxts = loadTxts("nodeImgTxts");

            if (nodeImgTxts != null) {

                NorbironSurfaceView.setNodeImgTxts(nodeImgTxts);

            }

        }
    }

    @Override
    public void onPause() {
        super.onPause();

        saveInts("nodeImgIds", NorbironSurfaceView.getNodeImgIds());
        saveTxts("nodeImgTxts", NorbironSurfaceView.getNodeImgTxts());
        saveInts("nodeBoxIds", NorbironSurfaceView.getNodeBoxIds());

    }

}
