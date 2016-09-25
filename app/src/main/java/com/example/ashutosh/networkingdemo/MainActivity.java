package com.example.ashutosh.networkingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ashutosh.networkingdemo.adapter.ContactsRecyclerAdapter;
import com.example.ashutosh.networkingdemo.model.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //region Contacts response
    private String response = "{\n" +
            "    \"contacts\": [\n" +
            "        {\n" +
            "                \"id\": \"c200\",\n" +
            "                \"name\": \"Ravi Tamada\",\n" +
            "                \"email\": \"ravi@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c201\",\n" +
            "                \"name\": \"Johnny Depp\",\n" +
            "                \"email\": \"johnny_depp@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c202\",\n" +
            "                \"name\": \"Leonardo Dicaprio\",\n" +
            "                \"email\": \"leonardo_dicaprio@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c203\",\n" +
            "                \"name\": \"John Wayne\",\n" +
            "                \"email\": \"john_wayne@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c204\",\n" +
            "                \"name\": \"Angelina Jolie\",\n" +
            "                \"email\": \"angelina_jolie@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"female\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c205\",\n" +
            "                \"name\": \"Dido\",\n" +
            "                \"email\": \"dido@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"female\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c206\",\n" +
            "                \"name\": \"Adele\",\n" +
            "                \"email\": \"adele@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"female\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c207\",\n" +
            "                \"name\": \"Hugh Jackman\",\n" +
            "                \"email\": \"hugh_jackman@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c208\",\n" +
            "                \"name\": \"Will Smith\",\n" +
            "                \"email\": \"will_smith@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c209\",\n" +
            "                \"name\": \"Clint Eastwood\",\n" +
            "                \"email\": \"clint_eastwood@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c2010\",\n" +
            "                \"name\": \"Barack Obama\",\n" +
            "                \"email\": \"barack_obama@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c2011\",\n" +
            "                \"name\": \"Kate Winslet\",\n" +
            "                \"email\": \"kate_winslet@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"female\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        },\n" +
            "        {\n" +
            "                \"id\": \"c2012\",\n" +
            "                \"name\": \"Eminem\",\n" +
            "                \"email\": \"eminem@gmail.com\",\n" +
            "                \"address\": \"xx-xx-xxxx,x - street, x - country\",\n" +
            "                \"gender\" : \"male\",\n" +
            "                \"phone\": {\n" +
            "                    \"mobile\": \"+91 0000000000\",\n" +
            "                    \"home\": \"00 000000\",\n" +
            "                    \"office\": \"00 000000\"\n" +
            "                }\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    //endregion

    //private MyContactsAdapter myContactsAdapter = new MyContactsAdapter();
    //ListView listViewContacts;
    ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

    //region List Adapter
    /*class MyContactsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return contactArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return contactArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Contact contact = (Contact) contactArrayList.get(position);
            View v = getLayoutInflater().inflate(R.layout.contact_row, null);
            TextView textViewEmail = (TextView) v.findViewById(R.id.row_email);
            TextView textViewName = (TextView) v.findViewById(R.id.row_name);
            TextView textViewMobile = (TextView) v.findViewById(R.id.row_mobile);
            textViewEmail.setText(contact.getEmail());
            textViewName.setText(contact.getName());
            textViewMobile.setText(contact.getPhone());

            return v;
        }
    }*/
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  listViewContacts = (ListView) findViewById(R.id.list_view_contacts);
        contactArrayList.addAll(parseJsonDataReturnResponseInArrayList(response));

        // listViewContacts.setAdapter(myContactsAdapter);

        //Declare and initialize RecycleView


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ContactsRecyclerAdapter recyclerAdapter = new ContactsRecyclerAdapter(this, contactArrayList);
        recyclerView.setAdapter(recyclerAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

       /* // Items show default animation even if we do not set this
        recyclerView.setItemAnimator(new DefaultItemAnimator());*/
    }


    private ArrayList<Contact> parseJsonDataReturnResponseInArrayList(String response) {
        ArrayList<Contact> contactArrayList = new ArrayList<>();
        try {

            JSONObject rootObject = new JSONObject(response);
            JSONArray contactsArray = rootObject.getJSONArray("contacts");
            for (int i = 0; i < contactsArray.length(); i++) {
                JSONObject contact = (JSONObject) contactsArray.get(i);
                String name = contact.getString("name");
                String email = contact.getString("email");
                JSONObject phone = contact.getJSONObject("phone");
                String mobile = phone.getString("mobile");
                Contact c = new Contact(name, email, mobile);
                contactArrayList.add(c);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return contactArrayList;
    }
}