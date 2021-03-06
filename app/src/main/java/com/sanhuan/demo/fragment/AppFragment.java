package com.sanhuan.demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sanhuan.demo.Adapter.AppListAdapter;
import com.sanhuan.demo.tabletest.ApplyActivity;
import com.sanhuan.demo.tabletest.BillStateActivity;
import com.sanhuan.demo.tabletest.R;
import com.sanhuan.demo.util.L;

import java.util.ArrayList;
import java.util.List;


public class AppFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<String> mList;
    private AppListAdapter adapter;


    private static final int EX_ME_SUBMIT = 0;
    private static final int EX_ME_TO = 1;
    private static final int EX_ME_COPY = 2;
    private static final int SPACE = 3;
    private static final int EX_REIMBURSEMENT = 5;
    private static final int EX_COST = 4;
    private static final int EX_LEAVE = 6;
    private static final int EX_PURCHASE = 7;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        mList = new ArrayList<String>();
        mList.add(getResources().getString(R.string.examination_me_submit));
        mList.add(getResources().getString(R.string.examination_me_to));
        mList.add(getResources().getString(R.string.examination_me_copy));
        mList.add("");
        mList.add(getResources().getString(R.string.examination_cost));
        mList.add(getResources().getString(R.string.examination_Reimbursement));
        mList.add(getResources().getString(R.string.examination_leave));
        mList.add(getResources().getString(R.string.examination_purchase));

        listView = (ListView) view.findViewById(R.id.list);

        adapter = new AppListAdapter(getContext(), mList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case EX_ME_SUBMIT:
                // Intent intentSeeBill = new Intent(getActivity(), SeeBillActivity.class);
                // intentSeeBill.putExtra("Test", "Good");
                // startActivity(intentSeeBill);

                Intent BillState = new Intent(getActivity(), BillStateActivity.class);
                BillState.putExtra("Test", "Good");
                startActivity(BillState);


                break;
            case EX_ME_TO:

                break;
            case EX_ME_COPY:

                break;
            case SPACE:

                break;

            case EX_REIMBURSEMENT:

                break;
            case EX_COST:
                Intent intentApply = new Intent(getActivity(), ApplyActivity.class);
                intentApply.putExtra("Test", "Good");
                startActivity(intentApply);

                break;
            case EX_LEAVE:

                break;
            case EX_PURCHASE:

                break;
        }
    }
}
