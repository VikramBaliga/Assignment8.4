package projects.android.my.gridviewdetails;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] title = {"GingerBread","HoneyComb","Icecream Sandwich","Jellybean","Kitkat","Lolipop"};
    Integer[] imagesList = {
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecreamsandwich,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lolipop
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.myGrid);

        ImageAdapter adapter = new ImageAdapter(imagesList,title);
        gridView.setAdapter(adapter);
    }

    public class ImageAdapter extends BaseAdapter
    {
        String[] title;
        Integer[] imageList;

        public ImageAdapter(Integer[] imageList,String[] title)
        {
            this.imageList=imageList;
            this.title=title;
        }
        @Override
        public int getCount() {
            return imageList.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.customview,null);

            ImageView iView = (ImageView)view.findViewById(R.id.gridImage);
            TextView tView = (TextView)view.findViewById(R.id.gridText);

            iView.setImageResource(imageList[position]);
            tView.setText(title[position]);

            return  view;

        }
    }
}
