/*
 * NodeTypesAdapter.java
 *
 * GretaTheBuilder
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
 * 0.0.1, Oct 15 2016
 */
package batfai.samuentropy.brainboarda;

/**
 *
 * @author nbatfai
 */
class NodeTypesAdapter extends android.widget.BaseAdapter {

    private android.content.Context context;
    java.util.ArrayList<Integer> nodeImgIds = new java.util.ArrayList<Integer>();
    java.util.ArrayList<String> nodeTxts = new java.util.ArrayList<String>();

    public void setNodeIds(java.util.ArrayList<Integer> nodeImgIds) {
        this.nodeImgIds = nodeImgIds;
    }

    public void setNodeIxt(java.util.ArrayList<String> nodeTxts) {
        this.nodeTxts = nodeTxts;
    }

    public NodeTypesAdapter(android.content.Context context, java.util.ArrayList<Integer> nodeImgIds, java.util.ArrayList<String> nodeTxts) {

        cinit(context);
        this.nodeImgIds = nodeImgIds;
        this.nodeTxts = nodeTxts;

    }

    public NodeTypesAdapter(android.content.Context context) {

        cinit(context);
    }

    public NodeTypesAdapter(android.content.Context context, android.util.AttributeSet attrs) {

        cinit(context);
    }

    public NodeTypesAdapter(android.content.Context context,
            android.util.AttributeSet attrs, int defStyle) {

        cinit(context);
    }

    private void cinit(android.content.Context context) {

        this.context = context;
    }

    public int getCount() {
        return nodeImgIds.size();
    }

    public long getItemId(int position) {
        return 0; //nodeImgIds.get(position);
    }

    public Object getItem(int position) {
        return null; //nodeImgIds.get(position);
    }

    protected void setImage(android.widget.ImageView image, int position) {
        try {
            image.setImageResource(nodeImgIds.get(position));
        } catch (IndexOutOfBoundsException e) {
            image.setImageResource(R.drawable.ic_launcher);
        }
    }

    protected void setText(android.widget.TextView text, int position) {
        try {
            text.setText(nodeTxts.get(position));
        } catch (IndexOutOfBoundsException e) {
            text.setText("node");
        }
    }

    public android.view.View getView(int position, android.view.View oldView, android.view.ViewGroup parent) {

        android.widget.LinearLayout linearLayout;

        if (oldView != null) {
            linearLayout = (android.widget.LinearLayout) oldView;
        } else {

            linearLayout = new android.widget.LinearLayout(context);            
            android.widget.AbsListView.LayoutParams linearLayoutParams
                    = new android.widget.AbsListView.LayoutParams(
                            android.widget.AbsListView.LayoutParams.MATCH_PARENT,
                            android.widget.AbsListView.LayoutParams.MATCH_PARENT);
            linearLayout.setGravity(android.view.Gravity.CENTER_VERTICAL);
            linearLayout.setOrientation(android.widget.LinearLayout.VERTICAL);
            linearLayout.setLayoutParams(linearLayoutParams);

            android.widget.ImageView image = new android.widget.ImageView(context);
            android.widget.AbsListView.LayoutParams imageParams
                    = new android.widget.AbsListView.LayoutParams(
                            android.widget.AbsListView.LayoutParams.WRAP_CONTENT,
                            android.widget.AbsListView.LayoutParams.WRAP_CONTENT);
            image.setLayoutParams(imageParams);
            image.setId(1000);
            setImage(image, position);
            linearLayout.addView(image);

            android.widget.TextView text = new android.widget.TextView(context);
            android.widget.AbsListView.LayoutParams textParams
                    = new android.widget.AbsListView.LayoutParams(
                            android.widget.AbsListView.LayoutParams.WRAP_CONTENT,
                            android.widget.AbsListView.LayoutParams.WRAP_CONTENT);
            text.setLayoutParams(textParams);
            text.setId(1001);
            setText(text, position);
            linearLayout.addView(text);

        }

        android.widget.ImageView image = (android.widget.ImageView) linearLayout.findViewById(1000);
        setImage(image, position);
        android.widget.TextView text = (android.widget.TextView) linearLayout.findViewById(1001);
        setText(text, position);

        return linearLayout;

    }

}
