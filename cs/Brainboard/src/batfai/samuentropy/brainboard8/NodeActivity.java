/*
 * NodeActivity.java
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
package batfai.samuentropy.brainboard8;

class NodeAdapter extends android.widget.BaseAdapter {

    private android.content.Context context;
    java.util.ArrayList<Integer> nodeIds = new java.util.ArrayList<Integer>();

    public void setNodeIds(java.util.ArrayList<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public NodeAdapter(android.content.Context context) {

        cinit(context);
    }

    public NodeAdapter(android.content.Context context, android.util.AttributeSet attrs) {

        cinit(context);
    }

    public NodeAdapter(android.content.Context context,
            android.util.AttributeSet attrs, int defStyle) {

        cinit(context);
    }

    private void cinit(android.content.Context context) {

        this.context = context;
    }

    public int getCount() {
        return nodeIds.size();
    }

    public long getItemId(int position) {
        return nodeIds.get(position);
    }

    public Object getItem(int position) {
        return nodeIds.get(position);
    }

    public android.view.View getView(int position, android.view.View oldView, android.view.ViewGroup parent) {

        android.widget.ImageView imageView;

        if (oldView != null) {
            imageView = (android.widget.ImageView) oldView;
        } else {
            imageView = new android.widget.ImageView(context);
        }

        imageView.setImageResource(nodeIds.get(position));
        return imageView;
    }

}

/**
 *
 * @author nbatfai
 */
public class NodeActivity extends android.app.Activity {

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nodes);

        android.content.Intent intent = getIntent();
        java.util.ArrayList<Integer> nodeIds = intent
                .getIntegerArrayListExtra("nodeIds");

        android.widget.GridView gridView = (android.widget.GridView) findViewById(R.id.nodelist);
        NodeAdapter nodeAdapter = new NodeAdapter(this);
        nodeAdapter.setNodeIds(nodeIds);
        gridView.setAdapter(nodeAdapter);

        gridView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            public void onItemClick(android.widget.AdapterView<?> parent,
                    android.view.View view,
                    int position, long id) {

                android.content.Intent intent = new android.content.Intent();

                intent.setClass(NodeActivity.this, NeuronGameActivity.class);
                intent.setFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("selectedNode", position);
                startActivity(intent);

                NodeActivity.this.finish();

            }
        });

    }
}
