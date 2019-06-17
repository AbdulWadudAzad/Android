package com.azad.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild; // hashmap contain data of child list

    private CustomAdapter customAdapter;

    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = (ExpandableListView) findViewById(R.id.ExpandableListViewId);
        customAdapter = new CustomAdapter(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String groupName = listDataHeader.get(groupPosition);

                Toast.makeText(getApplicationContext(), groupName + " is Clicked", Toast.LENGTH_SHORT).show();

                return false;
            }
        });


        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                String groupName = listDataHeader.get(groupPosition);

                Toast.makeText(getApplicationContext(), groupName + " is Collapse", Toast.LENGTH_SHORT).show();

            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String childString = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);


                Toast.makeText(getApplicationContext(), childString, Toast.LENGTH_SHORT).show();

                return false;
            }
        });


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && lastExpandedPosition != groupPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }

                lastExpandedPosition = groupPosition;
            }
        });

    }

    public void prepareListData() {

        String[] headerString = getResources().getStringArray(R.array.abbreviation_list_header);
        String[] childString = getResources().getStringArray(R.array.abbreviation_list_cild);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        for (int i = 0; i < headerString.length; i++) {
            //adding header data
            listDataHeader.add(headerString[i]);
// aadding child with header
            List<String> child = new ArrayList<>();
            child.add(childString[i]);

            listDataChild.put(listDataHeader.get(i), child);

        }
    }

}
