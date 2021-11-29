package com.chalie.tweepspy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TweepSpyList extends AppCompatActivity {
    @BindView(R.id.textViewUserName) TextView mTextViewUserName;
    @BindView(R.id.listViewCves) ListView mListViewCves;
    private String[] tweetedCves = new String[] {"CVE-2021-40444","CVE-2021-34473","CVE-2021-43267","CVE-2021-42321","CVE-2021-2145","CVE-2021-2310","CVE-2021-41379" };
    private String[] product = new String[] {"Windows Server 2022","Exchange Server (2013, 2016, 2016, 2019, 2019)","Linux Kernel","Exchange Server (2016, 2016, 2019, 2019)",
    "Vm Virtualbox","Vm Virtualbox","Windows Server 2022"};
    private String[]  cveInfo = new String[] {"Microsoft MSHTML Remote Code Execution Vulnerability","Microsoft Exchange Server Remote Code Execution Vulnerability This CVE ID is unique from CVE-2021-31196, CVE-2021-31206.",
    "An issue was discovered in net/tipc/crypto.c in the Linux kernel before 5.14.16. The Transparent Inter-Process Communication (TIPC) functionality allows remote attackers to exploit insufficient validation of user-supplied sizes for the MSG_CRYPTO message type.",
    "Microsoft Exchange Server Remote Code Execution Vulnerability","Vulnerability in the Oracle VM VirtualBox product of Oracle Virtualization (component: Core). The supported version that is affected is Prior to 6.1.20. Difficult to exploit vulnerability allows high privileged attacker with logon to the infrastructure where Oracle VM VirtualBox executes to compromise Oracle VM VirtualBox. While the vulnerability is in Oracle VM VirtualBox, attacks may significantly impact additional products. Successful attacks of this vulnerability can result in takeover of Oracle VM VirtualBox. CVSS 3.1 Base Score 7.5 (Confidentiality, Integrity and Availability impacts). CVSS Vector: (CVSS:3.1/AV:L/AC:H/PR:H/UI:N/S:C/C:H/I:H/A:H).",
    "Vulnerability in the Oracle VM VirtualBox product of Oracle Virtualization (component: Core). The supported version that is affected is Prior to 6.1.20. Difficult to exploit vulnerability allows high privileged attacker with logon to the infrastructure where Oracle VM VirtualBox executes to compromise Oracle VM VirtualBox. While the vulnerability is in Oracle VM VirtualBox, attacks may significantly impact additional products. Successful attacks of this vulnerability can result in takeover of Oracle VM VirtualBox. CVSS 3.1 Base Score 7.5 (Confidentiality, Integrity and Availability impacts). CVSS Vector: (CVSS:3.1/AV:L/AC:H/PR:H/UI:N/S:C/C:H/I:H/A:H).",
    "Windows Installer Elevation of Privilege Vulnerability"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweep_spy_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mTextViewUserName.setText("Hello "+username+", here's a list of the trending cve's.");
        TweepSpyListAdapter adapter = new TweepSpyListAdapter(TweepSpyList.this, android.R.layout.simple_list_item_1,tweetedCves,product, cveInfo);
        mListViewCves.setAdapter(adapter);
        mListViewCves.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tweetedCve = ((TextView)view).getText().toString();
                String affectedProduct = product[position];
                String description = cveInfo[position];
                Toast.makeText(TweepSpyList.this,"Loading "+tweetedCve,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(TweepSpyList.this,CveDeetsActivity.class);
                intent.putExtra("tweetedCve",tweetedCve);
                intent.putExtra("affectedProduct",affectedProduct);
                intent.putExtra("description",description);
                startActivity(intent);
            }
        });


    }
}